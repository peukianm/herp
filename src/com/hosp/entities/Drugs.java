package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Drugs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "DRUGS", schema = "HOSPITAL")
public class Drugs implements java.io.Serializable {

	// Fields

	private BigDecimal drugid;
	private Packaging packaging;
	private String name;
	private String description;
	private BigDecimal quantity;
	private BigDecimal drug;
	private BigDecimal inuse;
	private BigDecimal closed;
	private String code;
	private BigDecimal daycharge;
	private BigDecimal thirdgen;
	private String cteam;
	private String atomorder;
	private String original;
	private String barcode;
	private String atc;
	private BigDecimal antibiotic;
	private BigDecimal gmdn;
	private String eof;
	private Set<Drugbalance> drugbalances = new HashSet<Drugbalance>(0);
	private Set<RecipeDrugs> recipeDrugses = new HashSet<RecipeDrugs>(0);
	private Set<OrderDrugs> orderDrugses = new HashSet<OrderDrugs>(0);
	private Set<Auditing> auditings = new HashSet<Auditing>(0);

	// Constructors

	/** default constructor */
	public Drugs() {
	}

	/** minimal constructor */
	public Drugs(BigDecimal drugid, String name) {
		this.drugid = drugid;
		this.name = name;
	}

	/** full constructor */
	public Drugs(BigDecimal drugid, Packaging packaging, String name, String description, BigDecimal quantity, BigDecimal drug, BigDecimal inuse,
			BigDecimal closed, String code, BigDecimal daycharge, BigDecimal thirdgen, String cteam, String atomorder, String original, String barcode,
			String atc, BigDecimal antibiotic, BigDecimal gmdn, String eof, Set<Drugbalance> drugbalances, Set<RecipeDrugs> recipeDrugses,
			Set<OrderDrugs> orderDrugses, Set<Auditing> auditings) {
		this.drugid = drugid;
		this.packaging = packaging;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.drug = drug;
		this.inuse = inuse;
		this.closed = closed;
		this.code = code;
		this.daycharge = daycharge;
		this.thirdgen = thirdgen;
		this.cteam = cteam;
		this.atomorder = atomorder;
		this.original = original;
		this.barcode = barcode;
		this.atc = atc;
		this.antibiotic = antibiotic;
		this.gmdn = gmdn;
		this.eof = eof;
		this.drugbalances = drugbalances;
		this.recipeDrugses = recipeDrugses;
		this.orderDrugses = orderDrugses;
		this.auditings = auditings;
	}

	// Property accessors
	@Id
	@Column(name = "DRUGID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDrugid() {
		return this.drugid;
	}

	public void setDrugid(BigDecimal drugid) {
		this.drugid = drugid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PACKAGINGID")
	public Packaging getPackaging() {
		return this.packaging;
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	@Column(name = "NAME", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 150)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "QUANTITY", precision = 22, scale = 0)
	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Column(name = "DRUG", precision = 22, scale = 0)
	public BigDecimal getDrug() {
		return this.drug;
	}

	public void setDrug(BigDecimal drug) {
		this.drug = drug;
	}

	@Column(name = "INUSE", precision = 22, scale = 0)
	public BigDecimal getInuse() {
		return this.inuse;
	}

	public void setInuse(BigDecimal inuse) {
		this.inuse = inuse;
	}

	@Column(name = "CLOSED", precision = 22, scale = 0)
	public BigDecimal getClosed() {
		return this.closed;
	}

	public void setClosed(BigDecimal closed) {
		this.closed = closed;
	}

	@Column(name = "CODE", length = 30)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "DAYCHARGE", precision = 22, scale = 0)
	public BigDecimal getDaycharge() {
		return this.daycharge;
	}

	public void setDaycharge(BigDecimal daycharge) {
		this.daycharge = daycharge;
	}

	@Column(name = "THIRDGEN", precision = 22, scale = 0)
	public BigDecimal getThirdgen() {
		return this.thirdgen;
	}

	public void setThirdgen(BigDecimal thirdgen) {
		this.thirdgen = thirdgen;
	}

	@Column(name = "CTEAM", length = 30)
	public String getCteam() {
		return this.cteam;
	}

	public void setCteam(String cteam) {
		this.cteam = cteam;
	}

	@Column(name = "ATOMORDER", length = 30)
	public String getAtomorder() {
		return this.atomorder;
	}

	public void setAtomorder(String atomorder) {
		this.atomorder = atomorder;
	}

	@Column(name = "ORIGINAL", length = 10)
	public String getOriginal() {
		return this.original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	@Column(name = "BARCODE", length = 30)
	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Column(name = "ATC", length = 30)
	public String getAtc() {
		return this.atc;
	}

	public void setAtc(String atc) {
		this.atc = atc;
	}

	@Column(name = "ANTIBIOTIC", precision = 22, scale = 0)
	public BigDecimal getAntibiotic() {
		return this.antibiotic;
	}

	public void setAntibiotic(BigDecimal antibiotic) {
		this.antibiotic = antibiotic;
	}

	@Column(name = "GMDN", precision = 22, scale = 0)
	public BigDecimal getGmdn() {
		return this.gmdn;
	}

	public void setGmdn(BigDecimal gmdn) {
		this.gmdn = gmdn;
	}

	@Column(name = "EOF", length = 30)
	public String getEof() {
		return this.eof;
	}

	public void setEof(String eof) {
		this.eof = eof;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "drugs")
	public Set<Drugbalance> getDrugbalances() {
		return this.drugbalances;
	}

	public void setDrugbalances(Set<Drugbalance> drugbalances) {
		this.drugbalances = drugbalances;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "drugs")
	public Set<RecipeDrugs> getRecipeDrugses() {
		return this.recipeDrugses;
	}

	public void setRecipeDrugses(Set<RecipeDrugs> recipeDrugses) {
		this.recipeDrugses = recipeDrugses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "drugs")
	public Set<OrderDrugs> getOrderDrugses() {
		return this.orderDrugses;
	}

	public void setOrderDrugses(Set<OrderDrugs> orderDrugses) {
		this.orderDrugses = orderDrugses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "drugs")
	public Set<Auditing> getAuditings() {
		return this.auditings;
	}

	public void setAuditings(Set<Auditing> auditings) {
		this.auditings = auditings;
	}

}