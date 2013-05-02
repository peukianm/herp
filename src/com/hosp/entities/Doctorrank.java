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
 * Doctorrank entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DOCTORRANK", schema = "HOSPITAL")
public class Doctorrank implements java.io.Serializable {

    // Fields
    private BigDecimal rankid;
    private String name;
    private BigDecimal enable;
    private BigDecimal ordered;
    private Set<Surgeon> surgeons = new HashSet<Surgeon>(0);

    // Constructors
    /**
     * default constructor
     */
    public Doctorrank() {
    }

    /**
     * minimal constructor
     */
    public Doctorrank(BigDecimal rankid, String name) {
        this.rankid = rankid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Doctorrank(BigDecimal rankid, String name, BigDecimal enable, BigDecimal ordered, Set<Surgeon> surgeons) {
        this.rankid = rankid;
        this.name = name;
        this.enable = enable;
        this.ordered = ordered;
        this.surgeons = surgeons;
    }

    // Property accessors
    @Id
    @Column(name = "RANKID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getRankid() {
        return this.rankid;
    }

    public void setRankid(BigDecimal rankid) {
        this.rankid = rankid;
    }

    @Column(name = "NAME", nullable = false, length = 120)
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "doctorrank")
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

        if (!(obj instanceof Doctorrank)) {
            return false;
        }

        Doctorrank compare = (Doctorrank) obj;

        return compare.rankid.equals(this.rankid);
    }

    @Override
    public int hashCode() {
        return rankid != null ? this.getClass().hashCode() + rankid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "DoctorRank{" + "id=" + rankid + ", name=" + getName() + " }";
    }
}