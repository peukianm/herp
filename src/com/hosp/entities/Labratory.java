package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Labratory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "LABRATORY", schema = "HOSPITAL")
public class Labratory implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String name;

	// Constructors

	/** default constructor */
	public Labratory() {
	}

	/** minimal constructor */
	public Labratory(BigDecimal id) {
		this.id = id;
	}

	/** full constructor */
	public Labratory(BigDecimal id, String name) {
		this.id = id;
		this.name = name;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}