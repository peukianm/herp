/**
 *
 */
package com.hosp.action;

import com.hosp.bean.*;
import com.hosp.dao.*;
import com.hosp.entities.Admission;
import com.hosp.entities.ExTameio;
import com.hosp.entities.RecipeDrugs;
import com.hosp.entities.Userroles;
import com.hosp.entities.Users;
import com.hosp.util.FacesUtils;
import com.hosp.util.FormatUtils;
import com.hosp.util.MessageBundleLoader;
import com.hosp.util.PersistenceUtil;
import com.hosp.util.SystemParameters;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import org.apache.log4j.Logger;

public class AdministrationAction implements Serializable {

    UsersDAO userDAO = new UsersDAO();
    private static final Logger logger = Logger.getLogger(AdministrationAction.class);
    private SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
    @EJB
    private PersistenceUtil persistenceUtil;

    public AdministrationAction() {
    }

    public String loginAction() {
        try {
//            ExAssertionDAO dao = new ExAssertionDAO();
//            dao.test();  
            
            UserBean userBean = (UserBean) FacesUtils.getManagedBean("userBean");
            Users temp = userDAO.findUser(userBean.getUsername(), userBean.getPassword());
            if (temp == null) {
                userBean.setPassword(null);
                sessionBean.setErrorMsgKey("errMsg_InvalidCredentials");
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("errMsg_InvalidCredentials"));
                return "loginPage";
            }    

            
            List<Userroles> userroles = userDAO.getUserRoles(temp);
            
            System.out.println("userroles="+userroles);
            temp.setUserroles(userroles);
            sessionBean.setUsers(temp);
            
            
            ddddd1
            
            FacesUtils.callRequestContext("selectRoleDialog.show()");
                        
            
            
            
//            // EXOTERIKA IATREIA APPLICATION
//            if (temp.getRole().getRoleid().intValue() == 6 || temp.getRole().getRoleid().intValue() == 7 || temp.getRole().getRoleid().intValue() == 8) {			
//                
//                persistenceUtil.audit(temp, new BigDecimal(SystemParameters.getInstance().getProperty("ACT_LOGINUSER")), null, null);
//
//                int year = Calendar.getInstance().get(Calendar.YEAR);
//                int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
//
//                ExAssertionDAO assertionDAO = new ExAssertionDAO();
//                sessionBean.setCurrentNormalAssertion(assertionDAO.getCurrentNormalAssertion(temp.getHospital(), Integer.toString(year), new BigDecimal(month)));
//                sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_HOME"));
//                sessionBean.setPageName(MessageBundleLoader.getMessage("homePage"));
//                return "exoterika/home?faces-redirect=true";
//            } 
//            
//            //CLINIC APPLICATION
//            else if (temp.getRole().getRoleid().intValue() == 1 || temp.getRole().getRoleid().intValue() == 2 || temp.getRole().getRoleid().intValue() == 3 || temp.getRole().getRoleid().intValue() == 4) {
//                
//                persistenceUtil.audit(temp, new BigDecimal(SystemParameters.getInstance().getProperty("ACT_LOGINUSER")), null, null);
//
//                PatientsDAO patientsDAO = new PatientsDAO();
//                List<Admission> admissions = patientsDAO.fetchAdmittedPatients(temp.getDepartment(), temp.getHospital(), FacesUtils.INSIDE);
//                sessionBean.setActiveAdmissions(admissions);
//                sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_CLINIC_PLAN"));
//                sessionBean.setPageName(MessageBundleLoader.getMessage("clinicPlan"));
//                calculateUnProccessedRecipes(null);
//                return "iatriko/clinicPlan?faces-redirect=true";
//            }
            
            return "loginPage";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    
    
    public String selectRole() {
        try {
           
               //UserBean userBean = (UserBean) FacesUtils.getManagedBean("userBean");
               Users temp = sessionBean.getUsers();
            
            
            // EXOTERIKA IATREIA APPLICATION
            if (temp.getRole().getRoleid().intValue() == 6 || temp.getRole().getRoleid().intValue() == 7 || temp.getRole().getRoleid().intValue() == 8) {			
                
                persistenceUtil.audit(temp, new BigDecimal(SystemParameters.getInstance().getProperty("ACT_LOGINUSER")), null, null);

                int year = Calendar.getInstance().get(Calendar.YEAR);
                int month = Calendar.getInstance().get(Calendar.MONTH) + 1;

                ExAssertionDAO assertionDAO = new ExAssertionDAO();
                sessionBean.setCurrentNormalAssertion(assertionDAO.getCurrentNormalAssertion(temp.getHospital(), Integer.toString(year), new BigDecimal(month)));
                sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_EXOTERIKA_HOME"));
                sessionBean.setPageName(MessageBundleLoader.getMessage("homePage"));
                return "exoterika/home?faces-redirect=true";
            } 
            
            //CLINIC APPLICATION
            else if (temp.getRole().getRoleid().intValue() == 1 || temp.getRole().getRoleid().intValue() == 2 || temp.getRole().getRoleid().intValue() == 3 || temp.getRole().getRoleid().intValue() == 4) {
                
                persistenceUtil.audit(temp, new BigDecimal(SystemParameters.getInstance().getProperty("ACT_LOGINUSER")), null, null);

                PatientsDAO patientsDAO = new PatientsDAO();
                List<Admission> admissions = patientsDAO.fetchAdmittedPatients(temp.getDepartment(), temp.getHospital(), FacesUtils.INSIDE);
                sessionBean.setActiveAdmissions(admissions);
                sessionBean.setPageCode(SystemParameters.getInstance().getProperty("PAGE_CLINIC_PLAN"));
                sessionBean.setPageName(MessageBundleLoader.getMessage("clinicPlan"));
                calculateUnProccessedRecipes(null);
                return "iatriko/clinicPlan?faces-redirect=true";
            }
            
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    
    
    private void calculateUnProccessedRecipes(java.util.Date date) {
        try {
            if (date == null) {
                date = new Date();
            }
            RecipeDrugsDAO rdDAO = new RecipeDrugsDAO();
            List<RecipeDrugs> rd = rdDAO.findUnOrderedRecipes(sessionBean.getUsers().getHospital(),
                    sessionBean.getUsers().getDepartment(), date);
            if (rd != null && rd.size() > 0) {
                sessionBean.setExistsNoOrderedRecipes(true);
            } else {
                sessionBean.setExistsNoOrderedRecipes(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invalidateSession() {
        FacesUtils.resetManagedBeanJSF2("sessionBean");
        FacesUtils.invalidateSession();
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

    public String logoutAction() {
        try {
            FacesUtils.resetManagedBeanJSF2("sessionBean");
            FacesUtils.invalidateSession();
            FacesUtils.redirectAJAX(FacesUtils.getContextPath() + "/loginPage.jsf?faces-redirect=true");
            return "./loginPage?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
            return "";
        }
    }

    public void closeAlertDlg() {
        sessionBean.setShowGeneralDialog(false);
        sessionBean.setShowMsgDialog(false);
    }
}
