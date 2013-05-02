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
 * Dype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DYPE", schema = "HOSPITAL")
public class Dype implements java.io.Serializable {

	// Fields

	private BigDecimal dypeid;
	private String name;
	private String description;
	private String address;
	private String phone1;
	private String phone2;
	private Set<Hospital> hospitals = new HashSet<Hospital>(0);

	// Constructors

	/** default constructor */
	public Dype() {
	}

	/** minimal constructor */
	public Dype(BigDecimal dypeid, String name) {
		this.dypeid = dypeid;
		this.name = name;
	}

	/** full constructor */
	public Dype(BigDecimal dypeid, String name, String description, String address, String phone1, String phone2, Set<Hospital> hospitals) {
		this.dypeid = dypeid;
		this.name = name;
		this.description = description;
		this.address = address;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.hospitals = hospitals;
	}

	// Property accessors
	@Id
	@Column(name = "DYPEID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDypeid() {
		return this.dypeid;
	}

	public void setDypeid(BigDecimal dypeid) {
		this.dypeid = dypeid;
	}

	@Column(name = "NAME", nullable = false, length = 4000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 4000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ADDRESS", length = 4000)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "PHONE1", length = 4000)
	public String getPhone1() {
		return this.phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	@Column(name = "PHONE2", length = 4000)
	public String getPhone2() {
		return this.phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dype")
	public Set<Hospital> getHospitals() {
		return this.hospitals;
	}

	public void setHospitals(Set<Hospital> hospitals) {
		this.hospitals = hospitals;
	}

}