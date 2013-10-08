/**
 * ExamPrescription.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hosp.ws;

public class ExamPrescription  implements java.io.Serializable {
    private java.lang.String barcode;

    private java.lang.String patientSocialInsuranceId;

    private java.util.Calendar issueDate;

    private java.util.Calendar startDate;

    private java.util.Calendar expirationDate;

    private java.util.Calendar executionDate;

    private java.util.Calendar cancelDate;

    private java.lang.String status;

    private java.lang.String reason;

    private java.lang.String notes;

    private java.lang.String doctorLastName;

    private java.lang.String doctorFirstName;

    private java.lang.String doctorAMKA;

    private java.lang.String patientAMKA;

    private java.lang.String patientLastName;

    private java.lang.String patientFirstName;

    private java.util.Calendar patientBirthDate;

    private java.lang.String patientAddress;

    private java.lang.String patientPostalCode;

    private java.lang.String patientCity;

    private java.lang.String patientTelephone;

    private java.lang.String patientSocInsName;

    private java.lang.String patientSocInsShortName;

    private java.lang.String patientMemberTypeId;

    private java.lang.String patientAMA;

    private Examination[] examinations;

    public ExamPrescription() {
    }

    public ExamPrescription(
           java.lang.String barcode,
           java.lang.String patientSocialInsuranceId,
           java.util.Calendar issueDate,
           java.util.Calendar startDate,
           java.util.Calendar expirationDate,
           java.util.Calendar executionDate,
           java.util.Calendar cancelDate,
           java.lang.String status,
           java.lang.String reason,
           java.lang.String notes,
           java.lang.String doctorLastName,
           java.lang.String doctorFirstName,
           java.lang.String doctorAMKA,
           java.lang.String patientAMKA,
           java.lang.String patientLastName,
           java.lang.String patientFirstName,
           java.util.Calendar patientBirthDate,
           java.lang.String patientAddress,
           java.lang.String patientPostalCode,
           java.lang.String patientCity,
           java.lang.String patientTelephone,
           java.lang.String patientSocInsName,
           java.lang.String patientSocInsShortName,
           java.lang.String patientMemberTypeId,
           java.lang.String patientAMA,
           Examination[] examinations) {
           this.barcode = barcode;
           this.patientSocialInsuranceId = patientSocialInsuranceId;
           this.issueDate = issueDate;
           this.startDate = startDate;
           this.expirationDate = expirationDate;
           this.executionDate = executionDate;
           this.cancelDate = cancelDate;
           this.status = status;
           this.reason = reason;
           this.notes = notes;
           this.doctorLastName = doctorLastName;
           this.doctorFirstName = doctorFirstName;
           this.doctorAMKA = doctorAMKA;
           this.patientAMKA = patientAMKA;
           this.patientLastName = patientLastName;
           this.patientFirstName = patientFirstName;
           this.patientBirthDate = patientBirthDate;
           this.patientAddress = patientAddress;
           this.patientPostalCode = patientPostalCode;
           this.patientCity = patientCity;
           this.patientTelephone = patientTelephone;
           this.patientSocInsName = patientSocInsName;
           this.patientSocInsShortName = patientSocInsShortName;
           this.patientMemberTypeId = patientMemberTypeId;
           this.patientAMA = patientAMA;
           this.examinations = examinations;
    }


    /**
     * Gets the barcode value for this ExamPrescription.
     * 
     * @return barcode
     */
    public java.lang.String getBarcode() {
        return barcode;
    }


    /**
     * Sets the barcode value for this ExamPrescription.
     * 
     * @param barcode
     */
    public void setBarcode(java.lang.String barcode) {
        this.barcode = barcode;
    }


    /**
     * Gets the patientSocialInsuranceId value for this ExamPrescription.
     * 
     * @return patientSocialInsuranceId
     */
    public java.lang.String getPatientSocialInsuranceId() {
        return patientSocialInsuranceId;
    }


    /**
     * Sets the patientSocialInsuranceId value for this ExamPrescription.
     * 
     * @param patientSocialInsuranceId
     */
    public void setPatientSocialInsuranceId(java.lang.String patientSocialInsuranceId) {
        this.patientSocialInsuranceId = patientSocialInsuranceId;
    }


    /**
     * Gets the issueDate value for this ExamPrescription.
     * 
     * @return issueDate
     */
    public java.util.Calendar getIssueDate() {
        return issueDate;
    }


    /**
     * Sets the issueDate value for this ExamPrescription.
     * 
     * @param issueDate
     */
    public void setIssueDate(java.util.Calendar issueDate) {
        this.issueDate = issueDate;
    }


    /**
     * Gets the startDate value for this ExamPrescription.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this ExamPrescription.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the expirationDate value for this ExamPrescription.
     * 
     * @return expirationDate
     */
    public java.util.Calendar getExpirationDate() {
        return expirationDate;
    }


    /**
     * Sets the expirationDate value for this ExamPrescription.
     * 
     * @param expirationDate
     */
    public void setExpirationDate(java.util.Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }


    /**
     * Gets the executionDate value for this ExamPrescription.
     * 
     * @return executionDate
     */
    public java.util.Calendar getExecutionDate() {
        return executionDate;
    }


    /**
     * Sets the executionDate value for this ExamPrescription.
     * 
     * @param executionDate
     */
    public void setExecutionDate(java.util.Calendar executionDate) {
        this.executionDate = executionDate;
    }


    /**
     * Gets the cancelDate value for this ExamPrescription.
     * 
     * @return cancelDate
     */
    public java.util.Calendar getCancelDate() {
        return cancelDate;
    }


    /**
     * Sets the cancelDate value for this ExamPrescription.
     * 
     * @param cancelDate
     */
    public void setCancelDate(java.util.Calendar cancelDate) {
        this.cancelDate = cancelDate;
    }


    /**
     * Gets the status value for this ExamPrescription.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ExamPrescription.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the reason value for this ExamPrescription.
     * 
     * @return reason
     */
    public java.lang.String getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this ExamPrescription.
     * 
     * @param reason
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }


    /**
     * Gets the notes value for this ExamPrescription.
     * 
     * @return notes
     */
    public java.lang.String getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this ExamPrescription.
     * 
     * @param notes
     */
    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }


    /**
     * Gets the doctorLastName value for this ExamPrescription.
     * 
     * @return doctorLastName
     */
    public java.lang.String getDoctorLastName() {
        return doctorLastName;
    }


    /**
     * Sets the doctorLastName value for this ExamPrescription.
     * 
     * @param doctorLastName
     */
    public void setDoctorLastName(java.lang.String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }


    /**
     * Gets the doctorFirstName value for this ExamPrescription.
     * 
     * @return doctorFirstName
     */
    public java.lang.String getDoctorFirstName() {
        return doctorFirstName;
    }


    /**
     * Sets the doctorFirstName value for this ExamPrescription.
     * 
     * @param doctorFirstName
     */
    public void setDoctorFirstName(java.lang.String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }


    /**
     * Gets the doctorAMKA value for this ExamPrescription.
     * 
     * @return doctorAMKA
     */
    public java.lang.String getDoctorAMKA() {
        return doctorAMKA;
    }


    /**
     * Sets the doctorAMKA value for this ExamPrescription.
     * 
     * @param doctorAMKA
     */
    public void setDoctorAMKA(java.lang.String doctorAMKA) {
        this.doctorAMKA = doctorAMKA;
    }


    /**
     * Gets the patientAMKA value for this ExamPrescription.
     * 
     * @return patientAMKA
     */
    public java.lang.String getPatientAMKA() {
        return patientAMKA;
    }


    /**
     * Sets the patientAMKA value for this ExamPrescription.
     * 
     * @param patientAMKA
     */
    public void setPatientAMKA(java.lang.String patientAMKA) {
        this.patientAMKA = patientAMKA;
    }


    /**
     * Gets the patientLastName value for this ExamPrescription.
     * 
     * @return patientLastName
     */
    public java.lang.String getPatientLastName() {
        return patientLastName;
    }


    /**
     * Sets the patientLastName value for this ExamPrescription.
     * 
     * @param patientLastName
     */
    public void setPatientLastName(java.lang.String patientLastName) {
        this.patientLastName = patientLastName;
    }


    /**
     * Gets the patientFirstName value for this ExamPrescription.
     * 
     * @return patientFirstName
     */
    public java.lang.String getPatientFirstName() {
        return patientFirstName;
    }


    /**
     * Sets the patientFirstName value for this ExamPrescription.
     * 
     * @param patientFirstName
     */
    public void setPatientFirstName(java.lang.String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }


    /**
     * Gets the patientBirthDate value for this ExamPrescription.
     * 
     * @return patientBirthDate
     */
    public java.util.Calendar getPatientBirthDate() {
        return patientBirthDate;
    }


    /**
     * Sets the patientBirthDate value for this ExamPrescription.
     * 
     * @param patientBirthDate
     */
    public void setPatientBirthDate(java.util.Calendar patientBirthDate) {
        this.patientBirthDate = patientBirthDate;
    }


    /**
     * Gets the patientAddress value for this ExamPrescription.
     * 
     * @return patientAddress
     */
    public java.lang.String getPatientAddress() {
        return patientAddress;
    }


    /**
     * Sets the patientAddress value for this ExamPrescription.
     * 
     * @param patientAddress
     */
    public void setPatientAddress(java.lang.String patientAddress) {
        this.patientAddress = patientAddress;
    }


    /**
     * Gets the patientPostalCode value for this ExamPrescription.
     * 
     * @return patientPostalCode
     */
    public java.lang.String getPatientPostalCode() {
        return patientPostalCode;
    }


    /**
     * Sets the patientPostalCode value for this ExamPrescription.
     * 
     * @param patientPostalCode
     */
    public void setPatientPostalCode(java.lang.String patientPostalCode) {
        this.patientPostalCode = patientPostalCode;
    }


    /**
     * Gets the patientCity value for this ExamPrescription.
     * 
     * @return patientCity
     */
    public java.lang.String getPatientCity() {
        return patientCity;
    }


    /**
     * Sets the patientCity value for this ExamPrescription.
     * 
     * @param patientCity
     */
    public void setPatientCity(java.lang.String patientCity) {
        this.patientCity = patientCity;
    }


    /**
     * Gets the patientTelephone value for this ExamPrescription.
     * 
     * @return patientTelephone
     */
    public java.lang.String getPatientTelephone() {
        return patientTelephone;
    }


    /**
     * Sets the patientTelephone value for this ExamPrescription.
     * 
     * @param patientTelephone
     */
    public void setPatientTelephone(java.lang.String patientTelephone) {
        this.patientTelephone = patientTelephone;
    }


    /**
     * Gets the patientSocInsName value for this ExamPrescription.
     * 
     * @return patientSocInsName
     */
    public java.lang.String getPatientSocInsName() {
        return patientSocInsName;
    }


    /**
     * Sets the patientSocInsName value for this ExamPrescription.
     * 
     * @param patientSocInsName
     */
    public void setPatientSocInsName(java.lang.String patientSocInsName) {
        this.patientSocInsName = patientSocInsName;
    }


    /**
     * Gets the patientSocInsShortName value for this ExamPrescription.
     * 
     * @return patientSocInsShortName
     */
    public java.lang.String getPatientSocInsShortName() {
        return patientSocInsShortName;
    }


    /**
     * Sets the patientSocInsShortName value for this ExamPrescription.
     * 
     * @param patientSocInsShortName
     */
    public void setPatientSocInsShortName(java.lang.String patientSocInsShortName) {
        this.patientSocInsShortName = patientSocInsShortName;
    }


    /**
     * Gets the patientMemberTypeId value for this ExamPrescription.
     * 
     * @return patientMemberTypeId
     */
    public java.lang.String getPatientMemberTypeId() {
        return patientMemberTypeId;
    }


    /**
     * Sets the patientMemberTypeId value for this ExamPrescription.
     * 
     * @param patientMemberTypeId
     */
    public void setPatientMemberTypeId(java.lang.String patientMemberTypeId) {
        this.patientMemberTypeId = patientMemberTypeId;
    }


    /**
     * Gets the patientAMA value for this ExamPrescription.
     * 
     * @return patientAMA
     */
    public java.lang.String getPatientAMA() {
        return patientAMA;
    }


    /**
     * Sets the patientAMA value for this ExamPrescription.
     * 
     * @param patientAMA
     */
    public void setPatientAMA(java.lang.String patientAMA) {
        this.patientAMA = patientAMA;
    }


    /**
     * Gets the examinations value for this ExamPrescription.
     * 
     * @return examinations
     */
    public Examination[] getExaminations() {
        return examinations;
    }


    /**
     * Sets the examinations value for this ExamPrescription.
     * 
     * @param examinations
     */
    public void setExaminations(Examination[] examinations) {
        this.examinations = examinations;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExamPrescription)) return false;
        ExamPrescription other = (ExamPrescription) obj;
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
            ((this.patientSocialInsuranceId==null && other.getPatientSocialInsuranceId()==null) || 
             (this.patientSocialInsuranceId!=null &&
              this.patientSocialInsuranceId.equals(other.getPatientSocialInsuranceId()))) &&
            ((this.issueDate==null && other.getIssueDate()==null) || 
             (this.issueDate!=null &&
              this.issueDate.equals(other.getIssueDate()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.expirationDate==null && other.getExpirationDate()==null) || 
             (this.expirationDate!=null &&
              this.expirationDate.equals(other.getExpirationDate()))) &&
            ((this.executionDate==null && other.getExecutionDate()==null) || 
             (this.executionDate!=null &&
              this.executionDate.equals(other.getExecutionDate()))) &&
            ((this.cancelDate==null && other.getCancelDate()==null) || 
             (this.cancelDate!=null &&
              this.cancelDate.equals(other.getCancelDate()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason()))) &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              this.notes.equals(other.getNotes()))) &&
            ((this.doctorLastName==null && other.getDoctorLastName()==null) || 
             (this.doctorLastName!=null &&
              this.doctorLastName.equals(other.getDoctorLastName()))) &&
            ((this.doctorFirstName==null && other.getDoctorFirstName()==null) || 
             (this.doctorFirstName!=null &&
              this.doctorFirstName.equals(other.getDoctorFirstName()))) &&
            ((this.doctorAMKA==null && other.getDoctorAMKA()==null) || 
             (this.doctorAMKA!=null &&
              this.doctorAMKA.equals(other.getDoctorAMKA()))) &&
            ((this.patientAMKA==null && other.getPatientAMKA()==null) || 
             (this.patientAMKA!=null &&
              this.patientAMKA.equals(other.getPatientAMKA()))) &&
            ((this.patientLastName==null && other.getPatientLastName()==null) || 
             (this.patientLastName!=null &&
              this.patientLastName.equals(other.getPatientLastName()))) &&
            ((this.patientFirstName==null && other.getPatientFirstName()==null) || 
             (this.patientFirstName!=null &&
              this.patientFirstName.equals(other.getPatientFirstName()))) &&
            ((this.patientBirthDate==null && other.getPatientBirthDate()==null) || 
             (this.patientBirthDate!=null &&
              this.patientBirthDate.equals(other.getPatientBirthDate()))) &&
            ((this.patientAddress==null && other.getPatientAddress()==null) || 
             (this.patientAddress!=null &&
              this.patientAddress.equals(other.getPatientAddress()))) &&
            ((this.patientPostalCode==null && other.getPatientPostalCode()==null) || 
             (this.patientPostalCode!=null &&
              this.patientPostalCode.equals(other.getPatientPostalCode()))) &&
            ((this.patientCity==null && other.getPatientCity()==null) || 
             (this.patientCity!=null &&
              this.patientCity.equals(other.getPatientCity()))) &&
            ((this.patientTelephone==null && other.getPatientTelephone()==null) || 
             (this.patientTelephone!=null &&
              this.patientTelephone.equals(other.getPatientTelephone()))) &&
            ((this.patientSocInsName==null && other.getPatientSocInsName()==null) || 
             (this.patientSocInsName!=null &&
              this.patientSocInsName.equals(other.getPatientSocInsName()))) &&
            ((this.patientSocInsShortName==null && other.getPatientSocInsShortName()==null) || 
             (this.patientSocInsShortName!=null &&
              this.patientSocInsShortName.equals(other.getPatientSocInsShortName()))) &&
            ((this.patientMemberTypeId==null && other.getPatientMemberTypeId()==null) || 
             (this.patientMemberTypeId!=null &&
              this.patientMemberTypeId.equals(other.getPatientMemberTypeId()))) &&
            ((this.patientAMA==null && other.getPatientAMA()==null) || 
             (this.patientAMA!=null &&
              this.patientAMA.equals(other.getPatientAMA()))) &&
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
        if (getPatientSocialInsuranceId() != null) {
            _hashCode += getPatientSocialInsuranceId().hashCode();
        }
        if (getIssueDate() != null) {
            _hashCode += getIssueDate().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getExpirationDate() != null) {
            _hashCode += getExpirationDate().hashCode();
        }
        if (getExecutionDate() != null) {
            _hashCode += getExecutionDate().hashCode();
        }
        if (getCancelDate() != null) {
            _hashCode += getCancelDate().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        if (getNotes() != null) {
            _hashCode += getNotes().hashCode();
        }
        if (getDoctorLastName() != null) {
            _hashCode += getDoctorLastName().hashCode();
        }
        if (getDoctorFirstName() != null) {
            _hashCode += getDoctorFirstName().hashCode();
        }
        if (getDoctorAMKA() != null) {
            _hashCode += getDoctorAMKA().hashCode();
        }
        if (getPatientAMKA() != null) {
            _hashCode += getPatientAMKA().hashCode();
        }
        if (getPatientLastName() != null) {
            _hashCode += getPatientLastName().hashCode();
        }
        if (getPatientFirstName() != null) {
            _hashCode += getPatientFirstName().hashCode();
        }
        if (getPatientBirthDate() != null) {
            _hashCode += getPatientBirthDate().hashCode();
        }
        if (getPatientAddress() != null) {
            _hashCode += getPatientAddress().hashCode();
        }
        if (getPatientPostalCode() != null) {
            _hashCode += getPatientPostalCode().hashCode();
        }
        if (getPatientCity() != null) {
            _hashCode += getPatientCity().hashCode();
        }
        if (getPatientTelephone() != null) {
            _hashCode += getPatientTelephone().hashCode();
        }
        if (getPatientSocInsName() != null) {
            _hashCode += getPatientSocInsName().hashCode();
        }
        if (getPatientSocInsShortName() != null) {
            _hashCode += getPatientSocInsShortName().hashCode();
        }
        if (getPatientMemberTypeId() != null) {
            _hashCode += getPatientMemberTypeId().hashCode();
        }
        if (getPatientAMA() != null) {
            _hashCode += getPatientAMA().hashCode();
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
        new org.apache.axis.description.TypeDesc(ExamPrescription.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.idika.gr/", "ExamPrescription"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("barcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "Barcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientSocialInsuranceId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientSocialInsuranceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "IssueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "StartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expirationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "ExpirationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "ExecutionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "CancelDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "Reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "Notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doctorLastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "DoctorLastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doctorFirstName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "DoctorFirstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doctorAMKA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "DoctorAMKA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientAMKA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientAMKA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientLastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientLastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientFirstName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientFirstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientBirthDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientBirthDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientPostalCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientPostalCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientCity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientTelephone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientTelephone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientSocInsName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientSocInsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientSocInsShortName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientSocInsShortName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientMemberTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientMemberTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientAMA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.idika.gr/", "PatientAMA"));
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
