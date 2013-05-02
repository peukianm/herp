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
 * ExParaType entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_PARA_TYPE", schema = "HOSPITAL")
public class ExParaType implements java.io.Serializable {

    // Fields
    private BigDecimal paratypeid;
    private Hospital hospital;
    private String name;
    private BigDecimal enabled;
    private Set<ExPara> exParas = new HashSet<ExPara>(0);

    // Constructors
    /**
     * default constructor
     */
    public ExParaType() {
    }

    /**
     * minimal constructor
     */
    public ExParaType(BigDecimal paratypeid, Hospital hospital, String name, BigDecimal enabled) {
        this.paratypeid = paratypeid;
        this.hospital = hospital;
        this.name = name;
        this.enabled = enabled;
    }

    /**
     * full constructor
     */
    public ExParaType(BigDecimal paratypeid, Hospital hospital, String name, BigDecimal enabled, Set<ExPara> exParas) {
        this.paratypeid = paratypeid;
        this.hospital = hospital;
        this.name = name;
        this.enabled = enabled;
        this.exParas = exParas;
    }

    // Property accessors
    @Id
    @Column(name = "PARATYPEID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getParatypeid() {
        return this.paratypeid;
    }

    public void setParatypeid(BigDecimal paratypeid) {
        this.paratypeid = paratypeid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOSPITALID", nullable = false)
    public Hospital getHospital() {
        return this.hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ENABLED", nullable = false, precision = 22, scale = 0)
    public BigDecimal getEnabled() {
        return this.enabled;
    }

    public void setEnabled(BigDecimal enabled) {
        this.enabled = enabled;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exParaType")
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

        if (!(obj instanceof ExParaType)) {
            return false;
        }

        ExParaType compare = (ExParaType) obj;

        return compare.paratypeid.equals(this.paratypeid);
    }

    @Override
    public int hashCode() {
        return paratypeid != null ? this.getClass().hashCode() + paratypeid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "ExParaType{" + "id=" + paratypeid + ", name=" + getName() + "}";
    }
}