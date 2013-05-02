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
 * Examcategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAMCATEGORY", schema = "HOSPITAL")
public class Examcategory implements java.io.Serializable {

	// Fields

	private BigDecimal examcategoryid;
	private String name;
	private BigDecimal enable;
	private BigDecimal ordered;
	private BigDecimal image;
	private BigDecimal labId;
	private Set<Exam> exams = new HashSet<Exam>(0);

	// Constructors

	/** default constructor */
	public Examcategory() {
	}

	/** minimal constructor */
	public Examcategory(BigDecimal examcategoryid, String name) {
		this.examcategoryid = examcategoryid;
		this.name = name;
	}

	/** full constructor */
	public Examcategory(BigDecimal examcategoryid, String name, BigDecimal enable, BigDecimal ordered, BigDecimal image, BigDecimal labId, Set<Exam> exams) {
		this.examcategoryid = examcategoryid;
		this.name = name;
		this.enable = enable;
		this.ordered = ordered;
		this.image = image;
		this.labId = labId;
		this.exams = exams;
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

	@Column(name = "NAME", nullable = false, length = 50)
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

	@Column(name = "IMAGE", precision = 22, scale = 0)
	public BigDecimal getImage() {
		return this.image;
	}

	public void setImage(BigDecimal image) {
		this.image = image;
	}

	@Column(name = "LAB_ID", precision = 22, scale = 0)
	public BigDecimal getLabId() {
		return this.labId;
	}

	public void setLabId(BigDecimal labId) {
		this.labId = labId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "examcategory")
	public Set<Exam> getExams() {
		return this.exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

}