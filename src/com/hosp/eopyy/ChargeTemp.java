/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.eopyy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peukianm
 */
public class ChargeTemp {
    
    
    /**
     * PINAKAS 0007 (- PEDIO 8)
     * 
     * 2 - ΦΑΡΜΑΚΑ
     * 3 - ΙΑΤΡΙΚΕΣ ΠΡΑΞΕΙΣ
     * 9 - ΥΛΙΚΑ
     * 
     * 1 - ΗΜΕΡΗΣΙΟ ΝΟΣΗΛΕΙΟ 
     * 6 - ΚΕΝ
     * 
     */
    private String chargeType;
    
    /**
     * PINAKOS 0008 (PEDIO 7)
     * 
     *  (chargeType=2)  drugs  -  2^<EOF CODE> OR 12^<EOPYY CODE> OR 14^<EOPYY CODE FOR SPECIAL DRUGS>
     *  (chargeType=3)  med Acts   -   10^<EOPYY MED ACTS CODE> 
     *  (chargeType=9)  YLIKA - 4^<EKAPTY CODE>
     *  (chargeType=6)  KEN - 6^<KEN CODE>
     *  (chatgeType=1)  NOSHLEIO - 1^<COEDE NOSILIOY APO PINAKA EOPYY>
     */
    private String chargeCode;
    
    /**
     * field10
     */
    private String admissionDate;
    
    /**
     * field11
     */
    private String dischargeDate;
    
    
    /**
     * field12
     */
    private String percentageConsumption = "0.0";
    
    /**
     *  field 14
     *  drug - 1
     */
    private String dailyDosage = "";
    
    private String netChargeAmount;
    
    private String chargeAmount;
    
    /**
     *  for charge type 2,3,5 - 1 gia hlektroniko parapemptik;o kai 2 gia xeirografo parapemptiko
     *  for charge type 1,3 - KENO
     * 
     */
    private String field18 ="";
    
    /**
     * for charge type 2 - TIMH KEN h TIMH KVDIKOY KLEISTOY NOSHLEIOY
     * for charge Type 9 - ΚΩΔΙΚΟΣ ΙΑΤΡΙΚΗΣ ΠΡΑΞΗΣ 
     * 
     */
    private String field22 = "";
    
    /**
     * chargeTYpe =2,3,9
     * AMKA^SURNAMA^NAME
     */
    private String prescriptionDoctor = ";";
    
    /**
     * chargeType 2,3,9 - ΕΝΑΡΞΗ ΧΟΡΗΓΗΣΗΣ/ΓΝΩΜΑΤΕΥΣΗ ΦΑΡΜΑΚΟΥ,ΥΛΙΚΟΥ,ΙΑΤΡΙΚΗΣ ΠΡΑΞΗΣ
     * chargeType 1,6 - KENO
     */
    private String startPrescriptionDate = "";
    
    
    
    /**
     * chargeType 2,3,9 - ΛΗΞΗ ΧΟΡΗΓΗΣΗΣ/ΓΝΩΜΑΤΕΥΣΗ ΦΑΡΜΑΚΟΥ,ΥΛΙΚΟΥ,ΙΑΤΡΙΚΗΣ ΠΡΑΞΗΣ
     * chargeType 1,6 - KENO
     */
    private String endPrescriptionDate = "";
    
    
    /**
     * PINAKAS 0017
     * 
     * chargeType = 1, 6
     * 1 -ΠΑΘΟΛΟΓΙΚΟΣ
     * 2 - ΧΕΙΡΟΥΡΓΙΚΟΣ
     * 3 - ΨΥΧΙΑΤΡΙΚΟΣ
     * 
     * chargeType2,3,9 - KENO
     * 
     */
    private String treatmentSector = "";
    
    
    /**
     * PIANAKS 0014
     * 
     * chargeType = 1,6
     * 1-Γ, 2-Ββ , 3-ΒΒ , 4-Α , 5-LUX 
     * 
     * chargeType 2,3,9 - KENO
     * 
     */
    private String treatmentPosition ="";
    
    private String supplierPercentage = "0";
    
    private String supplierAmount = "0";
    
    private String patientPercentage = "0";
      
    private String patientAmount = "0";
    
    private String VAT = "0";
    
    private String controlerDoctorAFM = "0";
    
    private String receiptDostorAFM = "0";
    
    private String supplierDiscountPercentage = "0";
    
    private String supplierDiscountAmount = "0";
    
    
    /**
     *  0 - Not use laparaskopisi
     *  1 = Use laparaskopisi
     * 
     */
    private String laparaskopiki= "";
    
    private String supplierAFM = "";

    private List<String> errorCode = new ArrayList<String>(0);

    public List<String> getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(List<String> errorCode) {
        this.errorCode = errorCode;
    }
    
  
    
    public String getPatientPercentage() {
        return patientPercentage;
    }

    public void setPatientPercentage(String patientPercentage) {
        this.patientPercentage = patientPercentage;
    }
    
    
    public String getStartPrescriptionDate() {
        return startPrescriptionDate;
    }

    public void setStartPrescriptionDate(String startPrescriptionDate) {
        this.startPrescriptionDate = startPrescriptionDate;
    }

    public String getEndPrescriptionDate() {
        return endPrescriptionDate;
    }

    public void setEndPrescriptionDate(String endPrescriptionDate) {
        this.endPrescriptionDate = endPrescriptionDate;
    }

    public String getTreatmentSector() {
        return treatmentSector;
    }

    public void setTreatmentSector(String treatmentSector) {
        this.treatmentSector = treatmentSector;
    }

    public String getTreatmentPosition() {
        return treatmentPosition;
    }

    public void setTreatmentPosition(String treatmentPosition) {
        this.treatmentPosition = treatmentPosition;
    }

    public String getSupplierPercentage() {
        return supplierPercentage;
    }

    public void setSupplierPercentage(String supplierPercentage) {
        this.supplierPercentage = supplierPercentage;
    }

    public String getSupplierAmount() {
        return supplierAmount;
    }

    public void setSupplierAmount(String supplierAmount) {
        this.supplierAmount = supplierAmount;
    }

    public String getPatientAmount() {
        return patientAmount;
    }

    public void setPatientAmount(String patientAmount) {
        this.patientAmount = patientAmount;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getControlerDoctorAFM() {
        return controlerDoctorAFM;
    }

    public void setControlerDoctorAFM(String controlerDoctorAFM) {
        this.controlerDoctorAFM = controlerDoctorAFM;
    }

    public String getReceiptDostorAFM() {
        return receiptDostorAFM;
    }

    public void setReceiptDostorAFM(String receiptDostorAFM) {
        this.receiptDostorAFM = receiptDostorAFM;
    }

    public String getSupplierDiscountPercentage() {
        return supplierDiscountPercentage;
    }

    public void setSupplierDiscountPercentage(String supplierDiscountPercentage) {
        this.supplierDiscountPercentage = supplierDiscountPercentage;
    }

    public String getSupplierDiscountAmount() {
        return supplierDiscountAmount;
    }

    public void setSupplierDiscountAmount(String supplierDiscountAmount) {
        this.supplierDiscountAmount = supplierDiscountAmount;
    }

    public String getLaparaskopiki() {
        return laparaskopiki;
    }

    public void setLaparaskopiki(String laparaskopiki) {
        this.laparaskopiki = laparaskopiki;
    }

    public String getSupplierAFM() {
        return supplierAFM;
    }

    public void setSupplierAFM(String supplierAFM) {
        this.supplierAFM = supplierAFM;
    }
    
       
    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getPercentageConsumption() {
        return percentageConsumption;
    }

    public void setPercentageConsumption(String percentageConsumption) {
        this.percentageConsumption = percentageConsumption;
    }

    public String getDailyDosage() {
        return dailyDosage;
    }

    public void setDailyDosage(String dailyDosage) {
        this.dailyDosage = dailyDosage;
    }

    public String getNetChargeAmount() {
        return netChargeAmount;
    }

    public void setNetChargeAmount(String netChargeAmount) {
        this.netChargeAmount = netChargeAmount;
    }

    public String getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getField18() {
        return field18;
    }

    public void setField18(String field18) {
        this.field18 = field18;
    }

    public String getField22() {
        return field22;
    }

    public void setField22(String field22) {
        this.field22 = field22;
    }

    public String getPrescriptionDoctor() {
        return prescriptionDoctor;
    }

    public void setPrescriptionDoctor(String prescriptionDoctor) {
        this.prescriptionDoctor = prescriptionDoctor;
    }
    
    
    
    
    
    
}
