package com.hosp.ws;

import com.hosp.entities.Hospital;

public class EDapiIntegrationProxy implements EDapiIntegration {
  private String _endpoint = null;
  private Hospital hospital;
    
  private EDapiIntegration eDapiIntegration = null;
  
  public EDapiIntegrationProxy() {
    _initEDapiIntegrationProxy();
  }
  
  public EDapiIntegrationProxy(Hospital hospital) {
      this.hospital = hospital;
      _initEDapiIntegrationProxy();
  }
  
  
  public EDapiIntegrationProxy(String endpoint) {
    _endpoint = endpoint;
    _initEDapiIntegrationProxy();
  }
  
  private void _initEDapiIntegrationProxy() {
    try {
      eDapiIntegration = (new EDapiIntegrationServiceLocator()).geteDapiIntegrationPort(hospital);
      if (eDapiIntegration != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eDapiIntegration)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eDapiIntegration)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {serviceException.printStackTrace();}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eDapiIntegration != null)
      ((javax.xml.rpc.Stub)eDapiIntegration)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public EDapiIntegration getEDapiIntegration() {
    if (eDapiIntegration == null)
      _initEDapiIntegrationProxy();
    return eDapiIntegration;
  }
  
  public GetExamPrescriptionResponse getExamPrescription(GetExamPrescriptionRequest getExamPrescriptionRequest) throws java.rmi.RemoteException{
    if (eDapiIntegration == null)
      _initEDapiIntegrationProxy();
    return eDapiIntegration.getExamPrescription(getExamPrescriptionRequest);
  }
  
  public ExecuteExamPrescriptionResponse executeExamPrescription(ExecuteExamPrescriptionRequest executeExamPrescriptionRequest) throws java.rmi.RemoteException{
    if (eDapiIntegration == null)
      _initEDapiIntegrationProxy();
    return eDapiIntegration.executeExamPrescription(executeExamPrescriptionRequest);
  }
  
  public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
  
  
}