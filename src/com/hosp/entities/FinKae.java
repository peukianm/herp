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
 * FinKae entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FIN_KAE", schema = "HOSPITAL")
public class FinKae implements java.io.Serializable {

	// Fields

	private BigDecimal kaeid;
	private String name;
	private String description;
	private Set<FinEntal> finEntals = new HashSet<FinEntal>(0);
	private Set<FinDesm> finDesms = new HashSet<FinDesm>(0);
	private Set<FinTimol> finTimols = new HashSet<FinTimol>(0);
	private Set<FinBudget> finBudgets = new HashSet<FinBudget>(0);

	// Constructors

	/** default constructor */
	public FinKae() {
	}

	/** minimal constructor */
	public FinKae(BigDecimal kaeid) {
		this.kaeid = kaeid;
	}

	/** full constructor */
	public FinKae(BigDecimal kaeid, String name, String description, Set<FinEntal> finEntals, Set<FinDesm> finDesms, Set<FinTimol> finTimols,
			Set<FinBudget> finBudgets) {
		this.kaeid = kaeid;
		this.name = name;
		this.description = description;
		this.finEntals = finEntals;
		this.finDesms = finDesms;
		this.finTimols = finTimols;
		this.finBudgets = finBudgets;
	}

	// Property accessors
	@Id
	@Column(name = "KAEID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getKaeid() {
		return this.kaeid;
	}

	public void setKaeid(BigDecimal kaeid) {
		this.kaeid = kaeid;
	}

	@Column(name = "NAME", length = 200)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finKae")
	public Set<FinEntal> getFinEntals() {
		return this.finEntals;
	}

	public void setFinEntals(Set<FinEntal> finEntals) {
		this.finEntals = finEntals;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finKae")
	public Set<FinDesm> getFinDesms() {
		return this.finDesms;
	}

	public void setFinDesms(Set<FinDesm> finDesms) {
		this.finDesms = finDesms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finKae")
	public Set<FinTimol> getFinTimols() {
		return this.finTimols;
	}

	public void setFinTimols(Set<FinTimol> finTimols) {
		this.finTimols = finTimols;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finKae")
	public Set<FinBudget> getFinBudgets() {
		return this.finBudgets;
	}

	public void setFinBudgets(Set<FinBudget> finBudgets) {
		this.finBudgets = finBudgets;
	}

}