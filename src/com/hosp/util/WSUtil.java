/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.util;

import com.hosp.entities.ExPara;
import com.hosp.entities.Hospital;
import com.hosp.ws.*;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peukianm
 */
public class WSUtil {

    public static GetExamPrescriptionResponse getParaFromEOPYY(String barcode, Hospital hospital) {        
        try {
            EDapiIntegrationProxy eDapiIntegrationProxy = new EDapiIntegrationProxy(hospital);
            GetExamPrescriptionRequest getExamPrescriptionRequest = new GetExamPrescriptionRequest();
            getExamPrescriptionRequest.setBarcode(barcode);        
            GetExamPrescriptionResponse getExamPrescriptionResponse = eDapiIntegrationProxy.getExamPrescription(getExamPrescriptionRequest);
            return getExamPrescriptionResponse;
        } catch (RemoteException ex) {
            return null;
        }
        
    }
}
