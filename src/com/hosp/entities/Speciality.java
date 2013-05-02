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
 * Speciality entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "SPECIALITY", schema = "HOSPITAL")
public class Speciality implements java.io.Serializable {

    // Fields
    private BigDecimal specialityid;
    private String name;
    private BigDecimal enable;
    private BigDecimal ordered;
    private Set<Surgeon> surgeons = new HashSet<Surgeon>(0);

    // Constructors
    /**
     * default constructor
     */
    public Speciality() {
    }

    /**
     * minimal constructor
     */
    public Speciality(BigDecimal specialityid, String name) {
        this.specialityid = specialityid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Speciality(BigDecimal specialityid, String name, BigDecimal enable, BigDecimal ordered, Set<Surgeon> surgeons) {
        this.specialityid = specialityid;
        this.name = name;
        this.enable = enable;
        this.ordered = ordered;
        this.surgeons = surgeons;
    }

    // Property accessors
    @Id
    @Column(name = "SPECIALITYID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getSpecialityid() {
        return this.specialityid;
    }

    public void setSpecialityid(BigDecimal specialityid) {
        this.specialityid = specialityid;
    }

    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ENABLE", precision = 22, scale = 0)
    public BigDecimal getEnable() {
        return this.enable;
    }

    public void setEnable(BigDecimal enable) {
        this.enable = enable;
    }

    @Column(name = "ORDERED", precision = 22, scale = 0)
    public BigDecimal getOrdered() {
        return this.ordered;
    }

    public void setOrdered(BigDecimal ordered) {
        this.ordered = ordered;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "speciality")
    public Set<Surgeon> getSurgeons() {
        return this.surgeons;
    }

    public void setSurgeons(Set<Surgeon> surgeons) {
        this.surgeons = surgeons;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Speciality)) {
            return false;
        }

        Speciality compare = (Speciality) obj;

        return compare.specialityid.equals(this.specialityid);
    }

    @Override
    public int hashCode() {
        return specialityid != null ? this.getClass().hashCode() + specialityid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Speciality{" + "id=" + specialityid + ", name=" + getName() + " }";
    }
}