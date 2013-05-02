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
 * ExContractType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_CONTRACT_TYPE", schema = "HOSPITAL")
public class ExContractType implements java.io.Serializable {

	// Fields

	private BigDecimal contracttypeid;
	private String name;
	private BigDecimal enabled;
	private Set<ExContract> exContracts = new HashSet<ExContract>(0);

	// Constructors

	/** default constructor */
	public ExContractType() {
	}

	/** minimal constructor */
	public ExContractType(BigDecimal contracttypeid, String name) {
		this.contracttypeid = contracttypeid;
		this.name = name;
	}

	/** full constructor */
	public ExContractType(BigDecimal contracttypeid, String name, BigDecimal enabled, Set<ExContract> exContracts) {
		this.contracttypeid = contracttypeid;
		this.name = name;
		this.enabled = enabled;
		this.exContracts = exContracts;
	}

	// Property accessors
	@Id
	@Column(name = "CONTRACTTYPEID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getContracttypeid() {
		return this.contracttypeid;
	}

	public void setContracttypeid(BigDecimal contracttypeid) {
		this.contracttypeid = contracttypeid;
	}

	@Column(name = "NAME", nullable = false, length = 80)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ENABLED", precision = 22, scale = 0)
	public BigDecimal getEnabled() {
		return this.enabled;
	}

	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exContractType")
	public Set<ExContract> getExContracts() {
		return this.exContracts;
	}

	public void setExContracts(Set<ExContract> exContracts) {
		this.exContracts = exContracts;
	}

}