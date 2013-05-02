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
 * Sample entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SAMPLE", schema = "HOSPITAL")
public class Sample implements java.io.Serializable {

	// Fields

	private BigDecimal sampleid;
	private String name;
	private Set<Exam> exams = new HashSet<Exam>(0);

	// Constructors

	/** default constructor */
	public Sample() {
	}

	/** minimal constructor */
	public Sample(BigDecimal sampleid) {
		this.sampleid = sampleid;
	}

	/** full constructor */
	public Sample(BigDecimal sampleid, String name, Set<Exam> exams) {
		this.sampleid = sampleid;
		this.name = name;
		this.exams = exams;
	}

	// Property accessors
	@Id
	@Column(name = "SAMPLEID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getSampleid() {
		return this.sampleid;
	}

	public void setSampleid(BigDecimal sampleid) {
		this.sampleid = sampleid;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sample")
	public Set<Exam> getExams() {
		return this.exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

}