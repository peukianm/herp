package com.hosp.action;

import com.hosp.bean.ApplicationListBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;

import com.hosp.bean.AssertionBean;
import com.hosp.bean.AssertionSearchResultBean;
import com.hosp.bean.ContractBean;
import com.hosp.bean.ErrorBean;
import com.hosp.bean.ParaBean;
import com.hosp.bean.SessionBean;
import com.hosp.dao.ExAssertionDAO;
import com.hosp.dao.ExParaExamsDAO;
import com.hosp.dao.ExPeriodDAO;
import com.hosp.dao.PatientsDAO;
import com.hosp.dao.UsersDAO;
import com.hosp.entities.Country;
import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExExam;
import com.hosp.entities.ExPara;
import com.hosp.entities.ExParaCounter;
import com.hosp.entities.ExParaExams;
import com.hosp.entities.ExPeriod;
import com.hosp.entities.ExTimol;
import com.hosp.entities.Patients;
import com.hosp.eopyy.DapyUtility;
import com.hosp.eopyy.RecordFour;
import com.hosp.eopyy.RecordOne;
import com.hosp.eopyy.RecordThree;
import com.hosp.eopyy.RecordTwo;
import com.hosp.exception.HerpRollbackException;
import com.hosp.model.LazyAssertionDataModel;
import com.hosp.util.CheckUtil;
import com.hosp.util.EJBUtil;
import com.hosp.util.FacesUtils;
import com.hosp.util.FormatUtils;
import com.hosp.util.MessageBundleLoader;
import com.hosp.util.PersistenceHelper;
import com.hosp.util.PersistenceUtil;
import com.hosp.util.SystemParameters;
import com.hosp.util.WSUtil;
import com.hosp.ws.ExamPrescription;
import com.hosp.ws.Examination;
import com.hosp.ws.GetExamPrescriptionResponse;
import java.io.StringWriter;
import java.io.Writer;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.apache.commons.lang3.StringUtils;

public class DapyAction implements Serializable {

    @EJB
    private PersistenceHelper persistenceHelper;
    @EJB
    private PersistenceUtil persistenceUtil;
    private static final Logger logger = Logger.getLogger(DapyAction.class);
    private SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");

    public String viewContracts() {
        try {
            //ContractBean contractBean = (ContractBean) FacesUtils.getManagedBean("contractBean");
            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_VIEWCONTRACTS"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("viewContracts"));
            return "viewContracts?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    public String adminActions() {

        try {
            AssertionBean assertionBean = (AssertionBean) FacesUtils.getManagedBean("assertionBean");
            assertionBean.reset();

            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_ADMINACTIONS"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("actions"));

            return "adminActions?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }
    
    public String refreshViewActions() {

        try {            
            AssertionBean assertionBean = (AssertionBean) FacesUtils.getManagedBean("assertionBean");
            assertionBean.setSelectedResult(null);
            ExAssertionDAO dao = new ExAssertionDAO();
            assertionBean.setAssertionSearchResultBeanList(dao.assertionSearchResults(sessionBean.getUsers().getHospital(), assertionBean.getSearchByOpen(), assertionBean.getShowDeleted(),  null));

            return "";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }
    
    

    public void openSelectContractDialog() {
        try {
            ContractBean contractBean = (ContractBean) FacesUtils.getManagedBean("contractBean");

            if (contractBean.getSelectedContract() == null) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("noContractSelected"));
                FacesUtils.updateHTMLComponnetWIthJS("contractMsg");
            } else {
                FacesUtils.callRequestContext("newAssertionDialog.show()");
            }

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void createPeriodAction() {
        try {
            AssertionBean assertionBean = (AssertionBean) FacesUtils.getManagedBean("assertionBean");
            ExPeriodDAO periodDAO = new ExPeriodDAO();

            if (!periodDAO.checkExistingPeriods(sessionBean.getUsers().getHospital(), assertionBean.getSelectedMonth(), assertionBean.getSelectedYear())) {

                ExPeriod newPeriod = new ExPeriod();
                newPeriod.setExMonth(assertionBean.getSelectedMonth());
                newPeriod.setExYear(assertionBean.getSelectedYear());
                newPeriod.setName(assertionBean.getSelectedMonth().getName() + "/" + assertionBean.getSelectedYear().getName());
                newPeriod.setHospital(sessionBean.getUsers().getHospital());
                newPeriod.setEnabled(new BigDecimal(1));
                persistenceHelper.create(newPeriod);
                persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_CREATEEDAPYPERIOD")), null, null);

                ExPeriodDAO dao2 = new ExPeriodDAO();
                List<ExPeriod> prs = dao2.fetchPeriods(sessionBean.getUsers().getHospital(), true);
                assertionBean.setPeriods(prs);
                assertionBean.setPeriod(newPeriod);

                FacesUtils.callRequestContext("newPeriodDialog.hide()");
                FacesUtils.updateHTMLComponnetWIthJS(":assertionForm");

            } else {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("periodAlreadyInserted"));
            }


        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public int sortPeriod(Object obj1, Object obj2) {
        int value = 0;
        if (obj1 == null || obj2 == null) {
            return value;
        }
        ExPeriod period1 = ((ExPeriod) obj1);
        ExPeriod period2 = ((ExPeriod) obj2);

        if (period1 == null || period2 == null) {
            return value;
        }

        if (period1.getExYear().getYearid().intValue() > period2.getExYear().getYearid().intValue()) {
            value = 1;
            //return value;
        } else if (period1.getExYear().getYearid().intValue() < period2.getExYear().getYearid().intValue()) {
            value = -1;
            //return value;
        } else if (period1.getExYear().getYearid().intValue() == period2.getExYear().getYearid().intValue()) {

            if (period1.getExMonth().getMonthid().intValue() > period2.getExMonth().getMonthid().intValue()) {
                value = 1;
                //return value;
            }

            if (period1.getExMonth().getMonthid().intValue() < period2.getExMonth().getMonthid().intValue()) {
                value = -1;
                //return value;
            }

            if (period1.getExMonth().getMonthid().intValue() == period2.getExMonth().getMonthid().intValue()) {
                value = 0;
                //return value;
            }
        }
        return value;
    }
    
    
    public int sortValid(Object obj1, Object obj2) {
        int value = 0;        
        if (obj1 == null || obj2 == null) {
            return value;
        }
        Boolean valid1 = ((Boolean) obj1);
        Boolean valid2 = ((Boolean) obj2);

        if (valid1 == null || valid2 == null) {
            return value;
        }
        
        
        value = ((Comparable) valid1).compareTo(valid2);        
        return value;
    }

    public String createAssertionAction() {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            ContractBean contractBean = FacesUtils.getManagedBeanJSF2("contractBean");

            ExAssertion newAssertion = new ExAssertion();
            newAssertion.setHospital(sessionBean.getUsers().getHospital());
            newAssertion.setExAssertionType(assertionBean.getSelectedAssertionType());
            newAssertion.setExPeriod(assertionBean.getPeriod());
            newAssertion.setExContract(contractBean.getSelectedContract());
            newAssertion.setExYear(assertionBean.getPeriod().getExYear());
            newAssertion.setExMonth(assertionBean.getPeriod().getExMonth());
            newAssertion.setEnabled(new BigDecimal(1));
            //newAssertion.setSubmission(assertionBean.getSelectedSubmissionType());
            newAssertion.setCode("Δ." + assertionBean.getPeriod().getName() + "."
                    + (assertionBean.getSelectedAssertionType().getAssertiontypeid().intValue() == 1 ? "K" : "Σ")
                    + "." + contractBean.getSelectedContract().getContractnumber());
            newAssertion.setOpened(BigDecimal.ONE);

            persistenceHelper.create(newAssertion);

            ExParaCounter counter = new ExParaCounter();
            counter.setCounter(BigDecimal.ZERO);
            counter.setHospital(sessionBean.getUsers().getHospital());
            counter.setExAssertion(newAssertion);
            persistenceHelper.create(counter);

            persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_CREATEEDAPYADMISSION")), null, null);

            FacesUtils.callRequestContext("newAssertionDialog.hide()");
            //FacesUtils.updateHTMLComponnetWIthJS(":assertionForm");

            return adminActions();

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    public String deleteAssertionAction() {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            if (assertionBean.getSelectedResult() != null && assertionBean.getSelectedResult().getAssertion() != null) {


                ExAssertion assertion = assertionBean.getSelectedResult().getAssertion();
                assertion.setEnabled(new BigDecimal(0));

                persistenceHelper.edit(assertion);
                persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_DELETEEDAPYADMISSION")), null, null);

                assertionBean.setLazyModel(new LazyAssertionDataModel(sessionBean.getUsers().getHospital()));
                FacesUtils.updateHTMLComponnetWIthJS(":assertionForm");
                return adminActions();
            } else {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("noAssertionSelected"));
                return "";
            }

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    public void viewAssertionData() {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            FacesUtils.callRequestContext("assertionDataDialog.show()");
            //FacesUtils.updateHTMLComponnetWIthJS(":assertionForm");


        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public String closeInvoiceDlg() {
        try {
            FacesUtils.callRequestContext("invoiceDialog.hide()");
            return adminActions();
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    public void viewAssertionInvoices() {
        try {

            AssertionBean assertionBean = (AssertionBean) FacesUtils.getManagedBean("assertionBean");

            ExAssertionDAO assertionDAO = new ExAssertionDAO();
            List<ExTimol> temp = assertionDAO.getAssertionTimols(assertionBean.getCurrentResult().getAssertion(), true);

            assertionBean.setInvoiceList(temp);
            assertionBean.setNewInvoice(new ExTimol());
            assertionBean.getNewInvoice().setAmount(assertionBean.getCurrentResult().getNetAmount());
            assertionBean.setSelectedInvoice(null);
//			FacesUtils.partialViewContextComponentReset();
            FacesUtils.resetFormComponents();
            FacesUtils.callRequestContext("invoiceDialog.show()");


//			sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_INVOICE_ADMIN"));
//			sessionBean.setPageName(MessageBundleLoader.getMessage("adminInvoices"));
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void updateAssertion() {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            assertionBean.setUpdateAssertion(assertionBean.getSelectedResult().getAssertion());
            //FacesUtils.callRequestContext("assertionDataDialog.show()");
            //FacesUtils.updateHTMLComponnetWIthJS(":assertionForm");

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public String updateAssertionAction() {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            //ContractBean contractBean = FacesUtils.getManagedBeanJSF2("contractBean");	               
            ExAssertion updateAssertion = assertionBean.getUpdateAssertion();

            updateAssertion.setExYear(updateAssertion.getExYear());
            updateAssertion.setExMonth(updateAssertion.getExMonth());
            updateAssertion.setCode("Δ." + updateAssertion.getExPeriod().getName() + "."
                    + (updateAssertion.getExAssertionType().getAssertiontypeid().intValue() == 1 ? "K" : "Σ")
                    + "." + updateAssertion.getExContract().getContractnumber());

            persistenceHelper.edit(updateAssertion);
            persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_UPDATEEDAPYADMISSION")), null, null);

            //FacesUtils.callRequestContext("newAssertionDialog.hide()");
            //FacesUtils.updateHTMLComponnetWIthJS(":assertionForm");

            return adminActions();

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    public void updateTax() {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            assertionBean.setNewInvoice(assertionBean.getSelectedInvoice());
            FacesUtils.updateHTMLComponnetWIthJS(":invoiceForm:insertInvoicePnael,:invoiceForm:viewInvoicePanel");


        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void updateTaxEvent(ActionEvent event) {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            assertionBean.setNewInvoice(assertionBean.getSelectedInvoice());
            FacesUtils.updateHTMLComponnetWIthJS(":invoiceForm:insertInvoicePanel,:invoiceForm:viewInvoicePanel");

            FacesUtils.updateHTMLComponnetWIthJS(":invoiceForm");
            FacesUtils.updateHTMLComponnetWIthJS("insertInvoicePanel");


        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void invoiceRowSelect() {
        AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
        assertionBean.setNewInvoice(assertionBean.getSelectedInvoice());
    }

    public void updateInvoiceForm() {
        FacesUtils.updateHTMLComponnetWIthJS(":invoiceForm:insertInvoicePanel,:invoiceForm:viewInvoicePanel");
    }

    public void createInvoiceAction() {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            //assertionBean.setInvoiceList ...
            ExTimol newTimol = assertionBean.getNewInvoice();

            if (newTimol.getTimolid() == null) {
                if (CheckUtil.checkTimol(newTimol) == false || CheckUtil.checkForDuplicateTimolNumber(assertionBean.getInvoiceList(), newTimol) == false) {
                    return;
                }
            } else {
                if (CheckUtil.checkTimol(newTimol) == false) {
                    return;
                }
            }

            if (newTimol.getTimolid() != null) {
                ExTimol fetcheTimol = (ExTimol) persistenceHelper.find(ExTimol.class, newTimol.getTimolid());
                // em.find(ExTimol.class, newTimol.getTimolid());
                fetcheTimol.setAmount(newTimol.getAmount());
                fetcheTimol.setTimoldate(newTimol.getTimoldate());
                fetcheTimol.setCode(newTimol.getCode());
                persistenceHelper.edit(fetcheTimol);
                //em.merge(fetcheTimol);
                persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_UPDATEPARAINVOICE")), null, null);

            } else {
                newTimol.setHospital(sessionBean.getUsers().getHospital());
                newTimol.setEnabled(new BigDecimal(1));
                newTimol.setExAssertion(assertionBean.getCurrentResult().getAssertion());
                //em.persist(newTimol);
                persistenceHelper.create(newTimol);
                persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_CREATEPARAINVOICE")), null, null);
            }

//            EntityManagerHelper.commit();

            assertionBean.setNewInvoice(new ExTimol());
            viewAssertionInvoices();

            //FacesUtils.callRequestContext("newAssertionDialog.hide()");
            //FacesUtils.updateHTMLComponnetWIthJS(":assertionForm");

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }

    }

    public void deleteInvoiceAction() {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            if (assertionBean.getSelectedInvoice() != null && assertionBean.getCurrentResult().getAssertion() != null) {

                ExTimol timol = assertionBean.getSelectedInvoice();
                timol.setEnabled(new BigDecimal(0));
                //em.merge(timol);
                //persistenceHelper.edit(timol);
                persistenceHelper.remove(timol);

                persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_DELETEPARAINVOICE")), null, null);
                //EntityManagerHelper.commit();
                assertionBean.setNewInvoice(null);
                assertionBean.setSelectedInvoice(null);
                viewAssertionInvoices();
            } else {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("noInvoiceSelected"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void test(ActionEvent event) {
        AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");

    }

    public void test1(ExParaExams paraExam) {
//         System.out.println("paraExam="+paraExam+" Quanti="+paraExam.getQuantity());
//         System.out.println("GO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111");
    }

    public void createEopyyFile() {
        try {
            AssertionBean assertionBean = FacesUtils.getManagedBeanJSF2("assertionBean");
            AssertionSearchResultBean result = assertionBean.getCurrentResult();
            ExAssertion assertion = result.getAssertion();
            BigDecimal timolAmount = BigDecimal.ZERO;

            if (assertion.getExTimols() == null || assertion.getExTimols().isEmpty()) {
                sessionBean.setAlertMessage(MessageBundleLoader.getMessage("noTimolsInserted"));
                sessionBean.setShowGeneralDialog(Boolean.TRUE);
                return;
            }


            ArrayList rec2List = new ArrayList();
            for (int t = 0; t < assertion.getExTimols().size(); t++) {
                timolAmount = timolAmount.add(assertion.getExTimols().get(t).getAmount());
                RecordTwo record2 = new RecordTwo();                
                record2.setTimAmount(assertion.getExTimols().get(t).getAmount().setScale(2, RoundingMode.HALF_UP).toString());
                record2.setTimDate(FormatUtils.formatDate(assertion.getExTimols().get(t).getTimoldate()));
                record2.setTimNum(assertion.getExTimols().get(t).getCode());
                rec2List.add(record2);
            }


//            System.out.println(timolAmount.setScale(2, RoundingMode.HALF_UP));
//            System.out.println(result.getNetAmount().setScale(2, RoundingMode.HALF_UP));
//
//            System.out.println(timolAmount);
//            System.out.println(result.getNetAmount());
            
            if (!timolAmount.setScale(2, RoundingMode.HALF_UP).equals(result.getNetAmount().setScale(2, RoundingMode.HALF_UP))) {
                sessionBean.setAlertMessage(MessageBundleLoader.getMessage("invalidTimolAmount"));
                sessionBean.setShowGeneralDialog(Boolean.TRUE);
                return;
            }

            List<ExPara> paras = (new ExAssertionDAO()).getParas(assertion);

            RecordOne recordOne = new RecordOne();
            recordOne.setFld05(assertion.getExAssertionType().getAssertiontypeid().add(BigDecimal.ONE.negate()).toString());//0->KANONIKH   1->SYMPLHRVMATIKH            
            recordOne.setFld06(assertion.getHospital().getDapycode()); //Hospital Code
            recordOne.setFld07(assertion.getHospital().getName()); //Hospital nName
            recordOne.setFld08(assertion.getHospital().getAfm()); //Hospital AFM
            recordOne.setFld09(assertion.getHospital().getDoy());  //DOY Code
            recordOne.setFld10(assertion.getExContract().getContractnumber()); //CONTRACT NUMBER
            recordOne.setFld11(assertion.getExPeriod().getExMonth().getName());//Assertion Month
            recordOne.setFld12(assertion.getExPeriod().getExYear().getName());//Assertion Year
            recordOne.setFld13(String.valueOf(assertion.getExTimols().size())); //ARithmos timologiwn            
            recordOne.setFld14(String.valueOf(timolAmount.setScale(2, RoundingMode.HALF_UP))); //Timol amount
            recordOne.setFld15(String.valueOf(paras.size()));// para numbers
            recordOne.setFld16(String.valueOf(result.getCountPara()));// para mount

            recordOne.setTimologia(rec2List);

            ArrayList rec3List = new ArrayList();
            int i = 0;
            for (ExPara para : paras) {
                RecordThree r3 = new RecordThree();
                r3.setFld03(assertion.getHospital().getHunitcode());
                r3.setFld04("0");//Type of Para

                i++;
                r3.setFld05(String.valueOf(i));
                //r3.setFld05(para.getParanumber().toString());

                r3.setFld06(FormatUtils.formatDate(para.getIssuedate()));
                r3.setFld07(para.getDoctorcode());
                r3.setFld08(para.getDoctorsurname());

                r3.setFld09(para.getDoctorname());

                if (para.getApprovaldate() != null) {
                    r3.setFld10(FormatUtils.formatDate(para.getApprovaldate()));
                } else {
                    r3.setFld10("");
                }

                if (para.getCodctorcode() != null) {
                    r3.setFld11(para.getCodctorcode());
                } else {
                    r3.setFld11("-");
                }

                if (para.getCdoctorsurname() != null) {
                    r3.setFld12(para.getCdoctorsurname());
                } else {
                    r3.setFld12("");
                }

                if (para.getCdoctorname() != null) {
                    r3.setFld13(para.getCdoctorname());
                } else {
                    r3.setFld13("");
                }


                r3.setFld14(FormatUtils.formatDate(para.getExecutiondate()));
                r3.setFld15("0");//ENDEIJH EPEIGONTOS 0(OXI) 1(NAI)
                r3.setFld16(""); //KVDIKOS DIAGNVSHS
                r3.setFld17(""); //PERIGRAFH DIAGNVSHS
                r3.setFld18("0"); // 0->ΕΛΛΗΝΑΣ     1->ΕΥΡΩΠΑΙΟΣ




                //AMKA
                if (para.getPatients().getAmka() != null) {
                    Pattern p = Pattern.compile("(\\d){11}");
                    Matcher m = p.matcher(para.getPatients().getAmka());                    
                    if (!m.matches()) {
                        r3.setFld19("-");                        
                    } else {
                        r3.setFld19(para.getPatients().getAmka());                       
                    }
                }


                //AMA
                if (para.getPatients().getInsurance().getInsuranceid().intValue() == 1) {
                    r3.setFld20(para.getPatients().getInsurancenumber());
                } else {
                    r3.setFld20("-");
                }//AMA PATIENT



                r3.setFld21(para.getPatients().getSurname());
                r3.setFld22(para.getPatients().getName());
                r3.setFld23(para.getPatients().getFathername());
                r3.setFld24("");//MOTHER NAME
                r3.setFld25("");//AST. TAYTO
                r3.setFld26("");//AFM 
                r3.setFld27("");//HM GENNHSHS
                r3.setFld28(para.getCountry().getAbbrevation());
                r3.setFld29("0");//IDIOTHTA ASFALISMENOY   0->AMESA  1->EMESA                


                ArrayList rec4List = new ArrayList();
                for (ExParaExams pe : para.getExParaExamses()) {
                    RecordFour r4 = new RecordFour();
                    r4.setProdAmount(pe.getQuantity().toString());
                    r4.setProdCode(pe.getExExam().getCode());
                    
                    
//                    System.out.println("--------------------------------------------------");
//                    System.out.println(pe.getCost());
//                    System.out.println(pe.getCost().setScale(2, RoundingMode.HALF_UP));
//                    System.out.println(pe.getCost().setScale(2, RoundingMode.HALF_UP).toString());
//                    System.out.println(pe.getTotalCost());
//                    System.out.println(pe.getTotalCost().setScale(2, RoundingMode.HALF_UP));
//                    System.out.println(pe.getTotalCost().setScale(2, RoundingMode.HALF_UP).toString());
//                    System.out.println("--------------------------------------------------");
                    
                    r4.setProdUnitCost(pe.getCost().setScale(2, RoundingMode.HALF_UP).toString());
                    r4.setProdTotalCost(pe.getTotalCost().setScale(2, RoundingMode.HALF_UP).toString());
                    rec4List.add(r4);
                }

                r3.setProducts(rec4List);
                rec3List.add(r3);
            
                //break;
            }

            recordOne.setParapemptika(rec3List);

            DapyUtility dapyUtility = new DapyUtility();
            StringWriter fileData = dapyUtility.createHL7File(recordOne);
            if (fileData == null) {
//                sessionBean.setAlertMessage(MessageBundleLoader.getMessage("errorCreatingEopyyFile"));
//                FacesUtils.callRequestContext("alertMessageDialog.show()");
//                FacesUtils.updateHTMLComponnetWIthJS("primeAlertPanel");
                sessionBean.setShowGeneralDialog(Boolean.TRUE);
//                FacesUtils.updateHTMLComponnetWIthJS("primeAlertPanel");
                return;
            }



//           HttpServletResponse response = FacesUtils.getHttpResponse();
            ExternalContext ec = FacesUtils.getExternalContext();
            ec.responseReset();
            ec.setRequestCharacterEncoding("ISO-8859-7");
            ec.setResponseContentType("text/plain; charset=ISO-8859-7");
            ec.setResponseHeader("Content-Disposition", "attachment; filename=\"diag1.txt\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.
            Writer responseWriter = ec.getResponseOutputWriter();
            responseWriter.write(fileData.toString());

//            BufferedInputStream input = null;
//            BufferedOutputStream output = null;

//            try {
//                input = new BufferedInputStream(fileData.getBuffer());
//                output = new BufferedOutputStream(response.getOutputStream());
//
//                byte[] buffer = new byte[10240];
//                for (int length; (length = input.read(buffer)) > 0;) {
//                    output.write(buffer, 0, length);
//                }
//            } finally {
//                close(output);
//                close(input);
//            }


            FacesUtils.getFacesContext().responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }
    
    

    public String createPara() {

        try {
            sessionBean.setParameter(null);
            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
            paraBean.reset();

            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_CREATEPARA"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("insertPara"));



//            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
//            paraBean.setAssertions ((new ExAssertionDAO()).getAssertions(sessionBean.getUsers().getHospital(), true, true));
//                
//            ExPara para = new ExPara();                
//            para.setHospital(sessionBean.getUsers().getHospital());
//            para.setExecutiondate(new Date());
//            para.setCodehealthunit(sessionBean.getUsers().getHospital().getHunitcode());
//            para.setDoctorcode("-");
//            para.setUsers(sessionBean.getUsers());
//            if (sessionBean.getCurrentNormalAssertion() != null) {
//                para.setExAssertion(sessionBean.getCurrentNormalAssertion());
//                para.setExPeriod(sessionBean.getCurrentNormalAssertion().getExPeriod());
//                para.setExContract(sessionBean.getCurrentNormalAssertion().getExContract());
//            }
//            
//            paraBean.setNewPara(para);
//            paraBean.setSelectedPatient(new Patients());        

            //redirect("page1?paraid=" + paraid) ?faces-redirect=true ;;
            return "createPara?faces-redirect=true "; //paraBean.

//            if (sessionBean.getTameio() == null) {
//                sessionBean.setAlertMessage(MessageBundleLoader.getMessage("noTameioSelected"));
//                FacesUtils.callRequestContext("alertMessageDialog.show()");
//                FacesUtils.updateHTMLComponnetWIthJS("primeAlertPanel");
//                return "";
//            } else {
//                sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_CREATEPARA"));
//                sessionBean.setPageName(MessageBundleLoader.getMessage("insertPara"));
//
//                //redirect("page1?paraid=" + paraid) ?faces-redirect=true ;;
//                return "createPara?faces-redirect=true ";
//            }

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }

    }

    public void showPatientDialog() {
        try {
            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
//            CleanForms cf = new CleanForms();
//            cf.process();

            paraBean.setSelectedPatient(new Patients());
            paraBean.setSelectedPatientByAmka(null);
            paraBean.setSelectedPatientBySurname(null);
            paraBean.setTempAmka(null);



        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public List<Patients> completeSurnamePatient(String surname) {       
        try {            
            if (surname != null && !surname.trim().isEmpty() && surname.trim().length()>2) {
                surname = surname.trim();
                PatientsDAO patientDAO = new PatientsDAO();
                List<Patients> patients = patientDAO.fetchPatientAutoCompleteSurname(surname);
                return patients;
            } else {
                return null;
            }


        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return null;
        }
    }

    public List<Patients> completeAmkaPatient(String amka) {

        try {

            if (amka != null && !amka.trim().isEmpty()) {
                amka = amka.trim();
                PatientsDAO patientDAO = new PatientsDAO();
                List<Patients> patients = patientDAO.fetchPatientAutoCompleteAMKA(amka);
                return patients;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return null;
        }
    }

    public List<ExParaExams> completeCodeParaExam(String code) {
        ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
        try {
            ExParaExamsDAO dao = new ExParaExamsDAO();
            if (code != null && !code.trim().isEmpty()) {
                List<ExParaExams> paraExams = dao.fetchParaExamsAutoCompleteCode(code.trim(), paraBean.getNewPara());
                paraBean.setTempExParaExams(paraExams);
                return paraExams;
            } else {
                return null;

            }

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return null;
        }
    }

    public List<ExParaExams> completeNameParaExam(String name) {
        ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
        try {
            ExParaExamsDAO dao = new ExParaExamsDAO();
            if (name != null && !name.trim().isEmpty()) {
                List<ExParaExams> paraExams = dao.fetchParaExamsAutoCompleteName(name.trim(), paraBean.getNewPara());
                paraBean.setTempExParaExams(paraExams);
                return paraExams;
            } else {
                return null;

            }

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return null;
        }
    }

    public void autocompleteSurnameSelectPatient(SelectEvent event) {
        try {

            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");

            paraBean.setSelectedPatient(paraBean.getSelectedPatientBySurname());
            String amka = paraBean.getSelectedPatientBySurname().getAmka();

            if (amka != null) {
                Pattern p = Pattern.compile("(\\d){11}");
                Matcher m = p.matcher(amka);
                if (!m.matches()) {
                    amka = null;
                }
            }
            paraBean.setTempAmka(amka);

            paraBean.setSelectedPatientBySurname(null);

            //FacesUtils.resetFormComponents("selectPatientForm");
            List<String> ids = new ArrayList<String>();
            ids.add("selectPatientForm:selectedPatientName");
            ids.add("selectPatientForm:selectedPatientSurname");
            ids.add("selectPatientForm:selectedPatientFatherName");
            ids.add("selectPatientForm:selectedPatientAmka");
            ids.add("selectPatientForm:selectedPatientInsuranceNumber");
            ids.add("selectPatientForm:insertInsurance");
            FacesUtils.resetSpecificComponents(ids);


        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void autocompleteAmkaSelectPatient(SelectEvent event) {
        try {

            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");

            paraBean.setSelectedPatient(paraBean.getSelectedPatientByAmka());
            String amka = paraBean.getSelectedPatientByAmka().getAmka();

            if (amka != null) {
                Pattern p = Pattern.compile("(\\d){11}");
                Matcher m = p.matcher(amka);
                if (!m.matches()) {
                    amka = null;
                }
            }
            paraBean.setTempAmka(amka);

            paraBean.setSelectedPatientByAmka(null);

            List<String> ids = new ArrayList<String>();
            ids.add("selectPatientForm:selectedPatientName");
            ids.add("selectPatientForm:selectedPatientSurname");
            ids.add("selectPatientForm:selectedPatientFatherName");
            ids.add("selectPatientForm:selectedPatientAmka");
            ids.add("selectPatientForm:selectedPatientInsuranceNumber");
            ids.add("selectPatientForm:insertInsurance");
            FacesUtils.resetSpecificComponents(ids);

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void autocompleteCodeSelectParaExam(SelectEvent event) {
        try {

            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
            ExParaExams paraExam = paraBean.getSelectedParaExamByCode();
            List<ExParaExams> exams = paraBean.getParaExams();
            if (!CheckUtil.checkForDuplicateParaExams(exams, paraExam)) {
                paraBean.setSelectedParaExamByCode(null);
                return;
            }
            exams.add(paraExam);
            paraBean.setParaExams(exams);
            paraBean.setSelectedParaExamByCode(null);

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void autocompleteNameSelectParaExam(SelectEvent event) {
        try {

            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
            ExParaExams paraExam = paraBean.getSelectedParaExamByName();
            List<ExParaExams> exams = paraBean.getParaExams();
            if (!CheckUtil.checkForDuplicateParaExams(exams, paraExam)) {
                paraBean.setSelectedParaExamByName(null);
                return;
            }
            exams.add(paraExam);
            paraBean.setParaExams(exams);
            paraBean.setSelectedParaExamByName(null);
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void removeExam(ExParaExams exam) {
        try {
            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
            List<ExParaExams> exams = paraBean.getParaExams();

            if (exam.getParaexamid() != null) {
                if (exams.size() <= 1) {
                    FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("zeroExamPara"));
                    return;
                }
                exams.remove(exam);
                FacesUtils.updateHTMLComponnetWIthJS("createParaForm:updateButton");
                persistenceHelper.remove(exam);
                //FacesUtils.addInfoMessage(MessageBundleLoader.getMessage("updateParaSuccess"));
            } else {
                exams.remove(exam);
                FacesUtils.updateHTMLComponnetWIthJS("createParaForm:createButton");
            }

            paraBean.setParaExams(exams);
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void insertPatientsAction() {
        try {
            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");

            if (CheckUtil.checkPatient(paraBean.getSelectedPatient()) == false) {
                return;
            }
            paraBean.getNewPara().setPatients(paraBean.getSelectedPatient());


            if (paraBean.getSelectedPatient() != null && paraBean.getSelectedPatient().getPatientid() != null) {

                if ((paraBean.getSelectedPatient().getAmka() != null && paraBean.getTempAmka().equals(paraBean.getSelectedPatient().getAmka())) || !new PatientsDAO().checkAMKA(paraBean.getTempAmka())) {

                    if (paraBean.getSelectedPatient().getInsurance().getInsuranceid().intValue() == 1) {
                        paraBean.setIkaCode(paraBean.getSelectedPatient().getInsurancenumber());
                    } else {
                        paraBean.setIkaCode("-");
                    }

                    paraBean.setPatientName(paraBean.getSelectedPatient().getName());
                    paraBean.setPatientSurname(paraBean.getSelectedPatient().getSurname());
                    paraBean.setPatientAmka(paraBean.getTempAmka());
                    paraBean.getSelectedPatient().setAmka(paraBean.getTempAmka());

                    persistenceHelper.edit(paraBean.getSelectedPatient());
                    persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_UPDATEPATIENTDATA")), null, null);

                    FacesUtils.callRequestContext("selectPatient.hide();");
                } else {
                    sessionBean.setAlertMessage(MessageBundleLoader.getMessage("amkaAlreadyExists"));
                    FacesUtils.callRequestContext("alertMessageDialog.show()");
                    FacesUtils.updateHTMLComponnetWIthJS("primeAlertPanel");
                }

            } else {
                if (!new PatientsDAO().checkAMKA(paraBean.getTempAmka())) {

                    if (paraBean.getSelectedPatient().getInsurance().getInsuranceid().intValue() == 1) {
                        paraBean.setIkaCode(paraBean.getSelectedPatient().getInsurancenumber());
                    } else {
                        paraBean.setIkaCode("-");
                    }

                    paraBean.setPatientName(paraBean.getSelectedPatient().getName());
                    paraBean.setPatientSurname(paraBean.getSelectedPatient().getSurname());
                    paraBean.setPatientAmka(paraBean.getTempAmka());
                    paraBean.getSelectedPatient().setAmka(paraBean.getTempAmka());
                    paraBean.getSelectedPatient().setEnable(new BigDecimal(1));

                    persistenceHelper.create(paraBean.getSelectedPatient());
                    persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_INSERTPATIENT")), null, null);
                    paraBean.setSelectedPatient(new PatientsDAO().fetchPatientFromDB(paraBean.getSelectedPatient()));
                    paraBean.getNewPara().setPatients(paraBean.getSelectedPatient());

                    FacesUtils.callRequestContext("selectPatient.hide();");
                } else {
                    sessionBean.setAlertMessage(MessageBundleLoader.getMessage("amkaAlreadyExists"));
                    FacesUtils.callRequestContext("alertMessageDialog.show()");
                    FacesUtils.updateHTMLComponnetWIthJS("primeAlertPanel");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void massInsertExams() {
        try {
            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
            List<ExParaExams> exams = paraBean.getParaExams();
            Iterator it = paraBean.getSelectedExams().entrySet().iterator();
            ExParaExamsDAO dao = new ExParaExamsDAO();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                if ((Boolean) pairs.getValue()) {
                    if (CheckUtil.checkForDuplicateParaExams(exams, (ExExam) pairs.getKey())) {
                        exams.add(dao.fetchParaExamFromExam((ExExam) pairs.getKey(), paraBean.getNewPara()));
                    }
                }
            }

            paraBean.setParaExams(exams);
            paraBean.setSelectedExams(new HashMap<ExExam, Boolean>());

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void handleDateSelect(DateSelectEvent event) {
        try {
            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
            paraBean.getNewPara().setApprovaldate(paraBean.getNewPara().getIssuedate());
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void handleDateSelectListener() {
        try {
            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public String createParaAction() {

        UserTransaction userTransaction = null;
        try {
            userTransaction = persistenceHelper.getUserTransaction();

            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
            if (!CheckUtil.checkPara(paraBean.getNewPara())) {
                return "";
            }
            if (paraBean.getNewPara().getPatients() == null || paraBean.getNewPara().getPatients().getPatientid() == null) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("noPatientSelected"));
                return "";
            }

            paraBean.getNewPara().setExParaExamses(paraBean.getParaExams());
            ExAssertionDAO dao = new ExAssertionDAO();
            paraBean.getNewPara().setExPeriod(paraBean.getNewPara().getExAssertion().getExPeriod());
            paraBean.getNewPara().setEnabled(new BigDecimal(1));
            paraBean.getNewPara().setInsurance(paraBean.getNewPara().getPatients().getInsurance());
            paraBean.getNewPara().setExContract(paraBean.getNewPara().getExAssertion().getExContract());

            userTransaction.begin();

            ExParaCounter counter = dao.getCurrentParaCounter(sessionBean.getUsers().getHospital(), paraBean.getNewPara().getExAssertion());
            paraBean.getNewPara().setParanumber(counter.getCounter().add(BigDecimal.ONE));
            paraBean.getNewPara().setParacode(StringUtils.leftPad(paraBean.getNewPara().getExAssertion().getExPeriod().getExYear().getName() + paraBean.getNewPara().getExAssertion().getExPeriod().getExMonth().getName() + "-" + paraBean.getNewPara().getParanumber(), 11, "0"));
            counter.setCounter(counter.getCounter().add(BigDecimal.ONE));

            persistenceHelper.edit(counter);
            persistenceHelper.create(paraBean.getNewPara());
            persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_CREATEPARA")), null, null);

            userTransaction.commit();

            FacesUtils.addInfoMessage(MessageBundleLoader.getMessage("createParaSuccess") + " - " + counter.getCounter());
            paraBean.reset();

            return "createPara"; // 
        } catch (Exception e) {
            try {
                userTransaction.rollback();
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }
    
    
    public void getParaDataFromBarcode() {
        try {    
                        
            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
            
            if (paraBean.getNewPara().getBarcode()==null)
                return;
            
            
            GetExamPrescriptionResponse examPrescriptionResponse  = WSUtil.getParaFromEOPYY(paraBean.getNewPara().getBarcode(), sessionBean.getUsers().getHospital());
            System.out.println("BARCODE="+paraBean.getNewPara().getBarcode());
            System.out.println("examPrescriptionResponse="+examPrescriptionResponse);
            System.out.println("examPrescriptionResponse.getExamPrescription()="+ examPrescriptionResponse.getExamPrescription());            
            System.out.println("getExamPrescriptionResponse.getResponse()="+examPrescriptionResponse.getResponse());
            
            
            if (examPrescriptionResponse==null || examPrescriptionResponse.getExamPrescription()==null ) {
                FacesUtils.addInfoMessage(MessageBundleLoader.getMessage("noExamPrescriptionResponse"));
                return;
            }
            
            ExamPrescription examPrescription = examPrescriptionResponse.getExamPrescription();
            
            
            System.out.println("examPrescription.getPatientMemberTypeId()="+examPrescription.getPatientMemberTypeId());
            System.out.println("examPrescription.getPatientSocInsName()="+examPrescription.getPatientSocInsName());
            System.out.println("examPrescription.getPatientSocialInsuranceId()="+examPrescription.getPatientSocialInsuranceId());                     
            System.out.println("examPrescription.getPatientSocInsShortName()="+examPrescription.getPatientSocInsShortName());
            System.out.println("examPrescription.getStatus()="+ examPrescription.getStatus());
            
            
            //CHECKING PATIENT ENTRY
            PatientsDAO patientsDAO = new PatientsDAO();
            String amka = examPrescription.getPatientAMKA();
            System.out.println("CHECKING AMKA");
            if (amka!=null && CheckUtil.checkAmka(amka)) {
                 List<Patients> patients = patientsDAO.findByAmka(examPrescription.getPatientAMKA());
                 if (!patients.isEmpty()) {                     
                     Patients patient = patients.get(0);
                     paraBean.setExamPrescription(examPrescription);
                     patient.setAddress(examPrescription.getPatientAddress());
                     patient.setPhone(examPrescription.getPatientTelephone());
                     patient.setName(examPrescription.getPatientFirstName());
                     patient.setSurname(examPrescription.getPatientLastName());
                     patient.setInsurancenumber(examPrescription.getPatientAMA());                     
                     patient.setDateofbirth(examPrescription.getPatientBirthDate().getTime());
                     System.out.println("examPrescription.getPatientMemberTypeId()="+examPrescription.getPatientMemberTypeId());
                     System.out.println("examPrescription.getPatientSocInsName()="+examPrescription.getPatientSocInsName());
                     System.out.println("examPrescription.getPatientSocialInsuranceId()="+examPrescription.getPatientSocialInsuranceId());                     
                     System.out.println("examPrescription.getPatientSocInsShortName()="+examPrescription.getPatientSocInsShortName());
                     System.out.println("examPrescription.getStatus()="+ examPrescription.getStatus());
                                         
                     
                     patient = persistenceHelper.editPersist(patient);
                     paraBean.getNewPara().setPatients(patient);                     
                     //patient.setDirect(examPrescription.getPatientMemberTypeId())
                     //patient.setInsurance(null);                     
                 }            
            }
            
            paraBean.getNewPara().setDoctorname(examPrescription.getDoctorFirstName());
            paraBean.getNewPara().setDoctorsurname(examPrescription.getDoctorLastName());
            //paraBean.getNewPara().setDoctorcode(examPrescription.getDoctorAMKA());
            
            paraBean.getNewPara().setIssuedate(examPrescription.getIssueDate().getTime());
            paraBean.getNewPara().setApprovaldate(examPrescription.getIssueDate().getTime());
            
            Examination[] examinations = examPrescription.getExaminations();
            
            //List<ExParaExams> exams = new ArrayList<ExParaExams>();
            //paraBean.setParaExams(new ArrayList<ExParaExams>());
            
            int size = paraBean.getParaExams().size();
            for (int index=size-1; index>=0; index--) {
                System.out.println("REMOVING INDEX="+index);
                paraBean.getParaExams().remove(index);
            }
            
            
            
            System.out.println("paraBean.getParExams="+paraBean.getParaExams());
            System.out.println("paraBean.getParaExams().size="+paraBean.getParaExams().size());
            
            for (int g=0; g<examinations.length; g++) {
                Examination examination = examinations[g];
                String code = examination.getEDapiCode();
                System.out.println("COde="+code);
                ExParaExams paraExam = (new ExParaExamsDAO()).fetchParaExamFromExamCode(code, paraBean.getNewPara());        
                //exams.add(paraExam);
                paraBean.getParaExams().add(paraExam);            
            }
            
            System.out.println("paraBean.getParaExams().size="+paraBean.getParaExams().size());
            //paraBean.setParaExams(exams);                        
            FacesUtils.addInfoMessage(MessageBundleLoader.getMessage("prescriptionDataInserted"));
            
                     
        } catch (Exception e) {           
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);            
        }
    }

    public String updateParaAction() {
        UserTransaction userTransaction = null;
        try {

            userTransaction = persistenceHelper.getUserTransaction();
            ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");

            if (!CheckUtil.checkPara(paraBean.getNewPara())) {
                return "";
            }

            if (paraBean.getNewPara().getPatients() == null) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("noPatientSelected"));
                return "";
            }

            userTransaction.begin();
            paraBean.getNewPara().setExParaExamses(paraBean.getParaExams());
            paraBean.getNewPara().setExPeriod(paraBean.getNewPara().getExAssertion().getExPeriod());
            paraBean.getNewPara().setParacode(StringUtils.leftPad(paraBean.getNewPara().getExAssertion().getExPeriod().getExYear().getName() + paraBean.getNewPara().getExAssertion().getExPeriod().getExMonth().getName() + "-" + paraBean.getNewPara().getParanumber(), 11, "0"));
            paraBean.getNewPara().setInsurance(paraBean.getNewPara().getPatients().getInsurance());
            paraBean.getNewPara().setExContract(paraBean.getNewPara().getExAssertion().getExContract());
            paraBean.getNewPara().setEnabled(new BigDecimal(1));

            persistenceHelper.edit(paraBean.getNewPara());
            persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_UPDATEPARA")), null, null);

            FacesUtils.addInfoMessage(MessageBundleLoader.getMessage("updateParaSuccess"));
            sessionBean.setParameter(paraBean.getNewPara());
            userTransaction.commit();
            return ""; //"createPara?faces-redirect=true";

        } catch (Exception e) {
            try {
                userTransaction.rollback();
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }

    }

    public void goError(Exception ex) {
        try {
            logger.error("-----------AN ERROR HAPPENED !!!! -------------------- : " + ex.toString());
            if (sessionBean.getUsers() != null) {
                logger.error("User=" + sessionBean.getUsers().getUsername());
            }
            logger.error("Cause=" + ex.getCause());
            logger.error("Class=" + ex.getClass());
            logger.error("Message=" + ex.getLocalizedMessage());
            logger.error(ex, ex);
            logger.error("--------------------- END OF ERROR --------------------------------------------------------\n\n");
            ErrorBean errorBean = (ErrorBean) FacesUtils.getManagedBean("errorBean");
            errorBean.reset();
            errorBean.setErrorMSG(MessageBundleLoader.getMessage(sessionBean.getErrorMsgKey()));

            //FacesUtils.redirectAJAX("/templates/error.jsf?faces-redirect=true");
            FacesUtils.redirectAJAX(FacesUtils.getContextPath() + "/templates/error.jsf?faces-redirect=true");
            //return  "/templates/error?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String logoutAction() {
        try {
            FacesUtils.resetManagedBeanJSF2("sessionBean");
            FacesUtils.invalidateSession();
            return "loginPage?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    public String goError() {
        ErrorBean errorBean = (ErrorBean) FacesUtils.getManagedBean("errorBean");
        errorBean.reset();
        errorBean.setErrorMSG(MessageBundleLoader.getMessage(sessionBean.getErrorMsgKey()));
        return "templates/error?faces-redirect=true";
    }
}
