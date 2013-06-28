/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.action;

import com.hosp.bean.ErrorBean;
import com.hosp.bean.ParaBean;
import com.hosp.bean.ParaSearchResultBean;
import com.hosp.bean.SearchParaBean;
import com.hosp.bean.SessionBean;
import com.hosp.bean.StatisticsParaResultBean;
import com.hosp.dao.ExParaDAO;
import com.hosp.dao.ExParaExamsDAO;
import com.hosp.dao.PatientsDAO;
import com.hosp.entities.ExExam;
import com.hosp.entities.ExPara;
import com.hosp.entities.ExParaExams;
import com.hosp.entities.Patients;
import com.hosp.util.CheckUtil;
import com.hosp.util.FacesUtils;
import com.hosp.util.MessageBundleLoader;
import com.hosp.util.PersistenceHelper;
import com.hosp.util.PersistenceUtil;
import com.hosp.util.SystemParameters;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import org.apache.log4j.Logger;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author peukianm
 */
public class ParaAction implements Serializable {

    private static final Logger logger = Logger.getLogger(ParaAction.class);
    private SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
    SearchParaBean searchParaBean = FacesUtils.getManagedBeanJSF2("searchParaBean");
    @EJB
    private PersistenceHelper persistenceHelper;
    @EJB
    private PersistenceUtil persistenceUtil;

    public String searchPara() {
        try {
            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_SEARCHPARA"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("searchPara"));
            return "searchPara?faces-redirect=true ";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }
    
    
    public String dailySearchPara() {
        try {
            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_SEARCHPARA"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("searchPara"));
            //searchParaBean.setSearchFromExecutionDate(new Date());
            //searchParaBean.setSearchToExecutionDate(new Date());
            //searchParaAction();
            
            return "searchDailyPara?faces-redirect=true"; 
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }

    }
    
    

    public void viewAssertionData(ExPara para) {
        try {
            //FacesUtils.callRequestContext("assertionDataDialog.show()");
            searchParaBean.setSelectedPara(para);

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }

    }

    public void removePara() {
        try {

            ExPara para = searchParaBean.getCurrentPara();            
            persistenceHelper.remove(para);
            persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_DELETEPARA")), null, null);
            searchParaAction();
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);            
        }
    }
      
    public void resetSearchPara() {
        try {
//            searchParaBean.setSearchByAssertion(null);
//            searchParaBean.setSearchByPatient(null);
//            searchParaBean.setSearchByPeriod(null);
            searchParaBean.reset();                    
            
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);            
        }
    }
    
      public String editPara(ExPara para) {
        try {
            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_EDITPARA"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("editPara"));
            sessionBean.setParameter(para);
             return "createPara?faces-redirect=true";    //paraID="+para.getParpapemptikoid();
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }

    }       
            
            

    public void viewAssertionExams(ExPara para) {
        try {
            ExParaDAO dao = new ExParaDAO();
            ParaSearchResultBean paraAssertionResult = dao.fetchParaExams(para);
            searchParaBean.setParaData(paraAssertionResult);
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }

    }

    public void searchParaAction() {        
        DataTable dataTable = (DataTable) FacesUtils.findComponent("searchParaForm:paraResults");
        if (dataTable!= null) {
            dataTable.reset();
        }    

        searchParaBean.getParaModel().loadParams(searchParaBean.getSearchByAssertion(), searchParaBean.getSearchByAssertionType(), searchParaBean.getSearchByType(), searchParaBean.getSearchByPeriod(),
                searchParaBean.getSearchByPatient(), searchParaBean.getSearchFromExecutionDate(), searchParaBean.getSearchToExecutionDate(),
                searchParaBean.getSearchFromIssueDate(), searchParaBean.getSearchToIssueDate(), searchParaBean.getSearchByUser(), searchParaBean.getSerachByParaCode(),
                sessionBean.getUsers().getHospital(), true);
    }


    public void statisticsParaAction() {        
        try {
            
            ExParaDAO dao = new ExParaDAO();
            List<StatisticsParaResultBean> data = dao.statisticsPara(sessionBean.getUsers().getHospital(), searchParaBean.getSearchByAssertion(), searchParaBean.getSearchByAssertionType(), searchParaBean.getSearchByPeriod(), searchParaBean.getSearchByType(),
                    searchParaBean.getSearchFromExecutionDate(), searchParaBean.getSearchToExecutionDate(), searchParaBean.getSearchByExam());
            
            searchParaBean.setStatisticsData(data);
            
            
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);            
        }
        
    }
    
    
    
    
    public List<ExExam> completeNameExam(String name) {       
        try {
            ExParaExamsDAO dao = new ExParaExamsDAO();
            if (name != null && !name.trim().isEmpty()) {
                List<ExExam> exams = dao.fetchExamsAutoCompleteName(name.trim());                
                return exams;
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
    
    public void autocompleteNameSelectExam(SelectEvent event) {
        try {
            SearchParaBean searchParaBean =  FacesUtils.getManagedBeanJSF2("searchParaBean");            
            searchParaBean.setSearchByExam(searchParaBean.getSelectedExamByName());
            searchParaBean.setSelectedExamByName(null);
            FacesUtils.updateHTMLComponnetWIthJS("searchParaForm:searchParaPanel");
            
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    
    
    
    
    public List<Patients> completeSurnamePatient(String surname) {

        try {
            if (surname != null && !surname.trim().isEmpty()) {
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

    public void autocompleteSurnameSelectPatient(SelectEvent event) {
        try {

            SearchParaBean searchParaBean = FacesUtils.getManagedBeanJSF2("searchParaBean");
            searchParaBean.setSearchByPatient(searchParaBean.getSelectedSurnamePatient());
            
            searchParaBean.setSelectedSurnamePatient(null);
            FacesUtils.updateHTMLComponnetWIthJS("searchParaForm:searchParaPanel");

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void autocompleteAmkaSelectPatient(SelectEvent event) {
        try {

            SearchParaBean searchParaBean = FacesUtils.getManagedBeanJSF2("searchParaBean");
            searchParaBean.setSearchByPatient(searchParaBean.getSelectedAmkaPatient());

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }
    
    
    public String statisticAnalysis() {
        try {
            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_STATISTICS"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("statisticalData"));
            return "statisticsPara?faces-redirect=true ";
        } catch (Exception e) {
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
            //FacesUtils.redirectAJAX("./templates/error.jsf?faces-redirect=true");
            FacesUtils.redirectAJAX(FacesUtils.getContextPath() + "/templates/error.jsf?faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
