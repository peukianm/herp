package com.hosp.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * ExParaCounter entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "EX_PARA_COUNTER", schema = "HOSPITAL")
@NamedQuery(
  name="fetchParaCounter",
  query="SELECT counter FROM ExParaCounter counter where counter.hospital= :hospital AND counter.exAssertion= :assertion ")


public class ExParaCounter implements java.io.Serializable {

    // Fields
    private BigDecimal counterid;
    private Hospital hospital;
    private ExAssertion exAssertion;
    private BigDecimal counter;
    
        private Timestamp createdTimestamp;

    // Constructors
    /**
     * default constructor
     */
    public ExParaCounter() {
    }

    /**
     * minimal constructor
     */
    public ExParaCounter(BigDecimal counterid, Hospital hospital, ExAssertion exAssertion, BigDecimal counter) {
        this.counterid = counterid;
        this.hospital = hospital;
        this.exAssertion = exAssertion;
        this.counter = counter;
    }

    /**
     * full constructor
     */
    public ExParaCounter(BigDecimal counterid, Hospital hospital, ExAssertion exAssertion, BigDecimal counter, Timestamp createdTimestamp) {
        this.counterid = counterid;
        this.hospital = hospital;
        this.exAssertion = exAssertion;
        this.counter = counter;
        this.createdTimestamp = createdTimestamp;
    }

    // Property accessors
    @Id
    @Column(name = "COUNTERID", unique = true, nullable = false, precision = 0)
    public BigDecimal getCounterid() {
        return this.counterid;
    }

    public void setCounterid(BigDecimal counterid) {
        this.counterid = counterid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOSPITALID", nullable = false)
    public Hospital getHospital() {
        return this.hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSERTIONID", nullable = false)
    public ExAssertion getExAssertion() {
        return this.exAssertion;
    }

    public void setExAssertion(ExAssertion exAssertion) {
        this.exAssertion = exAssertion;
    }

    @Column(name = "COUNTER", nullable = false,  precision = 22, scale = 0)
    public BigDecimal getCounter() {
        return this.counter;
    }

    public void setCounter(BigDecimal counter) {
        this.counter = counter;
    }

   @Version
   @Column(name = "CREATED_TIMESTAMP", nullable = true, length = 11, insertable=false, updatable=true)
    public Timestamp getCreatedTimestamp() {
        return this.createdTimestamp;
    }
    
    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ExParaCounter)) {
            return false;
        }

        ExParaCounter compare = (ExParaCounter) obj;
        return compare.counterid.equals(this.counterid);
    }


    @Override
    public int hashCode() {
        return counterid != null ? this.getClass().hashCode() + counterid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "ExCounter{" + "id=" + counterid + ", counetr=" + counter + ", assertion=" + exAssertion.getName() + '}';
    }
}