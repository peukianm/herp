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
 * Outcome entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "OUTCOME", schema = "HOSPITAL")
public class Outcome implements java.io.Serializable {

	// Fields

	private BigDecimal outcomeid;
	private String name;
	private Set<Admission> admissions = new HashSet<Admission>(0);

	// Constructors

	/** default constructor */
	public Outcome() {
	}

	/** minimal constructor */
	public Outcome(BigDecimal outcomeid, String name) {
		this.outcomeid = outcomeid;
		this.name = name;
	}

	/** full constructor */
	public Outcome(BigDecimal outcomeid, String name, Set<Admission> admissions) {
		this.outcomeid = outcomeid;
		this.name = name;
		this.admissions = admissions;
	}

	// Property accessors
	@Id
	@Column(name = "OUTCOMEID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getOutcomeid() {
		return this.outcomeid;
	}

	public void setOutcomeid(BigDecimal outcomeid) {
		this.outcomeid = outcomeid;
	}

	@Column(name = "NAME", nullable = false, length = 4000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "outcome")
	public Set<Admission> getAdmissions() {
		return this.admissions;
	}

	public void setAdmissions(Set<Admission> admissions) {
		this.admissions = admissions;
	}

}