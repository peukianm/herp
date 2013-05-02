package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FinTimol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FIN_TIMOL", schema = "HOSPITAL")
public class FinTimol implements java.io.Serializable {

	// Fields

	private BigDecimal timolid;
	private FinKae finKae;
	private Foreas foreas;
	private Hospital hospital;
	private FinYear finYear;
	private FinEidosPist finEidosPist;
	private FinEntal finEntal;
	private FinDesm finDesm;
	private BigDecimal cover;
	private String artimol;
	private String ordertimol;
	private BigDecimal amount;
	private Date dateoftimol;
	private String afm;
	private String supname;

	// Constructors

	/** default constructor */
	public FinTimol() {
	}

	/** minimal constructor */
	public FinTimol(BigDecimal timolid, FinDesm finDesm) {
		this.timolid = timolid;
		this.finDesm = finDesm;
	}

	/** full constructor */
	public FinTimol(BigDecimal timolid, FinKae finKae, Foreas foreas, Hospital hospital, FinYear finYear, FinEidosPist finEidosPist, FinEntal finEntal,
			FinDesm finDesm, BigDecimal cover, String artimol, String ordertimol, BigDecimal amount, Date dateoftimol, String afm, String supname) {
		this.timolid = timolid;
		this.finKae = finKae;
		this.foreas = foreas;
		this.hospital = hospital;
		this.finYear = finYear;
		this.finEidosPist = finEidosPist;
		this.finEntal = finEntal;
		this.finDesm = finDesm;
		this.cover = cover;
		this.artimol = artimol;
		this.ordertimol = ordertimol;
		this.amount = amount;
		this.dateoftimol = dateoftimol;
		this.afm = afm;
		this.supname = supname;
	}

	// Property accessors
	@Id
	@Column(name = "TIMOLID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getTimolid() {
		return this.timolid;
	}

	public void setTimolid(BigDecimal timolid) {
		this.timolid = timolid;
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
	@JoinColumn(name = "HOSPITAID")
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
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
	@JoinColumn(name = "EIDOSPISTID")
	public FinEidosPist getFinEidosPist() {
		return this.finEidosPist;
	}

	public void setFinEidosPist(FinEidosPist finEidosPist) {
		this.finEidosPist = finEidosPist;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTALID")
	public FinEntal getFinEntal() {
		return this.finEntal;
	}

	public void setFinEntal(FinEntal finEntal) {
		this.finEntal = finEntal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESMID", nullable = false)
	public FinDesm getFinDesm() {
		return this.finDesm;
	}

	public void setFinDesm(FinDesm finDesm) {
		this.finDesm = finDesm;
	}

	@Column(name = "COVER", precision = 22, scale = 0)
	public BigDecimal getCover() {
		return this.cover;
	}

	public void setCover(BigDecimal cover) {
		this.cover = cover;
	}

	@Column(name = "ARTIMOL", length = 100)
	public String getArtimol() {
		return this.artimol;
	}

	public void setArtimol(String artimol) {
		this.artimol = artimol;
	}

	@Column(name = "ORDERTIMOL", length = 100)
	public String getOrdertimol() {
		return this.ordertimol;
	}

	public void setOrdertimol(String ordertimol) {
		this.ordertimol = ordertimol;
	}

	@Column(name = "AMOUNT", precision = 22, scale = 0)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATEOFTIMOL", length = 7)
	public Date getDateoftimol() {
		return this.dateoftimol;
	}

	public void setDateoftimol(Date dateoftimol) {
		this.dateoftimol = dateoftimol;
	}

	@Column(name = "AFM", length = 40)
	public String getAfm() {
		return this.afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	@Column(name = "SUPNAME", length = 150)
	public String getSupname() {
		return this.supname;
	}

	public void setSupname(String supname) {
		this.supname = supname;
	}

}