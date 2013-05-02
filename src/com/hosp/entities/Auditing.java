package com.hosp.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
 * Auditing entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AUDITING", schema = "HOSPITAL")
public class Auditing implements java.io.Serializable {

	// Fields

	private BigDecimal auditid;
	private Hospital hospital;
	private Actionscategory actionscategory;
	private Action action;
	private Patients patients;
	private Department department;
	private Drugs drugs;
	private Recipe recipe;
	private Users users;
	private Materials materials;
	private Orders orders;
	private Timestamp actiondate;
	private Timestamp actiontime;
	private BigDecimal examid;
	private String comments;

	// Constructors

	/** default constructor */
	public Auditing() {
	}

	/** minimal constructor */
	public Auditing(BigDecimal auditid, Users users, Timestamp actiondate) {
		this.auditid = auditid;
		this.users = users;
		this.actiondate = actiondate;
	}

	/** full constructor */
	public Auditing(BigDecimal auditid, Hospital hospital, Actionscategory actionscategory, Action action, Patients patients, Department department,
			Drugs drugs, Recipe recipe, Users users, Materials materials, Orders orders, Timestamp actiondate, Timestamp actiontime, BigDecimal examid,
			String comments) {
		this.auditid = auditid;
		this.hospital = hospital;
		this.actionscategory = actionscategory;
		this.action = action;
		this.patients = patients;
		this.department = department;
		this.drugs = drugs;
		this.recipe = recipe;
		this.users = users;
		this.materials = materials;
		this.orders = orders;
		this.actiondate = actiondate;
		this.actiontime = actiontime;
		this.examid = examid;
		this.comments = comments;
	}

	// Property accessors
	@Id
	@Column(name = "AUDITID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getAuditid() {
		return this.auditid;
	}

	public void setAuditid(BigDecimal auditid) {
		this.auditid = auditid;
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
	@JoinColumn(name = "CATEGORYID")
	public Actionscategory getActionscategory() {
		return this.actionscategory;
	}

	public void setActionscategory(Actionscategory actionscategory) {
		this.actionscategory = actionscategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTIONID")
	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
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
	@JoinColumn(name = "DRUGID")
	public Drugs getDrugs() {
		return this.drugs;
	}

	public void setDrugs(Drugs drugs) {
		this.drugs = drugs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECIPEID")
	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATERIALID")
	public Materials getMaterials() {
		return this.materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERID")
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	//@Temporal(TemporalType.DATE)
	@Column(name = "ACTIONDATE", nullable = false, length = 7)
	public Timestamp getActiondate() {
		return this.actiondate;
	}

	public void setActiondate(Timestamp actiondate) {
		this.actiondate = actiondate;
	}

	@Column(name = "ACTIONTIME", length = 11)
	public Timestamp getActiontime() {
		return this.actiontime;
	}

	public void setActiontime(Timestamp actiontime) {
		this.actiontime = actiontime;
	}

	@Column(name = "EXAMID", precision = 22, scale = 0)
	public BigDecimal getExamid() {
		return this.examid;
	}

	public void setExamid(BigDecimal examid) {
		this.examid = examid;
	}

	@Column(name = "COMMENTS", length = 200)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}