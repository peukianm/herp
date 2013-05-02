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
 * FinProtocol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FIN_PROTOCOL", schema = "HOSPITAL")
public class FinProtocol implements java.io.Serializable {

	// Fields

	private BigDecimal protocolid;
	private Hospital hospital;
	private BigDecimal value;
	private String application;
	private BigDecimal etos;

	// Constructors

	/** default constructor */
	public FinProtocol() {
	}

	/** minimal constructor */
	public FinProtocol(BigDecimal protocolid) {
		this.protocolid = protocolid;
	}

	/** full constructor */
	public FinProtocol(BigDecimal protocolid, Hospital hospital, BigDecimal value, String application, BigDecimal etos) {
		this.protocolid = protocolid;
		this.hospital = hospital;
		this.value = value;
		this.application = application;
		this.etos = etos;
	}

	// Property accessors
	@Id
	@Column(name = "PROTOCOLID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getProtocolid() {
		return this.protocolid;
	}

	public void setProtocolid(BigDecimal protocolid) {
		this.protocolid = protocolid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITALID")
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Column(name = "VALUE", precision = 22, scale = 0)
	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Column(name = "APPLICATION", length = 50)
	public String getApplication() {
		return this.application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	@Column(name = "ETOS", precision = 22, scale = 0)
	public BigDecimal getEtos() {
		return this.etos;
	}

	public void setEtos(BigDecimal etos) {
		this.etos = etos;
	}

}