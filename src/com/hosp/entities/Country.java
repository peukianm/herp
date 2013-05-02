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
 * Country entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "COUNTRY", schema = "HOSPITAL")
public class Country implements java.io.Serializable {

    // Fields
    private BigDecimal countryid;
    private String name;
    private String abbrevation;
    private Set<Patients> patientses = new HashSet<Patients>(0);

    // Constructors
    /**
     * default constructor
     */
    public Country() {
    }

    /**
     * minimal constructor
     */
    public Country(BigDecimal countryid) {
        this.countryid = countryid;
    }

    /**
     * full constructor
     */
    public Country(BigDecimal countryid, String name, String abbrevation, Set<Patients> patientses) {
        this.countryid = countryid;
        this.name = name;
        this.abbrevation = abbrevation;
        this.patientses = patientses;
    }

    // Property accessors
    @Id
    @Column(name = "COUNTRYID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getCountryid() {
        return this.countryid;
    }

    public void setCountryid(BigDecimal countryid) {
        this.countryid = countryid;
    }

    @Column(name = "NAME", length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ABBREVATION", length = 50)
    public String getAbbrevation() {
        return this.abbrevation;
    }

    public void setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
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

        if (!(obj instanceof Country)) {
            return false;    
        }

        Country compare = (Country) obj;

        return compare.countryid.equals(this.countryid);
    }

    @Override
    public int hashCode() {
        return countryid != null ? this.getClass().hashCode() + countryid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + countryid + ", name=" + getName() + ", abbrevation=" + getAbbrevation() + '}';
    }
}