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
 * Nationality entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "NATIONALITY", schema = "HOSPITAL")
public class Nationality implements java.io.Serializable {

    // Fields
    private BigDecimal nationalityid;
    private String name;
    private Set<Patients> patientses = new HashSet<Patients>(0);

    // Constructors
    /**
     * default constructor
     */
    public Nationality() {
    }

    /**
     * minimal constructor
     */
    public Nationality(BigDecimal nationalityid, String name) {
        this.nationalityid = nationalityid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Nationality(BigDecimal nationalityid, String name, Set<Patients> patientses) {
        this.nationalityid = nationalityid;
        this.name = name;
        this.patientses = patientses;
    }

    // Property accessors
    @Id
    @Column(name = "NATIONALITYID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getNationalityid() {
        return this.nationalityid;
    }

    public void setNationalityid(BigDecimal nationalityid) {
        this.nationalityid = nationalityid;
    }

    @Column(name = "NAME", nullable = false, length = 400)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "nationality")
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

        if (!(obj instanceof Nationality)) {
            return false;
        }

        Nationality compare = (Nationality) obj;

        return compare.nationalityid.equals(this.nationalityid);
    }

    @Override
    public int hashCode() {
        return nationalityid != null ? this.getClass().hashCode() + nationalityid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Nationality{" + "id=" + nationalityid + ", name=" + getName() + " }";
    }
}