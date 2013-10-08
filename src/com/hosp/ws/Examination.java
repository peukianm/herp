/**
 * Examination.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hosp.ws;

public class Examination  implements java.io.Serializable {
    private java.lang.String eDapiCode;

    private java.lang.String seqNumber;

    private java.lang.String examinationNotes;

    public Examination() {
    }

    public Examination(
           java.lang.String eDapiCode,
           java.lang.String seqNumber,
           java.lang.String examinationNotes) {
           this.eDapiCode = eDapiCode;
           this.seqNumber = seqNumber;
           this.examinationNotes = examinationNotes;
    }


    /**
     * Gets the eDapiCode value for this Examination.
     * 
     * @return eDapiCode
     */
    public java.lang.String getEDapiCode() {
        return eDapiCode;
    }


    /**
     * Sets the eDapiCode value for this Examination.
     * 
     * @param eDapiCode
     */
    public void setEDapiCode(java.lang.String eDapiCode) {
        this.eDapiCode = eDapiCode;
    }


    /**
     * Gets the seqNumber value for this Examination.
     * 
     * @return seqNumber
     */
    public java.lang.String getSeqNumber() {
        return seqNumber;
    }


    /**
     * Sets the seqNumber value for this Examination.
     * 
     * @param seqNumber
     */
    public void setSeqNumber(java.lang.String seqNumber) {
        this.seqNumber = seqNumber;
    }


    /**
     * Gets the examinationNotes value for this Examination.
     * 
     * @return examinationNotes
     */
    public java.lang.String getExaminationNotes() {
        return examinationNotes;
    }


    /**
     * Sets the examinationNotes value for this Examination.
     * 
     * @param examinationNotes
     */
    public void setExaminationNotes(java.lang.String examinationNotes) {
        this.examinationNotes = examinationNotes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Examination)) return false;
        Examination other = (Examination) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.eDapiCode==null && other.getEDapiCode()==null) || 
             (this.eDapiCode!=null &&
              this.eDapiCode.equals(other.getEDapiCode()))) &&
            ((this.seqNumber==null && other.getSeqNumber()==null) || 
             (this.seqNumber!=null &&
              this.seqNumber.equals(other.getSeqNumber()))) &&
            ((this.examinationNotes==null && other.getExaminationNotes()==null) || 
             (this.examinationNotes!=null &&
              this.examinationNotes.equals(other.getExaminationNotes())));
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
        if (getEDapiCode() != null) {
            _hashCode += getEDapiCode().hashCode();
        }
        if (getSeqNumber() != null) {
            _hashCode += getSeqNumber().hashCode();
        }
        if (getExaminationNotes() != null) {
            _hashCode += getExaminationNotes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Examination.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.idika.gr/", "Examination"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EDapiCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "eDapiCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seqNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "SeqNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("examinationNotes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "ExaminationNotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
