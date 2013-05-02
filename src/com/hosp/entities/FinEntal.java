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
 * FinEntal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FIN_ENTAL", schema = "HOSPITAL")
public class FinEntal implements java.io.Serializable {

	// Fields

	private BigDecimal entalid;
	private Hospital hospital;
	private FinKae finKae;
	private Foreas foreas;
	private FinYear finYear;
	private FinEidosEntal finEidosEntal;
	private Date dateofental;
	private BigDecimal amount;
	private String arental;
	private String afm;
	private String line;
	private Boolean settlement;
	private Set<FinTimol> finTimols = new HashSet<FinTimol>(0);

	// Constructors

	/** default constructor */
	public FinEntal() {
	}

	/** minimal constructor */
	public FinEntal(BigDecimal entalid) {
		this.entalid = entalid;
	}

	/** full constructor */
	public FinEntal(BigDecimal entalid, Hospital hospital, FinKae finKae, Foreas foreas, FinYear finYear, FinEidosEntal finEidosEntal, Date dateofental,
			BigDecimal amount, String arental, String afm, String line, Boolean settlement, Set<FinTimol> finTimols) {
		this.entalid = entalid;
		this.hospital = hospital;
		this.finKae = finKae;
		this.foreas = foreas;
		this.finYear = finYear;
		this.finEidosEntal = finEidosEntal;
		this.dateofental = dateofental;
		this.amount = amount;
		this.arental = arental;
		this.afm = afm;
		this.line = line;
		this.settlement = settlement;
		this.finTimols = finTimols;
	}

	// Property accessors
	@Id
	@Column(name = "ENTALID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getEntalid() {
		return this.entalid;
	}

	public void setEntalid(BigDecimal entalid) {
		this.entalid = entalid;
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
	@JoinColumn(name = "EIDOSENTALID")
	public FinEidosEntal getFinEidosEntal() {
		return this.finEidosEntal;
	}

	public void setFinEidosEntal(FinEidosEntal finEidosEntal) {
		this.finEidosEntal = finEidosEntal;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATEOFENTAL", length = 7)
	public Date getDateofental() {
		return this.dateofental;
	}

	public void setDateofental(Date dateofental) {
		this.dateofental = dateofental;
	}

	@Column(name = "AMOUNT", precision = 22, scale = 0)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "ARENTAL", length = 100)
	public String getArental() {
		return this.arental;
	}

	public void setArental(String arental) {
		this.arental = arental;
	}

	@Column(name = "AFM", length = 50)
	public String getAfm() {
		return this.afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	@Column(name = "LINE", length = 4)
	public String getLine() {
		return this.line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@Column(name = "SETTLEMENT", precision = 1, scale = 0)
	public Boolean getSettlement() {
		return this.settlement;
	}

	public void setSettlement(Boolean settlement) {
		this.settlement = settlement;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "finEntal")
	public Set<FinTimol> getFinTimols() {
		return this.finTimols;
	}

	public void setFinTimols(Set<FinTimol> finTimols) {
		this.finTimols = finTimols;
	}

}