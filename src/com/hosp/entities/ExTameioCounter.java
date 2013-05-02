package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ExTameioCounter entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_TAMEIO_COUNTER", schema = "HOSPITAL")
public class ExTameioCounter implements java.io.Serializable {

	// Fields

	private BigDecimal counterid;
	private Hospital hospital;
	private ExTameio exTameio;
	private ExPeriod exPeriod;
	private BigDecimal counter;

	// Constructors

	/** default constructor */
	public ExTameioCounter() {
	}

	/** minimal constructor */
	public ExTameioCounter(BigDecimal counterid, Hospital hospital, ExTameio exTameio, BigDecimal counter) {
		this.counterid = counterid;
		this.hospital = hospital;
		this.exTameio = exTameio;
		this.counter = counter;
	}

	/** full constructor */
	public ExTameioCounter(BigDecimal counterid, Hospital hospital, ExTameio exTameio, ExPeriod exPeriod, BigDecimal counter) {
		this.counterid = counterid;
		this.hospital = hospital;
		this.exTameio = exTameio;
		this.exPeriod = exPeriod;
		this.counter = counter;
	}

	// Property accessors
	@Id
	@Column(name = "COUNTERID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCounterid() {
		return this.counterid;
	}

	public void setCounterid(BigDecimal counterid) {
		this.counterid = counterid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITALID", nullable = false)
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAMEIOID", nullable = false)
	public ExTameio getExTameio() {
		return this.exTameio;
	}

	public void setExTameio(ExTameio exTameio) {
		this.exTameio = exTameio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERIODID")
	public ExPeriod getExPeriod() {
		return this.exPeriod;
	}

	public void setExPeriod(ExPeriod exPeriod) {
		this.exPeriod = exPeriod;
	}

	@Column(name = "COUNTER", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCounter() {
		return this.counter;
	}

	public void setCounter(BigDecimal counter) {
		this.counter = counter;
	}

}