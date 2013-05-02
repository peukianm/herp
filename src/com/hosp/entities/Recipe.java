package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
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
 * Recipe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "RECIPE", schema = "HOSPITAL")
public class Recipe implements java.io.Serializable {

	// Fields

	private BigDecimal recipeid;
	private Admission admission;
	private Hospital hospital;
	private Patients patients;
	private Department department;
	private Orders orders;
	private Date dateofrecipe;
	private BigDecimal ordered;
	private Set<RecipeDrugs> recipeDrugses = new HashSet<RecipeDrugs>(0);
	private Set<Auditing> auditings = new HashSet<Auditing>(0);

	// Constructors

	/** default constructor */
	public Recipe() {
	}

	/** minimal constructor */
	public Recipe(BigDecimal recipeid, Hospital hospital, Patients patients, Department department, Date dateofrecipe) {
		this.recipeid = recipeid;
		this.hospital = hospital;
		this.patients = patients;
		this.department = department;
		this.dateofrecipe = dateofrecipe;
	}

	/** full constructor */
	public Recipe(BigDecimal recipeid, Admission admission, Hospital hospital, Patients patients, Department department, Orders orders, Date dateofrecipe,
			BigDecimal ordered, Set<RecipeDrugs> recipeDrugses, Set<Auditing> auditings) {
		this.recipeid = recipeid;
		this.admission = admission;
		this.hospital = hospital;
		this.patients = patients;
		this.department = department;
		this.orders = orders;
		this.dateofrecipe = dateofrecipe;
		this.ordered = ordered;
		this.recipeDrugses = recipeDrugses;
		this.auditings = auditings;
	}

	// Property accessors
	@Id
	@Column(name = "RECIPEID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getRecipeid() {
		return this.recipeid;
	}

	public void setRecipeid(BigDecimal recipeid) {
		this.recipeid = recipeid;
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
	@JoinColumn(name = "HOSPITALID", nullable = false)
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
	@JoinColumn(name = "ORDERID")
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATEOFRECIPE", nullable = false, length = 7)
	public Date getDateofrecipe() {
		return this.dateofrecipe;
	}

	public void setDateofrecipe(Date dateofrecipe) {
		this.dateofrecipe = dateofrecipe;
	}

	@Column(name = "ORDERED", precision = 22, scale = 0)
	public BigDecimal getOrdered() {
		return this.ordered;
	}

	public void setOrdered(BigDecimal ordered) {
		this.ordered = ordered;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
	public Set<RecipeDrugs> getRecipeDrugses() {
		return this.recipeDrugses;
	}

	public void setRecipeDrugses(Set<RecipeDrugs> recipeDrugses) {
		this.recipeDrugses = recipeDrugses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
	public Set<Auditing> getAuditings() {
		return this.auditings;
	}

	public void setAuditings(Set<Auditing> auditings) {
		this.auditings = auditings;
	}

}