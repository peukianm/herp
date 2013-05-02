package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * FinYear entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FIN_YEAR", schema = "HOSPITAL")
public class FinYear implements java.io.Serializable {

	// Fields

	private BigDecimal yearid;
	private String name;
	private Set<FinBudget> finBudgets = new HashSet<FinBudget>(0);
	private Set<FinEntal> finEntals = new HashSet<FinEntal>(0);
	private Set<FinTimol> finTimols = new HashSet<FinTimol>(0);
	private Set<FinDesm> finDesms = new HashSet<FinDesm>(0);

	// Constructors

	/** default constructor */
	public FinYear() {
	}

	/** minimal constructor */
	public FinYear(BigDecimal yearid, String name) {
		this.yearid = yearid;
		this.name = name;
	}

	/** full constructor */
	public FinYear(BigDecimal yearid, String name, Set<FinBudget> finBudgets, Set<FinEntal> finEntals, Set<FinTimol> finTimols, Set<FinDesm> finDesms) {
		this.yearid = yearid;
		this.name = name;
		this.finBudgets = finBudgets;
		this.finEntals = finEntals;
		this.finTimols = finTimols;
		this.finDesms = finDesms;
	}

	// Property accessors
	@Id
	@Column(name = "YEARID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getYearid() {
		return this.yearid;
	}

	public void setYearid(BigDecimal yearid) {
		this.yearid = yearid;
	}

	@Column(name = "NAME", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finYear")
	public Set<FinBudget> getFinBudgets() {
		return this.finBudgets;
	}

	public void setFinBudgets(Set<FinBudget> finBudgets) {
		this.finBudgets = finBudgets;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finYear")
	public Set<FinEntal> getFinEntals() {
		return this.finEntals;
	}

	public void setFinEntals(Set<FinEntal> finEntals) {
		this.finEntals = finEntals;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finYear")
	public Set<FinTimol> getFinTimols() {
		return this.finTimols;
	}

	public void setFinTimols(Set<FinTimol> finTimols) {
		this.finTimols = finTimols;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finYear")
	public Set<FinDesm> getFinDesms() {
		return this.finDesms;
	}

	public void setFinDesms(Set<FinDesm> finDesms) {
		this.finDesms = finDesms;
	}

}