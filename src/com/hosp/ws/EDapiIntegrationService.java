/**
 * EDapiIntegrationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hosp.ws;

import com.hosp.entities.Hospital; 

public interface EDapiIntegrationService extends javax.xml.rpc.Service {
    public java.lang.String geteDapiIntegrationPortAddress(Hospital hospital);

    //public EDapiIntegration geteDapiIntegrationPort() throws javax.xml.rpc.ServiceException;
    public EDapiIntegration geteDapiIntegrationPort(Hospital hospital) throws javax.xml.rpc.ServiceException;
    
    //public EDapiIntegration geteDapiIntegrationPort(Hospital hospital) throws javax.xml.rpc.ServiceException;

    public EDapiIntegration geteDapiIntegrationPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
