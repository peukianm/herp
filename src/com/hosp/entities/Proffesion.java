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
 * Proffesion entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PROFFESION", schema = "HOSPITAL")
public class Proffesion implements java.io.Serializable {

    // Fields
    private BigDecimal proffesionid;
    private String name;
    private BigDecimal nsoid;
    private Set<Patients> patientses = new HashSet<Patients>(0);

    // Constructors
    /**
     * default constructor
     */
    public Proffesion() {
    }

    /**
     * minimal constructor
     */
    public Proffesion(BigDecimal proffesionid, String name) {
        this.proffesionid = proffesionid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Proffesion(BigDecimal proffesionid, String name, BigDecimal nsoid, Set<Patients> patientses) {
        this.proffesionid = proffesionid;
        this.name = name;
        this.nsoid = nsoid;
        this.patientses = patientses;
    }

    // Property accessors
    @Id
    @Column(name = "PROFFESIONID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getProffesionid() {
        return this.proffesionid;
    }

    public void setProffesionid(BigDecimal proffesionid) {
        this.proffesionid = proffesionid;
    }

    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "NSOID", precision = 22, scale = 0)
    public BigDecimal getNsoid() {
        return this.nsoid;
    }

    public void setNsoid(BigDecimal nsoid) {
        this.nsoid = nsoid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proffesion")
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

        if (!(obj instanceof Proffesion)) {
            return false;
        }

        Proffesion compare = (Proffesion) obj;

        return compare.proffesionid.equals(this.proffesionid);
    }

    @Override
    public int hashCode() {
        return proffesionid != null ? this.getClass().hashCode() + proffesionid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Proffession{" + "id=" + proffesionid + ", name=" + getName() + " }";
    }
}