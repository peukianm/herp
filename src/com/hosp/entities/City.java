package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * City entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CITY", schema = "HOSPITAL")
public class City implements java.io.Serializable {

    // Fields
    private BigDecimal cityid;
    private Prefecture prefecture;
    private String name;
    private Set<Patients> patientses = new HashSet<Patients>(0);

    // Constructors
    /**
     * default constructor
     */
    public City() {
    }

    /**
     * minimal constructor
     */
    public City(BigDecimal cityid, String name) {
        this.cityid = cityid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public City(BigDecimal cityid, Prefecture prefecture, String name, Set<Patients> patientses) {
        this.cityid = cityid;
        this.prefecture = prefecture;
        this.name = name;
        this.patientses = patientses;
    }

    // Property accessors
    @Id
    @Column(name = "CITYID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getCityid() {
        return this.cityid;
    }

    public void setCityid(BigDecimal cityid) {
        this.cityid = cityid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PREFECTUREID")
    public Prefecture getPrefecture() {
        return this.prefecture;
    }

    public void setPrefecture(Prefecture prefecture) {
        this.prefecture = prefecture;
    }

    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
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

        if (!(obj instanceof City)) {
            return false;
        }

        City compare = (City) obj;

        return compare.cityid.equals(this.cityid);
    }

    @Override
    public int hashCode() {
        return cityid != null ? this.getClass().hashCode() + cityid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "City{" + "id=" + cityid + ", name=" + getName() + " }";
    }
}