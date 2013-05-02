package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MaterialAdmissionId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class MaterialAdmissionId implements java.io.Serializable {

	// Fields

	private BigDecimal admisionid;
	private BigDecimal materialid;

	// Constructors

	/** default constructor */
	public MaterialAdmissionId() {
	}

	/** full constructor */
	public MaterialAdmissionId(BigDecimal admisionid, BigDecimal materialid) {
		this.admisionid = admisionid;
		this.materialid = materialid;
	}

	// Property accessors

	@Column(name = "ADMISIONID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getAdmisionid() {
		return this.admisionid;
	}

	public void setAdmisionid(BigDecimal admisionid) {
		this.admisionid = admisionid;
	}

	@Column(name = "MATERIALID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getMaterialid() {
		return this.materialid;
	}

	public void setMaterialid(BigDecimal materialid) {
		this.materialid = materialid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MaterialAdmissionId))
			return false;
		MaterialAdmissionId castOther = (MaterialAdmissionId) other;

		return ((this.getAdmisionid() == castOther.getAdmisionid()) || (this.getAdmisionid() != null && castOther.getAdmisionid() != null && this
				.getAdmisionid().equals(castOther.getAdmisionid())))
				&& ((this.getMaterialid() == castOther.getMaterialid()) || (this.getMaterialid() != null && castOther.getMaterialid() != null && this
						.getMaterialid().equals(castOther.getMaterialid())));
	}

	   public int hashCode() {
		int result = 17;

		result = 37 * result + (getAdmisionid() == null ? 0 : this.getAdmisionid().hashCode());
		result = 37 * result + (getMaterialid() == null ? 0 : this.getMaterialid().hashCode());
		return result;
	}

}