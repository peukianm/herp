package com.hosp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import com.hosp.entities.Insurance;
import com.hosp.entities.Patients;
import com.hosp.model.LazyPatientDataModel;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.PreDestroy;

@ManagedBean(name = "patientBean")
@ViewScoped
public class PatientBean implements Serializable {

    private static final Logger logger = Logger.getLogger(PatientBean.class);
    private static final long serialVersionUID = 1L;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    private Patients newPatient = new Patients();
    private Patients selectedPatient;
    private Patients currentPatient;
    private List<Patients> patients;
    @ManagedProperty(value = "#{lazyPatientDataModel}")
    private LazyPatientDataModel patientModel;
    private String tempAmka;
    private String searchByName;
    private String searchBySurname;
    private String searchByAmka;
    private Insurance searchByInsurance;
    private Date searchFromBirth;
    private Date searchToBirth;

    @PostConstruct
    public void init() {
        try {           
            if (sessionBean.getParameter() != null && sessionBean.getParameter() instanceof Patients) {                
                newPatient = (Patients) sessionBean.getParameter();
                tempAmka = newPatient.getAmka();
//                sessionBean.setParameter(null);
            } else {                
                newPatient = new Patients();
                newPatient.setEnable(BigDecimal.ONE);
            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw ex;

        }
    }

    @PreDestroy
    public void reset() {
        newPatient = new Patients();
        selectedPatient = null;
        currentPatient = null;
        patients = null;
        
        tempAmka = null;
        searchByName = null;
        searchBySurname = null;
        searchByAmka = null;
        searchByInsurance = null;
        searchFromBirth = null;
        searchToBirth = null;
    }

    public String getSearchByName() {
        return searchByName;
    }

    public void setSearchByName(String searchByName) {
        this.searchByName = searchByName;
    }

    public String getSearchBySurname() {
        return searchBySurname;
    }

    public void setSearchBySurname(String searchBySurname) {
        this.searchBySurname = searchBySurname;
    }

    public String getSearchByAmka() {
        return searchByAmka;
    }

    public void setSearchByAmka(String searchByAmka) {
        this.searchByAmka = searchByAmka;
    }

    public Insurance getSearchByInsurance() {
        return searchByInsurance;
    }

    public void setSearchByInsurance(Insurance searchByInsurance) {
        this.searchByInsurance = searchByInsurance;
    }

    public Date getSearchFromBirth() {
        return searchFromBirth;
    }

    public void setSearchFromBirth(Date searchFromBirth) {
        this.searchFromBirth = searchFromBirth;
    }

    public Date getSearchToBirth() {
        return searchToBirth;
    }

    public void setSearchToBirth(Date searchToBirth) {
        this.searchToBirth = searchToBirth;
    }

    public String getTempAmka() {
        return tempAmka;
    }

    public void setTempAmka(String tempAmka) {
        this.tempAmka = tempAmka;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Patients getNewPatient() {
        return newPatient;
    }

    public void setNewPatient(Patients newPatient) {
        this.newPatient = newPatient;
    }

    public Patients getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patients selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    public Patients getCurrentPatient() {
        return currentPatient;
    }

    public void setCurrentPatient(Patients currentPatient) {
        this.currentPatient = currentPatient;
    }

    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }

    public LazyPatientDataModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(LazyPatientDataModel patientModel) {
        this.patientModel = patientModel;
    }
}
