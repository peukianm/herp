package com.hosp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ken entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "KEN", schema = "HOSPITAL")
public class Ken implements java.io.Serializable {

	// Fields

	private Long id;
	private String code;
	private String description;
	private String categoryCode;
	private Double price;
	private Long days;
	private Long serviceId;

	// Constructors

	/** default constructor */
	public Ken() {
	}

	/** minimal constructor */
	public Ken(Long id, String code, String description) {
		this.id = id;
		this.code = code;
		this.description = description;
	}

	/** full constructor */
	public Ken(Long id, String code, String description, String categoryCode, Double price, Long days, Long serviceId) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.categoryCode = categoryCode;
		this.price = price;
		this.days = days;
		this.serviceId = serviceId;
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

	@Column(name = "CODE", nullable = false, length = 64)
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

	@Column(name = "CATEGORY_CODE", length = 64)
	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	@Column(name = "PRICE", precision = 12)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "DAYS", precision = 10, scale = 0)
	public Long getDays() {
		return this.days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	@Column(name = "SERVICE_ID", precision = 10, scale = 0)
	public Long getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

}