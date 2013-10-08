/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.eopyy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author peukianm
 */
public class DischargeTemp {
    private List<ChargeTemp> charges = new ArrayList<ChargeTemp>();
    private Date admissionDate;
    private String admissionTime = "1200";
    private Date dischargeDate;
    private String dischargeTime = "1200";
    private String admissionNumber;
    
    /**
     * electronic admission number
     */
    private String eadmissionNumber;         
    
    private String dischargeNumber;
    
    /**
     * electronic discharge number
     */
    private String edischargeNumber;
    
    /** 
     * 1 for e-anaggelia
     * 0 for manual anaggelia
     * */
    private String dischargeType = "1";

    private String aprovalDate = "";
    private String countryCode = "GR";
    private String exceptionInPartcipation = "0";
    private String chronicalDiseaseCode = "";
    private String doctorAFM = "0";
    
    /** 
     * surname^name      
     */
    private String patientName;
    
    /**
     * 1 - European Insurance
     * 0 - Greek Insurance
     */
    private String patientInsuranceOrigin = "0";
    
    /**          
     *                          ΠΙΝΑΚΑΣ 16
     * 1111111^^^^AMA~<foreasid>^^^^ΦΟΡΕΑΣ
     */
    private String patientIDGreek;    
    private String patientIDForeign;    
    private String patientID;
     
    private String patientAMKA;        
    private String patientOPSNID;
    private String patientDateOfBirth;
    private String patientAMA;
    private String patientInsurance;
    private String patientFirstName;
    private String patientSurname;
    
    /**
     * ^<ΟΔΟΣ>^<ΑΡΙΘΜΟΣ>^<ΠΟΛΗ>^<ΝΟΜΟΣ>^<ΤΚ>
     */    
    private String patientAddress;
    private String patientPhone = "0";        
        
    
    /**   PINAKAS 0013
     * 0 - No Death
     * 1 - Death before surgery
     * 2 - Death during surgery
     * 3 - Death after surgery
     */
    private String patientTypeOfDeath = "0";
    private String patientDateOfDeath = "";
    
    /**
     * 1 - DIRECT
     * 2 - INDIRECT
     */
    private String patientDirectInsurance = "1"; 

   
    
    /**
     * <AMKA>^<SURNAME^<NAME>
     * <AMKA>^ ^ 
     */
    private String treamentDoctor;
    
    /** PINAKAS 0004
     * E - Emergency
     * I - Inpatient
     * O - Outpatient
     * R - Recuring Patient
     */
    private String treatmentType = "I";
    
    /**
     * PINAKAS  0001
     * OPTIONAL
     */
    private String admissionCause = "";
    
    /**
     * PINAKAS 14
     * MANADATORY
     */
    private String admissionPossition;

    
    /**  
     * REQUIRED - PINAKAS 0003
     * 
     * A - ΙΑΣΗΣ
     * C - ΕΠΙΔΕΙΝΩΣΗ
     * P - ΒΕΛΤΙΩΣΗ
     * S - ΣΤΑΣΙΜΗ
     * Ο - ΑΛΛΗ
     * U - ΑΓΝΩΣΤΗ
     * D - ΘΑΝΑΤΟΣ
     */   
    private String admissionOutcome;

    
    private List<String> errorCode  = new ArrayList<String>(0);;
    
    private List<DiagnoseTemp> admitDiagnoses;
    private List<DiagnoseTemp> dischargeDiagnoses;
    
    private Float dischargeAmount = new Float(0);

    public Float getDischargeAmount() {
        return dischargeAmount;
    }

    public void setDischargeAmount(Float dischargeAmount) {
        this.dischargeAmount = dischargeAmount;
    }

        
    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

        
    public List<String> getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(List<String> errorCode) {
        this.errorCode = errorCode;
    }

    public String getPatientAMA() {
        return patientAMA;
    }

    public void setPatientAMA(String patientAMA) {
        this.patientAMA = patientAMA;
    }

    public String getPatientInsurance() {
        return patientInsurance;
    }

    public void setPatientInsurance(String patientInsurance) {
        this.patientInsurance = patientInsurance;
    }

       
    
    public List<DiagnoseTemp> getAdmitDiagnoses() {
        return admitDiagnoses;
    }

    public void setAdmitDiagnoses(List<DiagnoseTemp> admitDiagnoses) {
        this.admitDiagnoses = admitDiagnoses;
    }

    public List<DiagnoseTemp> getDischargeDiagnoses() {
        return dischargeDiagnoses;
    }

    public void setDischargeDiagnoses(List<DiagnoseTemp> dischargeDiagnoses) {
        this.dischargeDiagnoses = dischargeDiagnoses;
    }
       
        
    public String getAdmissionOutcome() {
        return admissionOutcome;
    }

    public void setAdmissionOutcome(String admissionOutcome) {
        this.admissionOutcome = admissionOutcome;
    }
    
        
    public String getPatientDirectInsurance() {
        return patientDirectInsurance;
    }

    public void setPatientDirectInsurance(String patientDirectInsurance) {
        this.patientDirectInsurance = patientDirectInsurance;
    }
    
    public String getAdmissionCause() {
        return admissionCause;
    }

    public void setAdmissionCause(String admissionCause) {
        this.admissionCause = admissionCause;
    }

    public String getAdmissionPossition() {
        return admissionPossition;
    }

    public void setAdmissionPossition(String admissionPossition) {
        this.admissionPossition = admissionPossition;
    }
    
    
   
    public String getTreamentDoctor() {
        return treamentDoctor;
    }

    public void setTreamentDoctor(String treamentDoctor) {
        this.treamentDoctor = treamentDoctor;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }
    
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    
    
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientInsuranceOrigin() {
        return patientInsuranceOrigin;
    }

    public void setPatientInsuranceOrigin(String patientInsuranceOrigin) {
        this.patientInsuranceOrigin = patientInsuranceOrigin;
    }

    public String getPatientIDGreek() {
        return patientIDGreek;
    }

    public void setPatientIDGreek(String patientIDGreek) {
        this.patientIDGreek = patientIDGreek;
    }

    public String getPatientIDForeign() {
        return patientIDForeign;
    }

    public void setPatientIDForeign(String patientIDForeign) {
        this.patientIDForeign = patientIDForeign;
    }

    public String getPatientAMKA() {
        return patientAMKA;
    }

    public void setPatientAMKA(String patientAMKA) {
        this.patientAMKA = patientAMKA;
    }

    public String getPatientOPSNID() {
        return patientOPSNID;
    }

    public void setPatientOPSNID(String patientOPSNID) {
        this.patientOPSNID = patientOPSNID;
    }

    public String getPatientDateOfBirth() {
        return patientDateOfBirth;
    }

    public void setPatientDateOfBirth(String patientDateOfBirth) {
        this.patientDateOfBirth = patientDateOfBirth;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientTypeOfDeath() {
        return patientTypeOfDeath;
    }

    public void setPatientTypeOfDeath(String patientTypeOfDeath) {
        this.patientTypeOfDeath = patientTypeOfDeath;
    }

    public String getPatientDateOfDeath() {
        return patientDateOfDeath;
    }

    public void setPatientDateOfDeath(String patientDateOfDeath) {
        this.patientDateOfDeath = patientDateOfDeath;
    }
    
    
    
    
    

    public String getAprovalDate() {
        return aprovalDate;
    }

    public void setAprovalDate(String aprovalDate) {
        this.aprovalDate = aprovalDate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getExceptionInPartcipation() {
        return exceptionInPartcipation;
    }

    public void setExceptionInPartcipation(String exceptionInPartcipation) {
        this.exceptionInPartcipation = exceptionInPartcipation;
    }

    public String getChronicalDiseaseCode() {
        return chronicalDiseaseCode;
    }

    public void setChronicalDiseaseCode(String chronicalDiseaseCode) {
        this.chronicalDiseaseCode = chronicalDiseaseCode;
    }

    public String getDoctorAFM() {
        return doctorAFM;
    }

    public void setDoctorAFM(String doctorAFM) {
        this.doctorAFM = doctorAFM;
    }
    
    
    
    
    
    
    
    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getEadmissionNumber() {
        return eadmissionNumber;
    }

    public void setEadmissionNumber(String eadmissionNumber) {
        this.eadmissionNumber = eadmissionNumber;
    }

    public String getDischargeNumber() {
        return dischargeNumber;
    }

    public void setDischargeNumber(String dischargeNumber) {
        this.dischargeNumber = dischargeNumber;
    }

    public String getEdischargeNumber() {
        return edischargeNumber;
    }

    public void setEdischargeNumber(String edischargeNumber) {
        this.edischargeNumber = edischargeNumber;
    }

    public String getDischargeType() {
        return dischargeType;
    }

    public void setDischargeType(String dischargeType) {
        this.dischargeType = dischargeType;
    }

       
    public List<ChargeTemp> getCharges() {
        return charges;
    }

    public void setCharges(List<ChargeTemp> charges) {
        this.charges = charges;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(String admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(String dischargeTime) {
        this.dischargeTime = dischargeTime;
    }
    
    
}
