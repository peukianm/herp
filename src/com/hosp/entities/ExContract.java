package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ExContract entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_CONTRACT", schema = "HOSPITAL")
public class ExContract implements java.io.Serializable {

	// Fields

	private BigDecimal contractid;
	private Hospital hospital;
	private ExContractType exContractType;
	private String name;
	private String description;
	private BigDecimal enabled;
	private Date startdate;
	private Date enddate;
	private String contractnumber;
	private Set<ExPara> exParas = new HashSet<ExPara>(0);
	private Set<ExContractExams> exContractExamses = new HashSet<ExContractExams>(0);
	private Set<ExAssertion> exAssertions = new HashSet<ExAssertion>(0);

	// Constructors

	/** default constructor */
	public ExContract() {
	}

	/** minimal constructor */
	public ExContract(BigDecimal contractid, Hospital hospital, String name) {
		this.contractid = contractid;
		this.hospital = hospital;
		this.name = name;
	}

	/** full constructor */
	public ExContract(BigDecimal contractid, Hospital hospital, ExContractType exContractType, String name, String description, BigDecimal enabled,
			Date startdate, Date enddate, String contractnumber, Set<ExPara> exParas, Set<ExContractExams> exContractExamses, Set<ExAssertion> exAssertions) {
		this.contractid = contractid;
		this.hospital = hospital;
		this.exContractType = exContractType;
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.startdate = startdate;
		this.enddate = enddate;
		this.contractnumber = contractnumber;
		this.exParas = exParas;
		this.exContractExamses = exContractExamses;
		this.exAssertions = exAssertions;
	}

	// Property accessors
	@Id
	@Column(name = "CONTRACTID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getContractid() {
		return this.contractid;
	}

	public void setContractid(BigDecimal contractid) {
		this.contractid = contractid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITALID", nullable = false)
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTRACTTYPEID")
	public ExContractType getExContractType() {
		return this.exContractType;
	}

	public void setExContractType(ExContractType exContractType) {
		this.exContractType = exContractType;
	}

	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ENABLED", precision = 22, scale = 0)
	public BigDecimal getEnabled() {
		return this.enabled;
	}

	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", length = 7)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE", length = 7)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Column(name = "CONTRACTNUMBER", length = 30)
	public String getContractnumber() {
		return this.contractnumber;
	}

	public void setContractnumber(String contractnumber) {
		this.contractnumber = contractnumber;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exContract")
	public Set<ExPara> getExParas() {
		return this.exParas;
	}

	public void setExParas(Set<ExPara> exParas) {
		this.exParas = exParas;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exContract")
	public Set<ExContractExams> getExContractExamses() {
		return this.exContractExamses;
	}

	public void setExContractExamses(Set<ExContractExams> exContractExamses) {
		this.exContractExamses = exContractExamses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exContract")
	public Set<ExAssertion> getExAssertions() {
		return this.exAssertions;
	}

	public void setExAssertions(Set<ExAssertion> exAssertions) {
		this.exAssertions = exAssertions;
	}
	
	
	// This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof ExContract && (contractid != null) ? contractid.equals(((ExContract) other).contractid) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return contractid != null ? this.getClass().hashCode() + contractid.hashCode() : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String representation.
    // It is not required by the Converter or so, it just pleases the reading in the logs.
    public String toString() {
        return "ExCoontract[" + contractid + "," + name + "]";
    }
	

}