package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FinDesm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FIN_DESM", schema = "HOSPITAL")
public class FinDesm implements java.io.Serializable {

	// Fields

	private BigDecimal desmid;
	private Hospital hospital;
	private FinKae finKae;
	private Foreas foreas;
	private FinYear finYear;
	private FinDesm finDesm;
	private String apof;
	private Date dateofdesm;
	private BigDecimal amount;
	private String arapof;
	private String arsymb;
	private BigDecimal cover;
	private BigDecimal counter;
	private String cause;
	private BigDecimal protocol;
	private BigDecimal rest;
	private Boolean recall;
	private BigDecimal recallamount;
	private Set<FinTimol> finTimols = new HashSet<FinTimol>(0);
	private Set<FinDesm> finDesms = new HashSet<FinDesm>(0);

	// Constructors

	/** default constructor */
	public FinDesm() {
	}

	/** minimal constructor */
	public FinDesm(BigDecimal desmid) {
		this.desmid = desmid;
	}

	/** full constructor */
	public FinDesm(BigDecimal desmid, Hospital hospital, FinKae finKae, Foreas foreas, FinYear finYear, FinDesm finDesm, String apof, Date dateofdesm,
			BigDecimal amount, String arapof, String arsymb, BigDecimal cover, BigDecimal counter, String cause, BigDecimal protocol, BigDecimal rest,
			Boolean recall, BigDecimal recallamount, Set<FinTimol> finTimols, Set<FinDesm> finDesms) {
		this.desmid = desmid;
		this.hospital = hospital;
		this.finKae = finKae;
		this.foreas = foreas;
		this.finYear = finYear;
		this.finDesm = finDesm;
		this.apof = apof;
		this.dateofdesm = dateofdesm;
		this.amount = amount;
		this.arapof = arapof;
		this.arsymb = arsymb;
		this.cover = cover;
		this.counter = counter;
		this.cause = cause;
		this.protocol = protocol;
		this.rest = rest;
		this.recall = recall;
		this.recallamount = recallamount;
		this.finTimols = finTimols;
		this.finDesms = finDesms;
	}

	// Property accessors
	@Id
	@Column(name = "DESMID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDesmid() {
		return this.desmid;
	}

	public void setDesmid(BigDecimal desmid) {
		this.desmid = desmid;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECALLDESMID")
	public FinDesm getFinDesm() {
		return this.finDesm;
	}

	public void setFinDesm(FinDesm finDesm) {
		this.finDesm = finDesm;
	}

	@Column(name = "APOF", length = 100)
	public String getApof() {
		return this.apof;
	}

	public void setApof(String apof) {
		this.apof = apof;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATEOFDESM", length = 7)
	public Date getDateofdesm() {
		return this.dateofdesm;
	}

	public void setDateofdesm(Date dateofdesm) {
		this.dateofdesm = dateofdesm;
	}

	@Column(name = "AMOUNT", precision = 22, scale = 0)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "ARAPOF", length = 100)
	public String getArapof() {
		return this.arapof;
	}

	public void setArapof(String arapof) {
		this.arapof = arapof;
	}

	@Column(name = "ARSYMB", length = 100)
	public String getArsymb() {
		return this.arsymb;
	}

	public void setArsymb(String arsymb) {
		this.arsymb = arsymb;
	}

	@Column(name = "COVER", precision = 22, scale = 0)
	public BigDecimal getCover() {
		return this.cover;
	}

	public void setCover(BigDecimal cover) {
		this.cover = cover;
	}

	@Column(name = "COUNTER", precision = 22, scale = 0)
	public BigDecimal getCounter() {
		return this.counter;
	}

	public void setCounter(BigDecimal counter) {
		this.counter = counter;
	}

	@Column(name = "CAUSE", length = 500)
	public String getCause() {
		return this.cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Column(name = "PROTOCOL", precision = 22, scale = 0)
	public BigDecimal getProtocol() {
		return this.protocol;
	}

	public void setProtocol(BigDecimal protocol) {
		this.protocol = protocol;
	}

	@Column(name = "REST", precision = 22, scale = 0)
	public BigDecimal getRest() {
		return this.rest;
	}

	public void setRest(BigDecimal rest) {
		this.rest = rest;
	}

	@Column(name = "RECALL", precision = 1, scale = 0)
	public Boolean getRecall() {
		return this.recall;
	}

	public void setRecall(Boolean recall) {
		this.recall = recall;
	}

	@Column(name = "RECALLAMOUNT", precision = 22, scale = 0)
	public BigDecimal getRecallamount() {
		return this.recallamount;
	}

	public void setRecallamount(BigDecimal recallamount) {
		this.recallamount = recallamount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finDesm")
	public Set<FinTimol> getFinTimols() {
		return this.finTimols;
	}

	public void setFinTimols(Set<FinTimol> finTimols) {
		this.finTimols = finTimols;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finDesm")
	public Set<FinDesm> getFinDesms() {
		return this.finDesms;
	}

	public void setFinDesms(Set<FinDesm> finDesms) {
		this.finDesms = finDesms;
	}

}