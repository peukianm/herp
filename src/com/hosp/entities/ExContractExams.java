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
 * ExContractExams entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_CONTRACT_EXAMS", schema = "HOSPITAL")
public class ExContractExams implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private ExContract exContract;
	private ExExam exExam;
	private String code;
	private BigDecimal enabled;
	private Double price;
	private BigDecimal favorite;
	private BigDecimal participation;

	// Constructors

	/** default constructor */
	public ExContractExams() {
	}

	/** minimal constructor */
	public ExContractExams(BigDecimal id, ExContract exContract, ExExam exExam, String code) {
		this.id = id;
		this.exContract = exContract;
		this.exExam = exExam;
		this.code = code;
	}

	/** full constructor */
	public ExContractExams(BigDecimal id, ExContract exContract, ExExam exExam, String code, BigDecimal enabled, Double price, BigDecimal favorite,
			BigDecimal participation) {
		this.id = id;
		this.exContract = exContract;
		this.exExam = exExam;
		this.code = code;
		this.enabled = enabled;
		this.price = price;
		this.favorite = favorite;
		this.participation = participation;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTRACTID", nullable = false)
	public ExContract getExContract() {
		return this.exContract;
	}

	public void setExContract(ExContract exContract) {
		this.exContract = exContract;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXAMID", nullable = false)
	public ExExam getExExam() {
		return this.exExam;
	}

	public void setExExam(ExExam exExam) {
		this.exExam = exExam;
	}

	@Column(name = "CODE", nullable = false, length = 50)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "ENABLED", precision = 22, scale = 0)
	public BigDecimal getEnabled() {
		return this.enabled;
	}

	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}

	@Column(name = "PRICE", precision = 10, scale = 2)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "FAVORITE", precision = 22, scale = 0)
	public BigDecimal getFavorite() {
		return this.favorite;
	}

	public void setFavorite(BigDecimal favorite) {
		this.favorite = favorite;
	}

	@Column(name = "PARTICIPATION", precision = 22, scale = 0)
	public BigDecimal getParticipation() {
		return this.participation;
	}

	public void setParticipation(BigDecimal participation) {
		this.participation = participation;
	}

}