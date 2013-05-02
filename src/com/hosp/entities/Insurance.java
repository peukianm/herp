package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Insurance entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "INSURANCE", schema = "HOSPITAL")
public class Insurance implements java.io.Serializable {

    // Fields
    private BigDecimal insuranceid;
    private String name;
    private String description;
    private BigDecimal insuranceTypeId;
    private BigDecimal insuredStatus;
    private BigDecimal insuranceGroupId;
    private String insuranceName;
    private BigDecimal inUse;
    private BigDecimal ordered;
    private Set<Patients> patientses = new HashSet<Patients>(0);
    private Set<ExPara> exParas = new HashSet<ExPara>(0);

    // Constructors
    /**
     * default constructor
     */
    public Insurance() {
    }

    /**
     * minimal constructor
     */
    public Insurance(BigDecimal insuranceid, String name) {
        this.insuranceid = insuranceid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Insurance(BigDecimal insuranceid, String name, String description, BigDecimal insuranceTypeId, BigDecimal insuredStatus,
            BigDecimal insuranceGroupId, String insuranceName, BigDecimal inUse, Set<Patients> patientses, Set<ExPara> exParas) {
        this.insuranceid = insuranceid;
        this.name = name;
        this.description = description;
        this.insuranceTypeId = insuranceTypeId;
        this.insuredStatus = insuredStatus;
        this.insuranceGroupId = insuranceGroupId;
        this.insuranceName = insuranceName;
        this.inUse = inUse;
        this.patientses = patientses;
        this.exParas = exParas;
    }

    // Property accessors
    @Id
    @Column(name = "INSURANCEID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getInsuranceid() {
        return this.insuranceid;
    }

    public void setInsuranceid(BigDecimal insuranceid) {
        this.insuranceid = insuranceid;
    }

    @Column(name = "NAME", nullable = false, length = 4000)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION", length = 200)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "INSURANCE_TYPE_ID", precision = 22, scale = 0)
    public BigDecimal getInsuranceTypeId() {
        return this.insuranceTypeId;
    }

    public void setInsuranceTypeId(BigDecimal insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }

    @Column(name = "INSURED_STATUS", precision = 22, scale = 0)
    public BigDecimal getInsuredStatus() {
        return this.insuredStatus;
    }

    public void setInsuredStatus(BigDecimal insuredStatus) {
        this.insuredStatus = insuredStatus;
    }

    @Column(name = "INSURANCE_GROUP_ID", precision = 22, scale = 0)
    public BigDecimal getInsuranceGroupId() {
        return this.insuranceGroupId;
    }

    public void setInsuranceGroupId(BigDecimal insuranceGroupId) {
        this.insuranceGroupId = insuranceGroupId;
    }

    @Column(name = "INSURANCE_NAME", length = 100)
    public String getInsuranceName() {
        return this.insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    @Column(name = "IN_USE", precision = 22, scale = 0)
    public BigDecimal getInUse() {
        return this.inUse;
    }

    public void setInUse(BigDecimal inUse) {
        this.inUse = inUse;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "insurance")
    public Set<Patients> getPatientses() {
        return this.patientses;
    }

    public void setPatientses(Set<Patients> patientses) {
        this.patientses = patientses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "insurance")
    public Set<ExPara> getExParas() {
        return this.exParas;
    }

    public void setExParas(Set<ExPara> exParas) {
        this.exParas = exParas;
    }

    @Column(name = "ORDERED", precision = 22, scale = 0)
    public BigDecimal getOrdered() {
        return this.ordered;
    }

    public void setOrdered(BigDecimal ordered) {
        this.ordered = ordered;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Insurance)) {
            return false;
        }

        Insurance compare = (Insurance) obj;

        return compare.insuranceid.equals(this.insuranceid);
    }

    @Override
    public int hashCode() {
        return insuranceid != null ? this.getClass().hashCode() + insuranceid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Insuance{" + "id=" + insuranceid + ", name=" + getName() + '}';
    }
}