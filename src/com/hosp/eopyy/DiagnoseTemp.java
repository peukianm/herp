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
public class DiagnoseTemp {
    
    private String code;
    private String codeOPSN;
    private String descrption;
    
    /**
     * YPOXREWTIKO - PINAKAS 0002
     * 
     * A - Admitting (ΕΙΣΟΔΟΣ)
     * D - DIscharge (ΕΞΟΔΟΣ)
     * W - Working
     * F - Final
     */
    private String diagnoseType;
    
    private List<String> errorCode  = new ArrayList<String>(0);;

    public List<String> getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(List<String> errorCode) {
        this.errorCode = errorCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeOPSN() {
        return codeOPSN;
    }

    public void setCodeOPSN(String codeOPSN) {
        this.codeOPSN = codeOPSN;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getDiagnoseType() {
        return diagnoseType;
    }

    public void setDiagnoseType(String diagnoseType) {
        this.diagnoseType = diagnoseType;
    }
    
        
}
