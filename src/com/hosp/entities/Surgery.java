package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Cacheable;
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
 * Surgery entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "SURGERY", schema = "HOSPITAL")
public class Surgery implements java.io.Serializable {

	// Fields

	private BigDecimal surgeryid;
	private Admission admission;
	private Hospital hospital;
	private Surgeon surgeonBySecondassistantid;
	private Patients patients;
	private Department department;
	private Surgeon surgeonBySecondsurgeonid;
	private Surgeon surgeonByFirstassistantid;
	private Surgeon surgeonByFirstsurgeonid;
	private String name;
	private String comments;
	private Date surgerydate;

	// Constructors

	/** default constructor */
	public Surgery() {
	}

	/** minimal constructor */
	public Surgery(BigDecimal surgeryid) {
		this.surgeryid = surgeryid;
	}

	/** full constructor */
	public Surgery(BigDecimal surgeryid, Admission admission, Hospital hospital, Surgeon surgeonBySecondassistantid, Patients patients, Department department,
			Surgeon surgeonBySecondsurgeonid, Surgeon surgeonByFirstassistantid, Surgeon surgeonByFirstsurgeonid, String name, String comments, Date surgerydate) {
		this.surgeryid = surgeryid;
		this.admission = admission;
		this.hospital = hospital;
		this.surgeonBySecondassistantid = surgeonBySecondassistantid;
		this.patients = patients;
		this.department = department;
		this.surgeonBySecondsurgeonid = surgeonBySecondsurgeonid;
		this.surgeonByFirstassistantid = surgeonByFirstassistantid;
		this.surgeonByFirstsurgeonid = surgeonByFirstsurgeonid;
		this.name = name;
		this.comments = comments;
		this.surgerydate = surgerydate;
	}

	// Property accessors
	@Id
	@Column(name = "SURGERYID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getSurgeryid() {
		return this.surgeryid;
	}

	public void setSurgeryid(BigDecimal surgeryid) {
		this.surgeryid = surgeryid;
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
	@JoinColumn(name = "SECONDASSISTANTID")
	public Surgeon getSurgeonBySecondassistantid() {
		return this.surgeonBySecondassistantid;
	}

	public void setSurgeonBySecondassistantid(Surgeon surgeonBySecondassistantid) {
		this.surgeonBySecondassistantid = surgeonBySecondassistantid;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECONDSURGEONID")
	public Surgeon getSurgeonBySecondsurgeonid() {
		return this.surgeonBySecondsurgeonid;
	}

	public void setSurgeonBySecondsurgeonid(Surgeon surgeonBySecondsurgeonid) {
		this.surgeonBySecondsurgeonid = surgeonBySecondsurgeonid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIRSTASSISTANTID")
	public Surgeon getSurgeonByFirstassistantid() {
		return this.surgeonByFirstassistantid;
	}

	public void setSurgeonByFirstassistantid(Surgeon surgeonByFirstassistantid) {
		this.surgeonByFirstassistantid = surgeonByFirstassistantid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIRSTSURGEONID")
	public Surgeon getSurgeonByFirstsurgeonid() {
		return this.surgeonByFirstsurgeonid;
	}

	public void setSurgeonByFirstsurgeonid(Surgeon surgeonByFirstsurgeonid) {
		this.surgeonByFirstsurgeonid = surgeonByFirstsurgeonid;
	}

	@Column(name = "NAME", length = 400)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "COMMENTS", length = 4000)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SURGERYDATE", length = 7)
	public Date getSurgerydate() {
		return this.surgerydate;
	}

	public void setSurgerydate(Date surgerydate) {
		this.surgerydate = surgerydate;
	}

}