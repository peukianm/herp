package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
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
 * LabExams entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "LAB_EXAMS", schema = "HOSPITAL")
public class LabExams implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Exam exam;
	private Lab lab;
	private String value;
	private String amka;
	private Date labdate;
	private BigDecimal updated;
	private String unit;
	private String nrange;
	private String comments;
	private BigDecimal mediwareid;

	// Constructors

	/** default constructor */
	public LabExams() {
	}

	/** minimal constructor */
	public LabExams(BigDecimal id) {
		this.id = id;
	}

	/** full constructor */
	public LabExams(BigDecimal id, Exam exam, Lab lab, String value, String amka, Date labdate, BigDecimal updated, String unit, String nrange,
			String comments, BigDecimal mediwareid) {
		this.id = id;
		this.exam = exam;
		this.lab = lab;
		this.value = value;
		this.amka = amka;
		this.labdate = labdate;
		this.updated = updated;
		this.unit = unit;
		this.nrange = nrange;
		this.comments = comments;
		this.mediwareid = mediwareid;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXAMID")
	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LABID")
	public Lab getLab() {
		return this.lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}

	@Column(name = "VALUE", length = 100)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "AMKA", length = 20)
	public String getAmka() {
		return this.amka;
	}

	public void setAmka(String amka) {
		this.amka = amka;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LABDATE", length = 7)
	public Date getLabdate() {
		return this.labdate;
	}

	public void setLabdate(Date labdate) {
		this.labdate = labdate;
	}

	@Column(name = "UPDATED", precision = 22, scale = 0)
	public BigDecimal getUpdated() {
		return this.updated;
	}

	public void setUpdated(BigDecimal updated) {
		this.updated = updated;
	}

	@Column(name = "UNIT", length = 100)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "NRANGE", length = 1000)
	public String getNrange() {
		return this.nrange;
	}

	public void setNrange(String nrange) {
		this.nrange = nrange;
	}

	@Column(name = "COMMENTS", length = 500)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "MEDIWAREID", precision = 22, scale = 0)
	public BigDecimal getMediwareid() {
		return this.mediwareid;
	}

	public void setMediwareid(BigDecimal mediwareid) {
		this.mediwareid = mediwareid;
	}

}