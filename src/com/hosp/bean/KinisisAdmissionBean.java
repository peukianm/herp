/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.bean;

import com.hosp.eopyy.AdmissionTemp;
import com.hosp.eopyy.ChargeTemp;
import com.hosp.eopyy.DischargeTemp;
import com.hosp.eopyy.InvoiceTemp;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author peukianm
 */

@ManagedBean(name = "kinisisAdmissionBean")
@ViewScoped
public class KinisisAdmissionBean implements Serializable {
    
    private static final Logger logger = Logger.getLogger(KinisisAdmissionBean.class);
    
    private String admissionType;
    private String submissionType;
    private Timestamp fromDate;
    private Timestamp toDate;

    private String opsnListNumber;
    
    private String year;
    private String month;
    
    private AdmissionTemp admission;
    private List<DischargeTemp> discharges;
    private DischargeTemp selectedDischarge;
    private ChargeTemp selectedCharge;
    
    private String contractNumber;

    
    private List<InvoiceTemp> invoices;
    private InvoiceTemp selectedInvoice;
    
    private List<ErrorFile> errors = new ArrayList<ErrorFile>();

    public List<ErrorFile> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorFile> errors) {
        this.errors = errors;
    }
    
    
    @PreDestroy
    public void reset (){        
    }
    
    @PostConstruct
    public void init() {
         
    }
    
    
    public List<InvoiceTemp> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceTemp> invoices) {
        this.invoices = invoices;
    }

    public InvoiceTemp getSelectedInvoice() {
        return selectedInvoice;
    }

    public void setSelectedInvoice(InvoiceTemp selectedInvoice) {
        this.selectedInvoice = selectedInvoice;
    }
    
    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
    
    
    public String getAdmissionType() {
        return admissionType;
    }

    public void setAdmissionType(String admissionType) {
        this.admissionType = admissionType;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public String getOpsnListNumber() {
        return opsnListNumber;
    }

    public void setOpsnListNumber(String opsnListNumber) {
        this.opsnListNumber = opsnListNumber;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public AdmissionTemp getAdmission() {
        return admission;
    }

    public void setAdmission(AdmissionTemp admission) {
        this.admission = admission;
    }

    public List<DischargeTemp> getDischarges() {
        return discharges;
    }

    public void setDischarges(List<DischargeTemp> discharges) {
        this.discharges = discharges;
    }

    public DischargeTemp getSelectedDischarge() {
        return selectedDischarge;
    }

    public void setSelectedDischarge(DischargeTemp selectedDischarge) {
        this.selectedDischarge = selectedDischarge;
    }

    public ChargeTemp getSelectedCharge() {
        return selectedCharge;
    }

    public void setSelectedCharge(ChargeTemp selectedCharge) {
        this.selectedCharge = selectedCharge;
    }
    
    
    
    
    
    
}
