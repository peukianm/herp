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
 * Admission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ADMISSION", schema = "HOSPITAL")
public class Admission implements java.io.Serializable {

	// Fields

	private BigDecimal admissionid;
	private Hospital hospital;
	private Patients patients;
	private Department department;
	private Outcome outcome;
	private Date startdate;
	private Date enddate;
	private String inside;
	private String symptoms;
	private String comments;
	private String bed;
	private String room;
	private String icd;
	private String icdname;
	private String ken;
	private String kenname;
	private String instructions;
	private String admissiontime;
	private Set<Lab> labs = new HashSet<Lab>(0);
	private Set<Surgery> surgeries = new HashSet<Surgery>(0);
	private Set<Recipe> recipes = new HashSet<Recipe>(0);
	private Set<MaterialAdmission> materialAdmissions = new HashSet<MaterialAdmission>(0);

	// Constructors

	/** default constructor */
	public Admission() {
	}

	/** minimal constructor */
	public Admission(BigDecimal admissionid, Patients patients, Department department, Date startdate, String inside) {
		this.admissionid = admissionid;
		this.patients = patients;
		this.department = department;
		this.startdate = startdate;
		this.inside = inside;
	}

	/** full constructor */
	public Admission(BigDecimal admissionid, Hospital hospital, Patients patients, Department department, Outcome outcome, Date startdate, Date enddate,
			String inside, String symptoms, String comments, String bed, String room, String icd, String icdname, String ken, String kenname,
			String instructions, String admissiontime, Set<Lab> labs, Set<Surgery> surgeries, Set<Recipe> recipes, Set<MaterialAdmission> materialAdmissions) {
		this.admissionid = admissionid;
		this.hospital = hospital;
		this.patients = patients;
		this.department = department;
		this.outcome = outcome;
		this.startdate = startdate;
		this.enddate = enddate;
		this.inside = inside;
		this.symptoms = symptoms;
		this.comments = comments;
		this.bed = bed;
		this.room = room;
		this.icd = icd;
		this.icdname = icdname;
		this.ken = ken;
		this.kenname = kenname;
		this.instructions = instructions;
		this.admissiontime = admissiontime;
		this.labs = labs;
		this.surgeries = surgeries;
		this.recipes = recipes;
		this.materialAdmissions = materialAdmissions;
	}

	// Property accessors
	@Id
	@Column(name = "ADMISSIONID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getAdmissionid() {
		return this.admissionid;
	}

	public void setAdmissionid(BigDecimal admissionid) {
		this.admissionid = admissionid;
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
	@JoinColumn(name = "PATIENTID", nullable = false)
	public Patients getPatients() {
		return this.patients;
	}

	public void setPatients(Patients patients) {
		this.patients = patients;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENTID", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OUTCOMEID")
	public Outcome getOutcome() {
		return this.outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", nullable = false, length = 7)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE", length = 7)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Column(name = "INSIDE", nullable = false, length = 30)
	public String getInside() {
		return this.inside;
	}

	public void setInside(String inside) {
		this.inside = inside;
	}

	@Column(name = "SYMPTOMS", length = 1000)
	public String getSymptoms() {
		return this.symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	@Column(name = "COMMENTS", length = 4000)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "BED", length = 20)
	public String getBed() {
		return this.bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	@Column(name = "ROOM", length = 20)
	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Column(name = "ICD", length = 40)
	public String getIcd() {
		return this.icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

	@Column(name = "ICDNAME", length = 4000)
	public String getIcdname() {
		return this.icdname;
	}

	public void setIcdname(String icdname) {
		this.icdname = icdname;
	}

	@Column(name = "KEN", length = 40)
	public String getKen() {
		return this.ken;
	}

	public void setKen(String ken) {
		this.ken = ken;
	}

	@Column(name = "KENNAME", length = 4000)
	public String getKenname() {
		return this.kenname;
	}

	public void setKenname(String kenname) {
		this.kenname = kenname;
	}

	@Column(name = "INSTRUCTIONS", length = 4000)
	public String getInstructions() {
		return this.instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@Column(name = "ADMISSIONTIME", length = 20)
	public String getAdmissiontime() {
		return this.admissiontime;
	}

	public void setAdmissiontime(String admissiontime) {
		this.admissiontime = admissiontime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admission")
	public Set<Lab> getLabs() {
		return this.labs;
	}

	public void setLabs(Set<Lab> labs) {
		this.labs = labs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admission")
	public Set<Surgery> getSurgeries() {
		return this.surgeries;
	}

	public void setSurgeries(Set<Surgery> surgeries) {
		this.surgeries = surgeries;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admission")
	public Set<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admission")
	public Set<MaterialAdmission> getMaterialAdmissions() {
		return this.materialAdmissions;
	}

	public void setMaterialAdmissions(Set<MaterialAdmission> materialAdmissions) {
		this.materialAdmissions = materialAdmissions;
	}

}