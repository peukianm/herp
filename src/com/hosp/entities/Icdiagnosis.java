package com.hosp.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Icdiagnosis entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ICDIAGNOSIS", schema = "HOSPITAL")
public class Icdiagnosis implements java.io.Serializable {

	// Fields

	private Long diagnosisId;
	private Long referenceId;
	private String diagnosis;
	private String icd10Code;
	private Long categoryId;
	private String enabled;
	private String icd10diagnosis;
	private Date wdate;
	private Date edate;
	private Long userId;
	private Long placeId;
	private Long delUserId;
	private String useridagnosis;
	private String userdiagnosis;
	private Long temp;
	private String category;

	// Constructors

	/** default constructor */
	public Icdiagnosis() {
	}

	/** minimal constructor */
	public Icdiagnosis(Long diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	/** full constructor */
	public Icdiagnosis(Long diagnosisId, Long referenceId, String diagnosis, String icd10Code, Long categoryId, String enabled, String icd10diagnosis,
			Date wdate, Date edate, Long userId, Long placeId, Long delUserId, String useridagnosis, String userdiagnosis, Long temp, String category) {
		this.diagnosisId = diagnosisId;
		this.referenceId = referenceId;
		this.diagnosis = diagnosis;
		this.icd10Code = icd10Code;
		this.categoryId = categoryId;
		this.enabled = enabled;
		this.icd10diagnosis = icd10diagnosis;
		this.wdate = wdate;
		this.edate = edate;
		this.userId = userId;
		this.placeId = placeId;
		this.delUserId = delUserId;
		this.useridagnosis = useridagnosis;
		this.userdiagnosis = userdiagnosis;
		this.temp = temp;
		this.category = category;
	}

	// Property accessors
	@Id
	@Column(name = "DIAGNOSIS_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getDiagnosisId() {
		return this.diagnosisId;
	}

	public void setDiagnosisId(Long diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	@Column(name = "REFERENCE_ID", precision = 10, scale = 0)
	public Long getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	@Column(name = "DIAGNOSIS", length = 400)
	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Column(name = "ICD10_CODE", length = 32)
	public String getIcd10Code() {
		return this.icd10Code;
	}

	public void setIcd10Code(String icd10Code) {
		this.icd10Code = icd10Code;
	}

	@Column(name = "CATEGORY_ID", precision = 10, scale = 0)
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "ENABLED", length = 1)
	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Column(name = "ICD10DIAGNOSIS", length = 1)
	public String getIcd10diagnosis() {
		return this.icd10diagnosis;
	}

	public void setIcd10diagnosis(String icd10diagnosis) {
		this.icd10diagnosis = icd10diagnosis;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "WDATE", length = 7)
	public Date getWdate() {
		return this.wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EDATE", length = 7)
	public Date getEdate() {
		return this.edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	@Column(name = "USER_ID", precision = 10, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "PLACE_ID", precision = 10, scale = 0)
	public Long getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	@Column(name = "DEL_USER_ID", precision = 10, scale = 0)
	public Long getDelUserId() {
		return this.delUserId;
	}

	public void setDelUserId(Long delUserId) {
		this.delUserId = delUserId;
	}

	@Column(name = "USERIDAGNOSIS", length = 1)
	public String getUseridagnosis() {
		return this.useridagnosis;
	}

	public void setUseridagnosis(String useridagnosis) {
		this.useridagnosis = useridagnosis;
	}

	@Column(name = "USERDIAGNOSIS", length = 1)
	public String getUserdiagnosis() {
		return this.userdiagnosis;
	}

	public void setUserdiagnosis(String userdiagnosis) {
		this.userdiagnosis = userdiagnosis;
	}

	@Column(name = "TEMP", precision = 10, scale = 0)
	public Long getTemp() {
		return this.temp;
	}

	public void setTemp(Long temp) {
		this.temp = temp;
	}

	@Column(name = "CATEGORY", length = 30)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}