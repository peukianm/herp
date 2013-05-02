package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Exam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM", schema = "HOSPITAL")
public class Exam implements java.io.Serializable {

	// Fields

	private BigDecimal examid;
	private Sample sample;
	private Examcategory examcategory;
	private String name;
	private String description;
	private BigDecimal enable;
	private BigDecimal labId;
	private BigDecimal ordered;
	private String abrev;
	private BigDecimal medilis;
	private String unit;
	private String nrm;
	private String nrw;
	private String nrc;
	private String nrmf;
	private String nrmt;
	private String nrwf;
	private String nrwt;
	private String nrcf;
	private String nrct;
	private Set<LabExams> labExamses = new HashSet<LabExams>(0);

	// Constructors

	/** default constructor */
	public Exam() {
	}

	/** minimal constructor */
	public Exam(BigDecimal examid) {
		this.examid = examid;
	}

	/** full constructor */
	public Exam(BigDecimal examid, Sample sample, Examcategory examcategory, String name, String description, BigDecimal enable, BigDecimal labId,
			BigDecimal ordered, String abrev, BigDecimal medilis, String unit, String nrm, String nrw, String nrc, String nrmf, String nrmt, String nrwf,
			String nrwt, String nrcf, String nrct, Set<LabExams> labExamses) {
		this.examid = examid;
		this.sample = sample;
		this.examcategory = examcategory;
		this.name = name;
		this.description = description;
		this.enable = enable;
		this.labId = labId;
		this.ordered = ordered;
		this.abrev = abrev;
		this.medilis = medilis;
		this.unit = unit;
		this.nrm = nrm;
		this.nrw = nrw;
		this.nrc = nrc;
		this.nrmf = nrmf;
		this.nrmt = nrmt;
		this.nrwf = nrwf;
		this.nrwt = nrwt;
		this.nrcf = nrcf;
		this.nrct = nrct;
		this.labExamses = labExamses;
	}

	// Property accessors
	@Id
	@Column(name = "EXAMID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getExamid() {
		return this.examid;
	}

	public void setExamid(BigDecimal examid) {
		this.examid = examid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SAMPLEID")
	public Sample getSample() {
		return this.sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXAMCATEGORYID")
	public Examcategory getExamcategory() {
		return this.examcategory;
	}

	public void setExamcategory(Examcategory examcategory) {
		this.examcategory = examcategory;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ENABLE", precision = 22, scale = 0)
	public BigDecimal getEnable() {
		return this.enable;
	}

	public void setEnable(BigDecimal enable) {
		this.enable = enable;
	}

	@Column(name = "LAB_ID", precision = 22, scale = 0)
	public BigDecimal getLabId() {
		return this.labId;
	}

	public void setLabId(BigDecimal labId) {
		this.labId = labId;
	}

	@Column(name = "ORDERED", precision = 22, scale = 0)
	public BigDecimal getOrdered() {
		return this.ordered;
	}

	public void setOrdered(BigDecimal ordered) {
		this.ordered = ordered;
	}

	@Column(name = "ABREV", length = 20)
	public String getAbrev() {
		return this.abrev;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	@Column(name = "MEDILIS", precision = 22, scale = 0)
	public BigDecimal getMedilis() {
		return this.medilis;
	}

	public void setMedilis(BigDecimal medilis) {
		this.medilis = medilis;
	}

	@Column(name = "UNIT", length = 100)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "NRM", length = 500)
	public String getNrm() {
		return this.nrm;
	}

	public void setNrm(String nrm) {
		this.nrm = nrm;
	}

	@Column(name = "NRW", length = 500)
	public String getNrw() {
		return this.nrw;
	}

	public void setNrw(String nrw) {
		this.nrw = nrw;
	}

	@Column(name = "NRC", length = 500)
	public String getNrc() {
		return this.nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	@Column(name = "NRMF", length = 500)
	public String getNrmf() {
		return this.nrmf;
	}

	public void setNrmf(String nrmf) {
		this.nrmf = nrmf;
	}

	@Column(name = "NRMT", length = 500)
	public String getNrmt() {
		return this.nrmt;
	}

	public void setNrmt(String nrmt) {
		this.nrmt = nrmt;
	}

	@Column(name = "NRWF", length = 500)
	public String getNrwf() {
		return this.nrwf;
	}

	public void setNrwf(String nrwf) {
		this.nrwf = nrwf;
	}

	@Column(name = "NRWT", length = 500)
	public String getNrwt() {
		return this.nrwt;
	}

	public void setNrwt(String nrwt) {
		this.nrwt = nrwt;
	}

	@Column(name = "NRCF", length = 500)
	public String getNrcf() {
		return this.nrcf;
	}

	public void setNrcf(String nrcf) {
		this.nrcf = nrcf;
	}

	@Column(name = "NRCT", length = 500)
	public String getNrct() {
		return this.nrct;
	}

	public void setNrct(String nrct) {
		this.nrct = nrct;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exam")
	public Set<LabExams> getLabExamses() {
		return this.labExamses;
	}

	public void setLabExamses(Set<LabExams> labExamses) {
		this.labExamses = labExamses;
	}

}