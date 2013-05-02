package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MaterialAdmission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MATERIAL_ADMISSION", schema = "HOSPITAL")
public class MaterialAdmission implements java.io.Serializable {

	// Fields

	private MaterialAdmissionId id;
	private Materials materials;
	private Admission admission;
	private BigDecimal quantity;
	private Date receivedate;

	// Constructors

	/** default constructor */
	public MaterialAdmission() {
	}

	/** full constructor */
	public MaterialAdmission(MaterialAdmissionId id, Materials materials, Admission admission, BigDecimal quantity, Date receivedate) {
		this.id = id;
		this.materials = materials;
		this.admission = admission;
		this.quantity = quantity;
		this.receivedate = receivedate;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "admisionid", column = @Column(name = "ADMISIONID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "materialid", column = @Column(name = "MATERIALID", nullable = false, precision = 22, scale = 0)) })
	public MaterialAdmissionId getId() {
		return this.id;
	}

	public void setId(MaterialAdmissionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATERIALID", nullable = false, insertable = false, updatable = false)
	public Materials getMaterials() {
		return this.materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADMISIONID", nullable = false, insertable = false, updatable = false)
	public Admission getAdmission() {
		return this.admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	@Column(name = "QUANTITY", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RECEIVEDATE", nullable = false, length = 7)
	public Date getReceivedate() {
		return this.receivedate;
	}

	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}

}