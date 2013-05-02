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
 * ExExamCat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_EXAM_CAT", schema = "HOSPITAL")
public class ExExamCat implements java.io.Serializable {

	// Fields

	private BigDecimal examcategoryid;
	private String name;
	private BigDecimal enabled;
	private BigDecimal ordered;
	private Set<ExExam> exExams = new HashSet<ExExam>(0);

	// Constructors

	/** default constructor */
	public ExExamCat() {
	}

	/** minimal constructor */
	public ExExamCat(BigDecimal examcategoryid, String name) {
		this.examcategoryid = examcategoryid;
		this.name = name;
	}

	/** full constructor */
	public ExExamCat(BigDecimal examcategoryid, String name, BigDecimal enabled, BigDecimal ordered, Set<ExExam> exExams) {
		this.examcategoryid = examcategoryid;
		this.name = name;
		this.enabled = enabled;
		this.ordered = ordered;
		this.exExams = exExams;
	}

	// Property accessors
	@Id
	@Column(name = "EXAMCATEGORYID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getExamcategoryid() {
		return this.examcategoryid;
	}

	public void setExamcategoryid(BigDecimal examcategoryid) {
		this.examcategoryid = examcategoryid;
	}

	@Column(name = "NAME", nullable = false, length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ENABLED", precision = 22, scale = 0)
	public BigDecimal getEnabled() {
		return this.enabled;
	}

	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}

	@Column(name = "ORDERED", precision = 22, scale = 0)
	public BigDecimal getOrdered() {
		return this.ordered;
	}

	public void setOrdered(BigDecimal ordered) {
		this.ordered = ordered;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exExamCat")
	public Set<ExExam> getExExams() {
		return this.exExams;
	}

	public void setExExams(Set<ExExam> exExams) {
		this.exExams = exExams;
	}

}