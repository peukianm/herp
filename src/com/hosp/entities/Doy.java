package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Doy entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DOY", schema = "HOSPITAL")
public class Doy implements java.io.Serializable {

    // Fields
    private BigDecimal doyid;
    private String name;

    // Constructors
    /**
     * default constructor
     */
    public Doy() {
    }

    /**
     * full constructor
     */
    public Doy(BigDecimal doyid, String name) {
        this.doyid = doyid;
        this.name = name;
    }

    // Property accessors
    @Id
    @Column(name = "DOYID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getDoyid() {
        return this.doyid;
    }

    public void setDoyid(BigDecimal doyid) {
        this.doyid = doyid;
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

        if (!(obj instanceof Doy)) {
            return false;
        }

        Doy compare = (Doy) obj;

        return compare.doyid.equals(this.doyid);
    }

    @Override
    public int hashCode() {
        return doyid != null ? this.getClass().hashCode() + doyid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Doy{" + "id=" + doyid + ", name=" + getName() + " }";
    }
}