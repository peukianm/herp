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
 * ExType entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_TYPE", schema = "HOSPITAL")
public class ExType implements java.io.Serializable {

    // Fields
    private BigDecimal typeid;
    private String name;
    private Set<ExPara> exParas = new HashSet<ExPara>(0);

    // Constructors
    /**
     * default constructor
     */
    public ExType() {
    }

    /**
     * minimal constructor
     */
    public ExType(BigDecimal typeid, String name) {
        this.typeid = typeid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public ExType(BigDecimal typeid, String name, Set<ExPara> exParas) {
        this.typeid = typeid;
        this.name = name;
        this.exParas = exParas;
    }

    // Property accessors
    @Id
    @Column(name = "TYPEID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getTypeid() {
        return this.typeid;
    }

    public void setTypeid(BigDecimal typeid) {
        this.typeid = typeid;
    }

    @Column(name = "NAME", nullable = false, length = 30)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exType")
    public Set<ExPara> getExParas() {
        return this.exParas;
    }

    public void setExParas(Set<ExPara> exParas) {
        this.exParas = exParas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ExType)) {
            return false;
        }

        ExType compare = (ExType) obj;

        return compare.typeid.equals(this.typeid);
    }

    @Override
    public int hashCode() {
        return typeid != null ? this.getClass().hashCode() + typeid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "ExType{" + "id=" + typeid + ", name=" + getName() + "}";
    }
}