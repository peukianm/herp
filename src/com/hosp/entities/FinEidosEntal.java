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
 * FinEidosEntal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FIN_EIDOS_ENTAL", schema = "HOSPITAL")
public class FinEidosEntal implements java.io.Serializable {

	// Fields

	private BigDecimal eidosentalid;
	private String name;
	private Set<FinEntal> finEntals = new HashSet<FinEntal>(0);

	// Constructors

	/** default constructor */
	public FinEidosEntal() {
	}

	/** minimal constructor */
	public FinEidosEntal(BigDecimal eidosentalid, String name) {
		this.eidosentalid = eidosentalid;
		this.name = name;
	}

	/** full constructor */
	public FinEidosEntal(BigDecimal eidosentalid, String name, Set<FinEntal> finEntals) {
		this.eidosentalid = eidosentalid;
		this.name = name;
		this.finEntals = finEntals;
	}

	// Property accessors
	@Id
	@Column(name = "EIDOSENTALID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getEidosentalid() {
		return this.eidosentalid;
	}

	public void setEidosentalid(BigDecimal eidosentalid) {
		this.eidosentalid = eidosentalid;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finEidosEntal")
	public Set<FinEntal> getFinEntals() {
		return this.finEntals;
	}

	public void setFinEntals(Set<FinEntal> finEntals) {
		this.finEntals = finEntals;
	}

}