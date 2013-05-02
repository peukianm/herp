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
 * Bloodtype entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BLOODTYPE", schema = "HOSPITAL")
public class Bloodtype implements java.io.Serializable {

    // Fields
    private BigDecimal bloodtypeid;
    private String name;
    private Set<Patients> patientses = new HashSet<Patients>(0);

    // Constructors
    /**
     * default constructor
     */
    public Bloodtype() {
    }

    /**
     * minimal constructor
     */
    public Bloodtype(BigDecimal bloodtypeid, String name) {
        this.bloodtypeid = bloodtypeid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Bloodtype(BigDecimal bloodtypeid, String name, Set<Patients> patientses) {
        this.bloodtypeid = bloodtypeid;
        this.name = name;
        this.patientses = patientses;
    }

    // Property accessors
    @Id
    @Column(name = "BLOODTYPEID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getBloodtypeid() {
        return this.bloodtypeid;
    }

    public void setBloodtypeid(BigDecimal bloodtypeid) {
        this.bloodtypeid = bloodtypeid;
    }

    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bloodtype")
    public Set<Patients> getPatientses() {
        return this.patientses;
    }

    public void setPatientses(Set<Patients> patientses) {
        this.patientses = patientses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Bloodtype)) {
            return false;
        }

        Bloodtype compare = (Bloodtype) obj;

        return compare.bloodtypeid.equals(this.bloodtypeid);
    }

    @Override
    public int hashCode() {
        return bloodtypeid != null ? this.getClass().hashCode() + bloodtypeid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "BloodType{" + "id=" + bloodtypeid + ", name=" + getName() + " }";
    }
}