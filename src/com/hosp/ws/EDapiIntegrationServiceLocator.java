/**
 * EDapiIntegrationServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hosp.ws;

import com.hosp.entities.Hospital;
import com.hosp.util.SystemParameters;

public class EDapiIntegrationServiceLocator extends org.apache.axis.client.Service implements EDapiIntegrationService {

    public EDapiIntegrationServiceLocator() {
    }


    public EDapiIntegrationServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EDapiIntegrationServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for eDapiIntegrationPort
    //private java.lang.String eDapiIntegrationPort_address = "https://tstosb1.idika.gr:9011/servicebus_test/services/eDapi/secure/eDapiIntegration";
   // private java.lang.String eDapiIntegrationPort_address = "https://84.205.251.62:9011/servicebus_test/services/eDapi/secure/eDapiIntegration";
    //private java.lang.String eDapiIntegrationPort_address = "https://84.205.246.238:9011/servicebus_test/services/eDapi/secure/eDapiIntegration";
    //private java.lang.String eDapiIntegrationPort_address = "https://www.e-prescription.gr/servicebus_test/services/eDapi/secure/eDapiIntegration?WSDL";
    
    private java.lang.String eDapiIntegrationPort_address = "https://www.e-prescription.gr/servicebus_test/services/eDapi/secure/eDapiIntegration?WSDL";
    private Hospital hospital;
    
//    public java.lang.String geteDapiIntegrationPortAddress() {
//        //eDapiIntegrationPort_address = SystemParameters.getInstance().getProperty(hospital.getHospitalid().toString()+"_WSPARAADDRESS");
//        return eDapiIntegrationPort_address;
//    }

    public java.lang.String geteDapiIntegrationPortAddress(Hospital hospital) {
        String property = hospital.getHospitalid().intValue()+"_WSPARAADDRESS";
        System.out.println("property="+property);
        System.out.println("VALUE="+SystemParameters.getInstance().getProperty(property));
        eDapiIntegrationPort_address = SystemParameters.getInstance().getProperty(hospital.getHospitalid().intValue()+"_WSPARAADDRESS");
        return eDapiIntegrationPort_address;
    }
    
    // The WSDD service name defaults to the port name.
    private java.lang.String eDapiIntegrationPortWSDDServiceName = "eDapiIntegrationPort";

    public java.lang.String geteDapiIntegrationPortWSDDServiceName() {
        return eDapiIntegrationPortWSDDServiceName;
    }

    public void seteDapiIntegrationPortWSDDServiceName(java.lang.String name) {
        eDapiIntegrationPortWSDDServiceName = name;
    }

        
    public EDapiIntegration geteDapiIntegrationPort(Hospital hospital) throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
       this.hospital = hospital;
        try {
            if (hospital != null) {
                System.out.println("geteDapiIntegrationPortAddress(hospital)="+geteDapiIntegrationPortAddress(hospital));
                endpoint = new java.net.URL(geteDapiIntegrationPortAddress(hospital));
            
            } else
                endpoint = new java.net.URL(eDapiIntegrationPort_address);
        }
        catch (java.net.MalformedURLException e) {
            e.printStackTrace();
            throw new javax.xml.rpc.ServiceException(e);
        }
        return geteDapiIntegrationPort(endpoint);
    }

    public EDapiIntegration geteDapiIntegrationPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            EDapiIntegrationSOAP11BindingStub _stub = new EDapiIntegrationSOAP11BindingStub(portAddress, this);
            _stub.setPortName(geteDapiIntegrationPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void seteDapiIntegrationPortEndpointAddress(java.lang.String address) {
        eDapiIntegrationPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (EDapiIntegration.class.isAssignableFrom(serviceEndpointInterface)) {
                EDapiIntegrationSOAP11BindingStub _stub = new EDapiIntegrationSOAP11BindingStub(new java.net.URL(eDapiIntegrationPort_address), this);
                _stub.setPortName(geteDapiIntegrationPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("eDapiIntegrationPort".equals(inputPortName)) {
            //return geteDapiIntegrationPort();
            return geteDapiIntegrationPort(hospital);
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.idika.gr/", "eDapiIntegrationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.idika.gr/", "eDapiIntegrationPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("eDapiIntegrationPort".equals(portName)) {
            seteDapiIntegrationPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
