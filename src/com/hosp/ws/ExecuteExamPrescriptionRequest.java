/**
 * ExecuteExamPrescriptionRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hosp.ws;

public class ExecuteExamPrescriptionRequest  implements java.io.Serializable {
    private java.lang.String barcode;

    private java.util.Calendar executionDate;

    private java.lang.String executionUserAmka;

    private java.lang.String executionUserAFM;

    private java.lang.String executionUserType;

    private Examination[] examinations;

    public ExecuteExamPrescriptionRequest() {
    }

    public ExecuteExamPrescriptionRequest(
           java.lang.String barcode,
           java.util.Calendar executionDate,
           java.lang.String executionUserAmka,
           java.lang.String executionUserAFM,
           java.lang.String executionUserType,
           Examination[] examinations) {
           this.barcode = barcode;
           this.executionDate = executionDate;
           this.executionUserAmka = executionUserAmka;
           this.executionUserAFM = executionUserAFM;
           this.executionUserType = executionUserType;
           this.examinations = examinations;
    }


    /**
     * Gets the barcode value for this ExecuteExamPrescriptionRequest.
     * 
     * @return barcode
     */
    public java.lang.String getBarcode() {
        return barcode;
    }


    /**
     * Sets the barcode value for this ExecuteExamPrescriptionRequest.
     * 
     * @param barcode
     */
    public void setBarcode(java.lang.String barcode) {
        this.barcode = barcode;
    }


    /**
     * Gets the executionDate value for this ExecuteExamPrescriptionRequest.
     * 
     * @return executionDate
     */
    public java.util.Calendar getExecutionDate() {
        return executionDate;
    }


    /**
     * Sets the executionDate value for this ExecuteExamPrescriptionRequest.
     * 
     * @param executionDate
     */
    public void setExecutionDate(java.util.Calendar executionDate) {
        this.executionDate = executionDate;
    }


    /**
     * Gets the executionUserAmka value for this ExecuteExamPrescriptionRequest.
     * 
     * @return executionUserAmka
     */
    public java.lang.String getExecutionUserAmka() {
        return executionUserAmka;
    }


    /**
     * Sets the executionUserAmka value for this ExecuteExamPrescriptionRequest.
     * 
     * @param executionUserAmka
     */
    public void setExecutionUserAmka(java.lang.String executionUserAmka) {
        this.executionUserAmka = executionUserAmka;
    }


    /**
     * Gets the executionUserAFM value for this ExecuteExamPrescriptionRequest.
     * 
     * @return executionUserAFM
     */
    public java.lang.String getExecutionUserAFM() {
        return executionUserAFM;
    }


    /**
     * Sets the executionUserAFM value for this ExecuteExamPrescriptionRequest.
     * 
     * @param executionUserAFM
     */
    public void setExecutionUserAFM(java.lang.String executionUserAFM) {
        this.executionUserAFM = executionUserAFM;
    }


    /**
     * Gets the executionUserType value for this ExecuteExamPrescriptionRequest.
     * 
     * @return executionUserType
     */
    public java.lang.String getExecutionUserType() {
        return executionUserType;
    }


    /**
     * Sets the executionUserType value for this ExecuteExamPrescriptionRequest.
     * 
     * @param executionUserType
     */
    public void setExecutionUserType(java.lang.String executionUserType) {
        this.executionUserType = executionUserType;
    }


    /**
     * Gets the examinations value for this ExecuteExamPrescriptionRequest.
     * 
     * @return examinations
     */
    public Examination[] getExaminations() {
        return examinations;
    }


    /**
     * Sets the examinations value for this ExecuteExamPrescriptionRequest.
     * 
     * @param examinations
     */
    public void setExaminations(Examination[] examinations) {
        this.examinations = examinations;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteExamPrescriptionRequest)) return false;
        ExecuteExamPrescriptionRequest other = (ExecuteExamPrescriptionRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.barcode==null && other.getBarcode()==null) || 
             (this.barcode!=null &&
              this.barcode.equals(other.getBarcode()))) &&
            ((this.executionDate==null && other.getExecutionDate()==null) || 
             (this.executionDate!=null &&
              this.executionDate.equals(other.getExecutionDate()))) &&
            ((this.executionUserAmka==null && other.getExecutionUserAmka()==null) || 
             (this.executionUserAmka!=null &&
              this.executionUserAmka.equals(other.getExecutionUserAmka()))) &&
            ((this.executionUserAFM==null && other.getExecutionUserAFM()==null) || 
             (this.executionUserAFM!=null &&
              this.executionUserAFM.equals(other.getExecutionUserAFM()))) &&
            ((this.executionUserType==null && other.getExecutionUserType()==null) || 
             (this.executionUserType!=null &&
              this.executionUserType.equals(other.getExecutionUserType()))) &&
            ((this.examinations==null && other.getExaminations()==null) || 
             (this.examinations!=null &&
              java.util.Arrays.equals(this.examinations, other.getExaminations())));
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
        if (getBarcode() != null) {
            _hashCode += getBarcode().hashCode();
        }
        if (getExecutionDate() != null) {
            _hashCode += getExecutionDate().hashCode();
        }
        if (getExecutionUserAmka() != null) {
            _hashCode += getExecutionUserAmka().hashCode();
        }
        if (getExecutionUserAFM() != null) {
            _hashCode += getExecutionUserAFM().hashCode();
        }
        if (getExecutionUserType() != null) {
            _hashCode += getExecutionUserType().hashCode();
        }
        if (getExaminations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExaminations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExaminations(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteExamPrescriptionRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.idika.gr/", "ExecuteExamPrescriptionRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("barcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "Barcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "ExecutionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executionUserAmka");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "ExecutionUserAmka"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executionUserAFM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "ExecutionUserAFM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executionUserType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "ExecutionUserType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("examinations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "Examinations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.idika.gr/", "Examination"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.idika.gr/", "Examination"));
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
