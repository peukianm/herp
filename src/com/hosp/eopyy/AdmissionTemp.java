/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.eopyy;

import com.hosp.bean.ErrorFile;
import com.hosp.entities.Hospital;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peukianm
 */
public class AdmissionTemp implements Serializable {
    
    private String fromYear;
    private String toYear;
    private String fromMonth;
    private String toMonth;
    private String HospitalName;
    private String admissionType;
    private String submissionType;
    private Float totaldAmount = new Float(0);    
    private List<InvoiceTemp> invoices;
    private List<DischargeTemp> discharges;   
    private Hospital hospital;
    private String contractNumber;
    

        
    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }
    
        

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getFromYear() {
        return fromYear;
    }

    public void setFromYear(String fromYear) {
        this.fromYear = fromYear;
    }

    public String getToYear() {
        return toYear;
    }

    public void setToYear(String toYear) {
        this.toYear = toYear;
    }

    public String getFromMonth() {
        return fromMonth;
    }

    public void setFromMonth(String fromMonth) {
        this.fromMonth = fromMonth;
    }

    public String getToMonth() {
        return toMonth;
    }

    public void setToMonth(String toMonth) {
        this.toMonth = toMonth;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String HospitalName) {
        this.HospitalName = HospitalName;
    }

    public String getAdmissionType() {
        return admissionType;
    }

    public void setAdmissionType(String admissionType) {
        this.admissionType = admissionType;
    }

    public Float getTotaldAmount() {
        return totaldAmount;
    }

    public void setTotaldAmount(Float totaldAmount) {
        this.totaldAmount = totaldAmount;
    }

    public List<InvoiceTemp> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceTemp> invoices) {
        this.invoices = invoices;
    }

    public List<DischargeTemp> getDischarges() {
        return discharges;
    }

    public void setDischarges(List<DischargeTemp> discharges) {
        this.discharges = discharges;
    }

   
    
    
}
