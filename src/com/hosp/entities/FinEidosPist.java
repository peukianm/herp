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
 * FinEidosPist entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FIN_EIDOS_PIST", schema = "HOSPITAL")
public class FinEidosPist implements java.io.Serializable {

	// Fields

	private BigDecimal eidospistid;
	private String name;
	private Set<FinTimol> finTimols = new HashSet<FinTimol>(0);

	// Constructors

	/** default constructor */
	public FinEidosPist() {
	}

	/** minimal constructor */
	public FinEidosPist(BigDecimal eidospistid, String name) {
		this.eidospistid = eidospistid;
		this.name = name;
	}

	/** full constructor */
	public FinEidosPist(BigDecimal eidospistid, String name, Set<FinTimol> finTimols) {
		this.eidospistid = eidospistid;
		this.name = name;
		this.finTimols = finTimols;
	}

	// Property accessors
	@Id
	@Column(name = "EIDOSPISTID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getEidospistid() {
		return this.eidospistid;
	}

	public void setEidospistid(BigDecimal eidospistid) {
		this.eidospistid = eidospistid;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finEidosPist")
	public Set<FinTimol> getFinTimols() {
		return this.finTimols;
	}

	public void setFinTimols(Set<FinTimol> finTimols) {
		this.finTimols = finTimols;
	}

}