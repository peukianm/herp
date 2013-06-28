package com.hosp.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Cacheable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ExTimol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(true)
@Table(name = "EX_TIMOL", schema = "HOSPITAL")
public class ExTimol implements java.io.Serializable {

	// Fields

	private BigDecimal timolid;
	private Hospital hospital;
	private ExAssertion exAssertion;
	private String code;
	private BigDecimal amount;
	private Date timoldate;
	private BigDecimal enabled;
	private Timestamp createdTimestamp;

	// Constructors

	/** default constructor */
	public ExTimol() {
	}

	/** minimal constructor */
	public ExTimol(BigDecimal timolid, Hospital hospital, String code, BigDecimal amount, Timestamp createdTimestamp) {
		this.timolid = timolid;
		this.hospital = hospital;
		this.code = code;
		this.amount = amount;
		this.createdTimestamp = createdTimestamp;
	}

	/** full constructor */
	public ExTimol(BigDecimal timolid, Hospital hospital, ExAssertion exAssertion, String code, BigDecimal amount, Date timoldate, BigDecimal enabled,
			Timestamp createdTimestamp) {
		this.timolid = timolid;
		this.hospital = hospital;
		this.exAssertion = exAssertion;
		this.code = code;
		this.amount = amount;
		this.timoldate = timoldate;
		this.enabled = enabled;
		this.createdTimestamp = createdTimestamp;
	}

	// Property accessors
	@Id
	@Column(name = "TIMOLID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getTimolid() {
		return this.timolid;
	}

	public void setTimolid(BigDecimal timolid) {
		this.timolid = timolid;
	}

	@ManyToOne(fetch = FetchType.LAZY)  //UPDATED !!!!!!!!!!!!!!!!!
	@JoinColumn(name = "HOSPITALID", nullable = false)
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@ManyToOne(fetch = FetchType.LAZY)  //UPDATED !!!!!!!!!!!!!!!!!
	@JoinColumn(name = "ASSERTIONID")
	public ExAssertion getExAssertion() {
		//exAssertion.toString();
		return this.exAssertion;
	}

	public void setExAssertion(ExAssertion exAssertion) {
		this.exAssertion = exAssertion;
	}

	@Column(name = "CODE", nullable = false, length = 50)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "AMOUNT", nullable = false, precision = 22, scale = 2)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TIMOLDATE", length = 7)
	public Date getTimoldate() {
		return this.timoldate;
	}

	public void setTimoldate(Date timoldate) {
		this.timoldate = timoldate;
	}

	@Column(name = "ENABLED", precision = 22, scale = 0)
	public BigDecimal getEnabled() {
		return this.enabled;
	}

	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}

	@Column(name = "CREATED_TIMESTAMP", nullable = true, length = 11, insertable=false, updatable=true)
	public Timestamp getCreatedTimestamp() {
		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
	// This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof ExTimol && (timolid != null) ? timolid.equals(((ExTimol) other).timolid) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return timolid != null ? this.getClass().hashCode() + timolid.hashCode() : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String representation.
    // It is not required by the Converter or so, it just pleases the reading in the logs.
    public String toString() {
        return "ExTimol[" + timolid + "," + code + "]";
    }

}