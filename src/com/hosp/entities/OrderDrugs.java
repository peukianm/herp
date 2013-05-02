package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderDrugs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "ORDER_DRUGS", schema = "HOSPITAL")
public class OrderDrugs implements java.io.Serializable {

	// Fields

	private BigDecimal orderdrugsid;
	private Drugs drugs;
	private Orders orders;
	private BigDecimal quantity;

	// Constructors

	/** default constructor */
	public OrderDrugs() {
	}

	/** full constructor */
	public OrderDrugs(BigDecimal orderdrugsid, Drugs drugs, Orders orders, BigDecimal quantity) {
		this.orderdrugsid = orderdrugsid;
		this.drugs = drugs;
		this.orders = orders;
		this.quantity = quantity;
	}

	// Property accessors
	@Id
	@Column(name = "ORDERDRUGSID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getOrderdrugsid() {
		return this.orderdrugsid;
	}

	public void setOrderdrugsid(BigDecimal orderdrugsid) {
		this.orderdrugsid = orderdrugsid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DRUGID", nullable = false)
	public Drugs getDrugs() {
		return this.drugs;
	}

	public void setDrugs(Drugs drugs) {
		this.drugs = drugs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERID", nullable = false)
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Column(name = "QUANTITY", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}