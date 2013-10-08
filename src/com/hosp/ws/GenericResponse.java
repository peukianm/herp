/**
 * GenericResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hosp.ws;

public class GenericResponse  implements java.io.Serializable {
    private int outcomeCode;

    private java.lang.String outcomeMessage;

    public GenericResponse() {
    }

    public GenericResponse(
           int outcomeCode,
           java.lang.String outcomeMessage) {
           this.outcomeCode = outcomeCode;
           this.outcomeMessage = outcomeMessage;
    }


    /**
     * Gets the outcomeCode value for this GenericResponse.
     * 
     * @return outcomeCode
     */
    public int getOutcomeCode() {
        return outcomeCode;
    }


    /**
     * Sets the outcomeCode value for this GenericResponse.
     * 
     * @param outcomeCode
     */
    public void setOutcomeCode(int outcomeCode) {
        this.outcomeCode = outcomeCode;
    }


    /**
     * Gets the outcomeMessage value for this GenericResponse.
     * 
     * @return outcomeMessage
     */
    public java.lang.String getOutcomeMessage() {
        return outcomeMessage;
    }


    /**
     * Sets the outcomeMessage value for this GenericResponse.
     * 
     * @param outcomeMessage
     */
    public void setOutcomeMessage(java.lang.String outcomeMessage) {
        this.outcomeMessage = outcomeMessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GenericResponse)) return false;
        GenericResponse other = (GenericResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.outcomeCode == other.getOutcomeCode() &&
            ((this.outcomeMessage==null && other.getOutcomeMessage()==null) || 
             (this.outcomeMessage!=null &&
              this.outcomeMessage.equals(other.getOutcomeMessage())));
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
        _hashCode += getOutcomeCode();
        if (getOutcomeMessage() != null) {
            _hashCode += getOutcomeMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GenericResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.idika.gr/", "GenericResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outcomeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "OutcomeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outcomeMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "OutcomeMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
