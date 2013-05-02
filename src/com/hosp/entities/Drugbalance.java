package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Drugbalance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "DRUGBALANCE", schema = "HOSPITAL")
public class Drugbalance implements java.io.Serializable {

	// Fields

	private BigDecimal drugbalanceid;
	private Hospital hospital;
	private Department department;
	private Drugs drugs;
	private BigDecimal balance;

	// Constructors

	/** default constructor */
	public Drugbalance() {
	}

	/** minimal constructor */
	public Drugbalance(BigDecimal drugbalanceid) {
		this.drugbalanceid = drugbalanceid;
	}

	/** full constructor */
	public Drugbalance(BigDecimal drugbalanceid, Hospital hospital, Department department, Drugs drugs, BigDecimal balance) {
		this.drugbalanceid = drugbalanceid;
		this.hospital = hospital;
		this.department = department;
		this.drugs = drugs;
		this.balance = balance;
	}

	// Property accessors
	@Id
	@Column(name = "DRUGBALANCEID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDrugbalanceid() {
		return this.drugbalanceid;
	}

	public void setDrugbalanceid(BigDecimal drugbalanceid) {
		this.drugbalanceid = drugbalanceid;
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

	@Column(name = "BALANCE", precision = 22, scale = 0)
	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}