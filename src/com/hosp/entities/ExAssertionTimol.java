package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ExAssertionTimol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(true)
@Table(name = "EX_ASSERTION_TIMOL", schema = "HOSPITAL")
public class ExAssertionTimol implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private BigDecimal assertionid;
	private BigDecimal timolid;

	// Constructors

	/** default constructor */
	public ExAssertionTimol() {
	}

	/** full constructor */
	public ExAssertionTimol(BigDecimal id, BigDecimal assertionid, BigDecimal timolid) {
		this.id = id;
		this.assertionid = assertionid;
		this.timolid = timolid;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "ASSERTIONID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getAssertionid() {
		return this.assertionid;
	}

	public void setAssertionid(BigDecimal assertionid) {
		this.assertionid = assertionid;
	}

	@Column(name = "TIMOLID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTimolid() {
		return this.timolid;
	}

	public void setTimolid(BigDecimal timolid) {
		this.timolid = timolid;
	}

}