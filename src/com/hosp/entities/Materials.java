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
 * Materials entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "MATERIALS", schema = "HOSPITAL")
public class Materials implements java.io.Serializable {

	// Fields

	private BigDecimal materialid;
	private Materialcategory materialcategory;
	private String name;
	private Set<MaterialAdmission> materialAdmissions = new HashSet<MaterialAdmission>(0);
	private Set<Auditing> auditings = new HashSet<Auditing>(0);

	// Constructors

	/** default constructor */
	public Materials() {
	}

	/** minimal constructor */
	public Materials(BigDecimal materialid, String name) {
		this.materialid = materialid;
		this.name = name;
	}

	/** full constructor */
	public Materials(BigDecimal materialid, Materialcategory materialcategory, String name, Set<MaterialAdmission> materialAdmissions, Set<Auditing> auditings) {
		this.materialid = materialid;
		this.materialcategory = materialcategory;
		this.name = name;
		this.materialAdmissions = materialAdmissions;
		this.auditings = auditings;
	}

	// Property accessors
	@Id
	@Column(name = "MATERIALID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getMaterialid() {
		return this.materialid;
	}

	public void setMaterialid(BigDecimal materialid) {
		this.materialid = materialid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORYID")
	public Materialcategory getMaterialcategory() {
		return this.materialcategory;
	}

	public void setMaterialcategory(Materialcategory materialcategory) {
		this.materialcategory = materialcategory;
	}

	@Column(name = "NAME", nullable = false, length = 4000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materials")
	public Set<MaterialAdmission> getMaterialAdmissions() {
		return this.materialAdmissions;
	}

	public void setMaterialAdmissions(Set<MaterialAdmission> materialAdmissions) {
		this.materialAdmissions = materialAdmissions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materials")
	public Set<Auditing> getAuditings() {
		return this.auditings;
	}

	public void setAuditings(Set<Auditing> auditings) {
		this.auditings = auditings;
	}

}