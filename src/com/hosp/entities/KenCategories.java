package com.hosp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * KenCategories entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "KEN_CATEGORIES", schema = "HOSPITAL")
public class KenCategories implements java.io.Serializable {

	// Fields

	private String code;
	private String description;

	// Constructors

	/** default constructor */
	public KenCategories() {
	}

	/** full constructor */
	public KenCategories(String code, String description) {
		this.code = code;
		this.description = description;
	}

	// Property accessors
	@Id
	@Column(name = "CODE", unique = true, nullable = false, length = 64)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "DESCRIPTION", nullable = false, length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}