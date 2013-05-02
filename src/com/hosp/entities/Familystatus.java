package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Familystatus entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FAMILYSTATUS", schema = "HOSPITAL")
public class Familystatus implements java.io.Serializable {

    // Fields
    private BigDecimal familystatusid;
    private String name;

    // Constructors
    /**
     * default constructor
     */
    public Familystatus() {
    }

    /**
     * full constructor
     */
    public Familystatus(BigDecimal familystatusid, String name) {
        this.familystatusid = familystatusid;
        this.name = name;
    }

    // Property accessors
    @Id
    @Column(name = "FAMILYSTATUSID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getFamilystatusid() {
        return this.familystatusid;
    }

    public void setFamilystatusid(BigDecimal familystatusid) {
        this.familystatusid = familystatusid;
    }

    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Familystatus)) {
            return false;
        }

        Familystatus compare = (Familystatus) obj;

        return compare.familystatusid.equals(this.familystatusid);
    }

    @Override
    public int hashCode() {
        return familystatusid != null ? this.getClass().hashCode() + familystatusid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "FamilyStatus{" + "id=" + familystatusid + ", name=" + getName() + "}";
    }
}