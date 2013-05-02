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
 * Packaging entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "PACKAGING", schema = "HOSPITAL")
public class Packaging implements java.io.Serializable {

    // Fields
    private BigDecimal packagingid;
    private String name;
    private String code;
    private Set<Drugs> drugses = new HashSet<Drugs>(0);

    // Constructors
    /**
     * default constructor
     */
    public Packaging() {
    }

    /**
     * minimal constructor
     */
    public Packaging(BigDecimal packagingid, String name) {
        this.packagingid = packagingid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Packaging(BigDecimal packagingid, String name, String code, Set<Drugs> drugses) {
        this.packagingid = packagingid;
        this.name = name;
        this.code = code;
        this.drugses = drugses;
    }

    // Property accessors
    @Id
    @Column(name = "PACKAGINGID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getPackagingid() {
        return this.packagingid;
    }

    public void setPackagingid(BigDecimal packagingid) {
        this.packagingid = packagingid;
    }

    @Column(name = "NAME", nullable = false, length = 4000)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CODE", length = 4000)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "packaging")
    public Set<Drugs> getDrugses() {
        return this.drugses;
    }

    public void setDrugses(Set<Drugs> drugses) {
        this.drugses = drugses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Packaging)) {
            return false;
        }

        Packaging compare = (Packaging) obj;

        return compare.packagingid.equals(this.packagingid);
    }

    @Override
    public int hashCode() {
        return packagingid != null ? this.getClass().hashCode() + packagingid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Packaging{" + "id=" + packagingid + ", name=" + getName() + " }";
    }
}