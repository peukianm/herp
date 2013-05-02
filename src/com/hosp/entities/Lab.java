package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Lab entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "LAB", schema = "HOSPITAL")
public class Lab implements java.io.Serializable {

	// Fields

	private BigDecimal labid;
	private Admission admission;
	private Hospital hospital;
	private Patients patients;
	private Department department;
	private Date labdate;
	private BigDecimal image;
	private String type;
	private Set<LabExams> labExamses = new HashSet<LabExams>(0);

	// Constructors

	/** default constructor */
	public Lab() {
	}

	/** minimal constructor */
	public Lab(BigDecimal labid) {
		this.labid = labid;
	}

	/** full constructor */
	public Lab(BigDecimal labid, Admission admission, Hospital hospital, Patients patients, Department department, Date labdate, BigDecimal image, String type,
			Set<LabExams> labExamses) {
		this.labid = labid;
		this.admission = admission;
		this.hospital = hospital;
		this.patients = patients;
		this.department = department;
		this.labdate = labdate;
		this.image = image;
		this.type = type;
		this.labExamses = labExamses;
	}

	// Property accessors
	@Id
	@Column(name = "LABID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getLabid() {
		return this.labid;
	}

	public void setLabid(BigDecimal labid) {
		this.labid = labid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADMISSIONID")
	public Admission getAdmission() {
		return this.admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITALID")
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENTID")
	public Patients getPatients() {
		return this.patients;
	}

	public void setPatients(Patients patients) {
		this.patients = patients;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENTID")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LABDATE", length = 7)
	public Date getLabdate() {
		return this.labdate;
	}

	public void setLabdate(Date labdate) {
		this.labdate = labdate;
	}

	@Column(name = "IMAGE", precision = 22, scale = 0)
	public BigDecimal getImage() {
		return this.image;
	}

	public void setImage(BigDecimal image) {
		this.image = image;
	}

	@Column(name = "TYPE", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lab")
	public Set<LabExams> getLabExamses() {
		return this.labExamses;
	}

	public void setLabExamses(Set<LabExams> labExamses) {
		this.labExamses = labExamses;
	}

}