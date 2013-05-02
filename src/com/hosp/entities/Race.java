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
 * Race entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RACE", schema = "HOSPITAL")
public class Race implements java.io.Serializable {

    // Fields
    private BigDecimal raceid;
    private String name;
    private Set<Patients> patientses = new HashSet<Patients>(0);

    // Constructors
    /**
     * default constructor
     */
    public Race() {
    }

    /**
     * minimal constructor
     */
    public Race(BigDecimal raceid, String name) {
        this.raceid = raceid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Race(BigDecimal raceid, String name, Set<Patients> patientses) {
        this.raceid = raceid;
        this.name = name;
        this.patientses = patientses;
    }

    // Property accessors
    @Id
    @Column(name = "RACEID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getRaceid() {
        return this.raceid;
    }

    public void setRaceid(BigDecimal raceid) {
        this.raceid = raceid;
    }

    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "race")
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

        if (!(obj instanceof Race)) {
            return false;
        }

        Race compare = (Race) obj;

        return compare.raceid.equals(this.raceid);
    }

    @Override
    public int hashCode() {
        return raceid != null ? this.getClass().hashCode() + raceid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Race{" + "id=" + raceid + ", name=" + getName() + " }";
    }
}