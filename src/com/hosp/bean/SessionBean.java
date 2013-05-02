/**
 *
 */
package com.hosp.bean;

import com.hosp.entities.Admission;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExTameio;
import com.hosp.entities.Users;
import com.hosp.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private java.lang.String pageName;
    private java.lang.String pageTitle;
    private java.lang.String pageCode = "LOGIN";
    private Users users;
   
    private String errorMsgKey = "errMsg_GeneralError";
    private Locale locale = null;
    private String tameioID;
    private List<ExTameio> tameia;
    private ExTameio tameio;
    List<ExTameio> tameiaList;
    private Object parameter;
    private List<Object> parameterList;
    private String alertMessage;
    private ExAssertion currentNormalAssertion;
    private Boolean showGeneralDialog = false;
    TimeZone timeZone;
    
    private Boolean showMsgDialog = false;
    private String errorMsg = "";
    
    ///MEDICAL RECORD SESSION VARIABLES
    private List<Admission> activeAdmissions;
    private Admission selectedPatientActiveAdmission;
    private List<Admission> selectedPatientInactiveAdmission;
    private Boolean existsNoOrderedRecipes = false;

    
//    public void hideMsgDialog() {
//        showMsgDialog = false;
//        errorMsg = "";
//        pageName = null;
//        pageTitle = null;
//
//    }

    public String getPageTitle() {
        if (pageTitle == null) {
            pageTitle = MessageBundleLoader.getMessage("loginPage");
        }
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

        
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    public java.lang.String getPageName() {
        return pageName;
    }

    public void setPageName(java.lang.String pageName) {
        this.pageName = pageName;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getErrorMsgKey() {
        return errorMsgKey;
    }

    public void setErrorMsgKey(String errorMsgKey) {
        this.errorMsgKey = errorMsgKey;
    }

    public TimeZone getTimeZone() {
        timeZone = java.util.TimeZone.getDefault();
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

        public List<Admission> getActiveAdmissions() {
        return activeAdmissions;
    }

    public void setActiveAdmissions(List<Admission> activeAdmissions) {
        this.activeAdmissions = activeAdmissions;
    }

    public Admission getSelectedPatientActiveAdmission() {
        return selectedPatientActiveAdmission;
    }

    public void setSelectedPatientActiveAdmission(Admission selectedPatientActiveAdmission) {
        this.selectedPatientActiveAdmission = selectedPatientActiveAdmission;
    }

    public List<Admission> getSelectedPatientInactiveAdmission() {
        return selectedPatientInactiveAdmission;
    }

    public void setSelectedPatientInactiveAdmission(List<Admission> selectedPatientInactiveAdmission) {
        this.selectedPatientInactiveAdmission = selectedPatientInactiveAdmission;
    }

    public Boolean getExistsNoOrderedRecipes() {
        return existsNoOrderedRecipes;
    }

    public void setExistsNoOrderedRecipes(Boolean existsNoOrderedRecipes) {
        this.existsNoOrderedRecipes = existsNoOrderedRecipes;
    }
    
    public Boolean getShowMsgDialog() {
        return showMsgDialog;
    }

    public void setShowMsgDialog(Boolean showMsgDialog) {
        this.showMsgDialog = showMsgDialog;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    
    public void greekLocale(ActionEvent actionEvent) {
        setLocale(new Locale("gr"));
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("gr"));
    }

    public void englishLocale(ActionEvent actionEvent) {
        setLocale(Locale.ENGLISH);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
    }

    public String getTameioID() {
        return tameioID;
    }

    public void setTameioID(String tameioID) {
        this.tameioID = tameioID;
    }

    public List<ExTameio> getTameia() {
        return tameia;
    }

    public void setTameia(List<ExTameio> tameia) {
        this.tameia = tameia;
    }

    public java.lang.String getPageCode() {
        return pageCode;
    }

    public void setPageCode(java.lang.String pageCode) {
        this.pageCode = pageCode;
    }

    public ExTameio getTameio() {
        return tameio;
    }

    public void setTameio(ExTameio tameio) {
        this.tameio = tameio;
    }

    public List<ExTameio> getTameiaList() {
        return tameiaList;
    }

    public void setTameiaList(List<ExTameio> tameiaList) {
        this.tameiaList = tameiaList;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    public List<Object> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Object> parameterList) {
        this.parameterList = parameterList;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public ExAssertion getCurrentNormalAssertion() {
        return currentNormalAssertion;
    }

    public void setCurrentNormalAssertion(ExAssertion currentNormalAssertion) {
        this.currentNormalAssertion = currentNormalAssertion;
    }

    public Boolean getShowGeneralDialog() {
        return showGeneralDialog;
    }

    public void setShowGeneralDialog(Boolean showGeneralDialog) {
        this.showGeneralDialog = showGeneralDialog;
    }
}
