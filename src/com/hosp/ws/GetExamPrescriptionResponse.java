/**
 * GetExamPrescriptionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hosp.ws;

public class GetExamPrescriptionResponse  implements java.io.Serializable {
    private ExamPrescription examPrescription;

    private GenericResponse response;

    public GetExamPrescriptionResponse() {
    }

    public GetExamPrescriptionResponse(
           ExamPrescription examPrescription,
           GenericResponse response) {
           this.examPrescription = examPrescription;
           this.response = response;
    }


    /**
     * Gets the examPrescription value for this GetExamPrescriptionResponse.
     * 
     * @return examPrescription
     */
    public ExamPrescription getExamPrescription() {
        return examPrescription;
    }


    /**
     * Sets the examPrescription value for this GetExamPrescriptionResponse.
     * 
     * @param examPrescription
     */
    public void setExamPrescription(ExamPrescription examPrescription) {
        this.examPrescription = examPrescription;
    }


    /**
     * Gets the response value for this GetExamPrescriptionResponse.
     * 
     * @return response
     */
    public GenericResponse getResponse() {
        return response;
    }


    /**
     * Sets the response value for this GetExamPrescriptionResponse.
     * 
     * @param response
     */
    public void setResponse(GenericResponse response) {
        this.response = response;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetExamPrescriptionResponse)) return false;
        GetExamPrescriptionResponse other = (GetExamPrescriptionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.examPrescription==null && other.getExamPrescription()==null) || 
             (this.examPrescription!=null &&
              this.examPrescription.equals(other.getExamPrescription()))) &&
            ((this.response==null && other.getResponse()==null) || 
             (this.response!=null &&
              this.response.equals(other.getResponse())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getExamPrescription() != null) {
            _hashCode += getExamPrescription().hashCode();
        }
        if (getResponse() != null) {
            _hashCode += getResponse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetExamPrescriptionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.idika.gr/", "GetExamPrescriptionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("examPrescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "ExamPrescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.idika.gr/", "ExamPrescription"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "Response"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.idika.gr/", "GenericResponse"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
