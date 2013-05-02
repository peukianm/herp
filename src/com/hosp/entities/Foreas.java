package com.hosp.entities;

import java.math.BigDecimal;
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

/**
 * Foreas entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "FOREAS", schema = "HOSPITAL")
public class Foreas implements java.io.Serializable {

	// Fields

	private BigDecimal foreasid;
	private Hospital hospital;
	private String name;
	private String data;
	private Set<FinBudget> finBudgets = new HashSet<FinBudget>(0);
	private Set<FinEntal> finEntals = new HashSet<FinEntal>(0);
	private Set<FinDesm> finDesms = new HashSet<FinDesm>(0);
	private Set<FinTimol> finTimols = new HashSet<FinTimol>(0);

	// Constructors

	/** default constructor */
	public Foreas() {
	}

	/** minimal constructor */
	public Foreas(BigDecimal foreasid, Hospital hospital) {
		this.foreasid = foreasid;
		this.hospital = hospital;
	}

	/** full constructor */
	public Foreas(BigDecimal foreasid, Hospital hospital, String name, String data, Set<FinBudget> finBudgets, Set<FinEntal> finEntals, Set<FinDesm> finDesms,
			Set<FinTimol> finTimols) {
		this.foreasid = foreasid;
		this.hospital = hospital;
		this.name = name;
		this.data = data;
		this.finBudgets = finBudgets;
		this.finEntals = finEntals;
		this.finDesms = finDesms;
		this.finTimols = finTimols;
	}

	// Property accessors
	@Id
	@Column(name = "FOREASID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getForeasid() {
		return this.foreasid;
	}

	public void setForeasid(BigDecimal foreasid) {
		this.foreasid = foreasid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITALID", nullable = false)
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DATA", length = 50)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "foreas")
	public Set<FinBudget> getFinBudgets() {
		return this.finBudgets;
	}

	public void setFinBudgets(Set<FinBudget> finBudgets) {
		this.finBudgets = finBudgets;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "foreas")
	public Set<FinEntal> getFinEntals() {
		return this.finEntals;
	}

	public void setFinEntals(Set<FinEntal> finEntals) {
		this.finEntals = finEntals;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "foreas")
	public Set<FinDesm> getFinDesms() {
		return this.finDesms;
	}

	public void setFinDesms(Set<FinDesm> finDesms) {
		this.finDesms = finDesms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "foreas")
	public Set<FinTimol> getFinTimols() {
		return this.finTimols;
	}

	public void setFinTimols(Set<FinTimol> finTimols) {
		this.finTimols = finTimols;
	}

}