package com.hosp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * KenMedicalActs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "KEN_MEDICAL_ACTS", schema = "HOSPITAL")
public class KenMedicalActs implements java.io.Serializable {

	// Fields

	private Long id;
	private String code;
	private String description;
	private Long categoryId;

	// Constructors

	/** default constructor */
	public KenMedicalActs() {
	}

	/** minimal constructor */
	public KenMedicalActs(Long id) {
		this.id = id;
	}

	/** full constructor */
	public KenMedicalActs(Long id, String code, String description, Long categoryId) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.categoryId = categoryId;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CODE", length = 64)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "DESCRIPTION", length = 4000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CATEGORY_ID", precision = 10, scale = 0)
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}