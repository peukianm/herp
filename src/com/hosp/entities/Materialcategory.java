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
 * Materialcategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MATERIALCATEGORY", schema = "HOSPITAL")
public class Materialcategory implements java.io.Serializable {

	// Fields

	private BigDecimal categoryid;
	private String name;
	private Set<Materials> materialses = new HashSet<Materials>(0);

	// Constructors

	/** default constructor */
	public Materialcategory() {
	}

	/** minimal constructor */
	public Materialcategory(BigDecimal categoryid) {
		this.categoryid = categoryid;
	}

	/** full constructor */
	public Materialcategory(BigDecimal categoryid, String name, Set<Materials> materialses) {
		this.categoryid = categoryid;
		this.name = name;
		this.materialses = materialses;
	}

	// Property accessors
	@Id
	@Column(name = "CATEGORYID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(BigDecimal categoryid) {
		this.categoryid = categoryid;
	}

	@Column(name = "NAME", length = 4000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materialcategory")
	public Set<Materials> getMaterialses() {
		return this.materialses;
	}

	public void setMaterialses(Set<Materials> materialses) {
		this.materialses = materialses;
	}

}