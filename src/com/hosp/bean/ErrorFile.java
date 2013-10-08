/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.bean;

import com.hosp.eopyy.ChargeTemp;
import com.hosp.eopyy.DischargeTemp;

/**
 *
 * @author peukianm
 */
public class ErrorFile {
    private String admissionAM;
    private String patientAM;
    private String errorCode;
    private String errorMsg;
    private String type;
    private DischargeTemp discharge;
    private ChargeTemp chargeTemp;

    public DischargeTemp getDischarge() {
        return discharge;
    }

    public void setDischarge(DischargeTemp discharge) {
        this.discharge = discharge;
    }

    public ChargeTemp getChargeTemp() {
        return chargeTemp;
    }

    public void setChargeTemp(ChargeTemp chargeTemp) {
        this.chargeTemp = chargeTemp;
    }
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    public String getAdmissionAM() {
        return admissionAM;
    }

    public void setAdmissionAM(String admissionAM) {
        this.admissionAM = admissionAM;
    }

    public String getPatientAM() {
        return patientAM;
    }

    public void setPatientAM(String patientAM) {
        this.patientAM = patientAM;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
}
