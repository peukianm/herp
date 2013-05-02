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
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "ORDERS", schema = "HOSPITAL")
public class Orders implements java.io.Serializable {

	// Fields

	private BigDecimal orderid;
	private Hospital hospital;
	private Department department;
	private Date orderdate;
	private BigDecimal extra;
	private BigDecimal canceled;
	private Set<Recipe> recipes = new HashSet<Recipe>(0);
	private Set<OrderDrugs> orderDrugses = new HashSet<OrderDrugs>(0);
	private Set<Auditing> auditings = new HashSet<Auditing>(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(BigDecimal orderid, Hospital hospital, Department department, Date orderdate) {
		this.orderid = orderid;
		this.hospital = hospital;
		this.department = department;
		this.orderdate = orderdate;
	}

	/** full constructor */
	public Orders(BigDecimal orderid, Hospital hospital, Department department, Date orderdate, BigDecimal extra, BigDecimal canceled, Set<Recipe> recipes,
			Set<OrderDrugs> orderDrugses, Set<Auditing> auditings) {
		this.orderid = orderid;
		this.hospital = hospital;
		this.department = department;
		this.orderdate = orderdate;
		this.extra = extra;
		this.canceled = canceled;
		this.recipes = recipes;
		this.orderDrugses = orderDrugses;
		this.auditings = auditings;
	}

	// Property accessors
	@Id
	@Column(name = "ORDERID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getOrderid() {
		return this.orderid;
	}

	public void setOrderid(BigDecimal orderid) {
		this.orderid = orderid;
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
	@JoinColumn(name = "DEPARTMENTID", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ORDERDATE", nullable = false, length = 7)
	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@Column(name = "EXTRA", precision = 22, scale = 0)
	public BigDecimal getExtra() {
		return this.extra;
	}

	public void setExtra(BigDecimal extra) {
		this.extra = extra;
	}

	@Column(name = "CANCELED", precision = 22, scale = 0)
	public BigDecimal getCanceled() {
		return this.canceled;
	}

	public void setCanceled(BigDecimal canceled) {
		this.canceled = canceled;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<OrderDrugs> getOrderDrugses() {
		return this.orderDrugses;
	}

	public void setOrderDrugses(Set<OrderDrugs> orderDrugses) {
		this.orderDrugses = orderDrugses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<Auditing> getAuditings() {
		return this.auditings;
	}

	public void setAuditings(Set<Auditing> auditings) {
		this.auditings = auditings;
	}

}