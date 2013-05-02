package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Relegion entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RELEGION", schema = "HOSPITAL")
public class Relegion implements java.io.Serializable {

    // Fields
    private BigDecimal relegionid;
    private String name;
    private Set<Patients> patientses = new HashSet<Patients>(0);

    // Constructors
    /**
     * default constructor
     */
    public Relegion() {
    }

    /**
     * minimal constructor
     */
    public Relegion(BigDecimal relegionid, String name) {
        this.relegionid = relegionid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Relegion(BigDecimal relegionid, String name, Set<Patients> patientses) {
        this.relegionid = relegionid;
        this.name = name;
        this.patientses = patientses;
    }

    // Property accessors
    @Id
    @Column(name = "RELEGIONID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getRelegionid() {
        return this.relegionid;
    }

    public void setRelegionid(BigDecimal relegionid) {
        this.relegionid = relegionid;
    }

    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "relegion")
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

        if (!(obj instanceof Relegion)) {
            return false;
        }

        Relegion compare = (Relegion) obj;

        return compare.relegionid.equals(this.relegionid);
    }

    @Override
    public int hashCode() {
        return relegionid != null ? this.getClass().hashCode() + relegionid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Relegion{" + "id=" + relegionid + ", name=" + getName() + " }";
    }
}