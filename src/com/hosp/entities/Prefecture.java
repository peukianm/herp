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
 * Prefecture entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PREFECTURE", schema = "HOSPITAL")
public class Prefecture implements java.io.Serializable {

    // Fields
    private BigDecimal prefectureid;
    private String name;
    private BigDecimal orderno;
    private Set<Patients> patientses = new HashSet<Patients>(0);
    private Set<City> cities = new HashSet<City>(0);

    // Constructors
    /**
     * default constructor
     */
    public Prefecture() {
    }

    /**
     * minimal constructor
     */
    public Prefecture(BigDecimal prefectureid, String name) {
        this.prefectureid = prefectureid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Prefecture(BigDecimal prefectureid, String name, BigDecimal orderno, Set<Patients> patientses, Set<City> cities) {
        this.prefectureid = prefectureid;
        this.name = name;
        this.orderno = orderno;
        this.patientses = patientses;
        this.cities = cities;
    }

    // Property accessors
    @Id
    @Column(name = "PREFECTUREID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getPrefectureid() {
        return this.prefectureid;
    }

    public void setPrefectureid(BigDecimal prefectureid) {
        this.prefectureid = prefectureid;
    }

    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ORDERNO", precision = 22, scale = 0)
    public BigDecimal getOrderno() {
        return this.orderno;
    }

    public void setOrderno(BigDecimal orderno) {
        this.orderno = orderno;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prefecture")
    public Set<Patients> getPatientses() {
        return this.patientses;
    }

    public void setPatientses(Set<Patients> patientses) {
        this.patientses = patientses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prefecture")
    public Set<City> getCities() {
        return this.cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Prefecture)) {
            return false;
        }

        Prefecture compare = (Prefecture) obj;

        return compare.prefectureid.equals(this.prefectureid);
    }

    @Override
    public int hashCode() {
        return prefectureid != null ? this.getClass().hashCode() + prefectureid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Prefecture{" + "id=" + prefectureid + ", name=" + getName() + " }";
    }
}