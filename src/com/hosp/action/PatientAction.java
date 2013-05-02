/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.action;

import com.hosp.bean.ErrorBean;
import com.hosp.bean.PatientBean;
import com.hosp.bean.SessionBean;
import com.hosp.dao.PatientsDAO;
import com.hosp.entities.ExPara;
import com.hosp.entities.Patients;
import com.hosp.util.CheckUtil;
import com.hosp.util.EJBUtil;
import com.hosp.util.FacesUtils;
import com.hosp.util.MessageBundleLoader;
import com.hosp.util.PersistenceHelper;
import com.hosp.util.PersistenceUtil;
import com.hosp.util.SystemParameters;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.transaction.UserTransaction;
import org.apache.log4j.Logger;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author peukianm
 */
public class PatientAction implements Serializable {

    private static final Logger logger = Logger.getLogger(PatientAction.class);
    private SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
    @EJB
    private PersistenceHelper persistenceHelper;
    @EJB
    private PersistenceUtil persistenceUtil;

    public String searchPatient() {
        try {
            PatientBean patientBean = (PatientBean) FacesUtils.getManagedBean("patientBean");
            patientBean.reset();

            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_SEARCHPATIENT"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("searchPatient"));
            return "searchPatient?faces-redirect=true ";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    public String createPatient() {
        try {
//            PatientBean patientBean = (PatientBean) FacesUtils.getManagedBean("patientBean");
//            patientBean.reset();

            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_CREATEPATIENT"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("createPatient"));
            return "createPatient?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }

    }

    public String editPatient(Patients patient) {
        try {
            sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EDITPATIENT"));
            sessionBean.setPageName(MessageBundleLoader.getMessage("editPatient"));
            sessionBean.setParameter(patient);
            PatientBean patientBean = (PatientBean) FacesUtils.getManagedBean("patientBean");
            patientBean.init();
            //?faces-redirect=true&patientID=" + patient.getPatientid();
            return "createPatient?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }

    }

    public void resetSearchPatient() {
        try {
            PatientBean patientBean = (PatientBean) FacesUtils.getManagedBean("patientBean");
            patientBean.reset();

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public void searchPatientAction() {
        DataTable dataTable = (DataTable) FacesUtils.findComponent("searchPatientForm:patientResults");
        if (dataTable != null) {
            dataTable.reset();
        }

        PatientBean patientBean = (PatientBean) FacesUtils.getManagedBean("patientBean");
        patientBean.getPatientModel().loadParams(patientBean.getSearchByName(), patientBean.getSearchBySurname(), patientBean.getSearchByAmka(),
                patientBean.getSearchFromBirth(), patientBean.getSearchToBirth(), patientBean.getSearchByInsurance(), true);
    }

    public void removePatient() {
        try {
            PatientBean patientBean = (PatientBean) FacesUtils.getManagedBean("patientBean");
            Patients patient = patientBean.getCurrentPatient();
            patient.setEnable(BigDecimal.ZERO);
            persistenceHelper.edit(patient);
            persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_UPDATEPATIENTDATA")), null, null);
            searchPatientAction();
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    public String createPatientAction() {        
        PatientBean patientBean = (PatientBean) FacesUtils.getManagedBean("patientBean");
        Patients patient = patientBean.getNewPatient();
        UserTransaction userTransaction = null;
        try {
            userTransaction = persistenceHelper.getUserTransaction();
            userTransaction.begin();
            if (CheckUtil.checkPatient(patient) == false) {
                return "";
            }

            if (!new PatientsDAO().checkAMKA(patientBean.getTempAmka())) {
                patient.setAmka(patientBean.getTempAmka());
                patient.setEnable(new BigDecimal(1));
                persistenceHelper.create(patient);
                persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_INSERTPATIENT")), null, null);
                FacesUtils.addInfoMessage(MessageBundleLoader.getMessage("createPatientSuccess"));
            } else {
                sessionBean.setAlertMessage(MessageBundleLoader.getMessage("amkaAlreadyExists"));
                FacesUtils.callRequestContext("alertMessageDialog.show()");
                FacesUtils.updateHTMLComponnetWIthJS("primeAlertPanel");
            }

            userTransaction.commit();
            return createPatient();
        } catch (Exception e) {
            try {
                userTransaction.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    public String updatePatientAction() {        
        PatientBean patientBean = (PatientBean) FacesUtils.getManagedBean("patientBean");
        Patients patient = patientBean.getNewPatient();        
        UserTransaction userTransaction = null;
        try {
            userTransaction = persistenceHelper.getUserTransaction();
            userTransaction.begin();
            if (CheckUtil.checkPatient(patient) == false) {
                return "";
            }

            if ((patient.getAmka() != null && patientBean.getTempAmka().equals(patient.getAmka())) || !new PatientsDAO().checkAMKA(patientBean.getTempAmka())) {
                patient.setAmka(patientBean.getTempAmka());
                persistenceHelper.edit(patient);
                persistenceUtil.audit(sessionBean.getUsers(), new BigDecimal(SystemParameters.getInstance().getProperty("ACT_UPDATEPATIENTDATA")), null, null);
                FacesUtils.addInfoMessage(MessageBundleLoader.getMessage("updatePatientSuccess"));

            } else {
                sessionBean.setAlertMessage(MessageBundleLoader.getMessage("amkaAlreadyExists"));
                FacesUtils.callRequestContext("alertMessageDialog.show()");
                FacesUtils.updateHTMLComponnetWIthJS("primeAlertPanel");
            }

            sessionBean.setParameter(patient);
            userTransaction.commit();
            return "";
        } catch (Exception e) {
            try {
                userTransaction.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
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
            //FacesUtils.redirectAJAX("./templates/error.jsf?faces-redirect=true");
            FacesUtils.redirectAJAX(FacesUtils.getContextPath() + "/templates/error.jsf?faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
