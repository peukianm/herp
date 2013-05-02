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
 * FinBudget entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FIN_BUDGET", schema = "HOSPITAL")
public class FinBudget implements java.io.Serializable {

	// Fields

	private BigDecimal budgetid;
	private Hospital hospital;
	private FinKae finKae;
	private Foreas foreas;
	private FinYear finYear;
	private BigDecimal amount;

	// Constructors

	/** default constructor */
	public FinBudget() {
	}

	/** minimal constructor */
	public FinBudget(BigDecimal budgetid) {
		this.budgetid = budgetid;
	}

	/** full constructor */
	public FinBudget(BigDecimal budgetid, Hospital hospital, FinKae finKae, Foreas foreas, FinYear finYear, BigDecimal amount) {
		this.budgetid = budgetid;
		this.hospital = hospital;
		this.finKae = finKae;
		this.foreas = foreas;
		this.finYear = finYear;
		this.amount = amount;
	}

	// Property accessors
	@Id
	@Column(name = "BUDGETID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getBudgetid() {
		return this.budgetid;
	}

	public void setBudgetid(BigDecimal budgetid) {
		this.budgetid = budgetid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITALID")
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KAEID")
	public FinKae getFinKae() {
		return this.finKae;
	}

	public void setFinKae(FinKae finKae) {
		this.finKae = finKae;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOREASID")
	public Foreas getForeas() {
		return this.foreas;
	}

	public void setForeas(Foreas foreas) {
		this.foreas = foreas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "YEARID")
	public FinYear getFinYear() {
		return this.finYear;
	}

	public void setFinYear(FinYear finYear) {
		this.finYear = finYear;
	}

	@Column(name = "AMOUNT", precision = 22, scale = 0)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}