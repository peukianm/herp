package com.hosp.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
 * ExPeriod entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_PERIOD", schema = "HOSPITAL")
public class ExPeriod implements java.io.Serializable {

	// Fields

	private BigDecimal periodid;
	private Hospital hospital;
	private ExYear exYear;
	private ExMonth exMonth;
	private String name;
	private BigDecimal enabled;
	private Set<ExTameioCounter> exTameioCounters = new HashSet<ExTameioCounter>(0);
	private Set<ExPara> exParas = new HashSet<ExPara>(0);
	private Set<ExAssertion> exAssertions = new HashSet<ExAssertion>(0);
	private Timestamp createdTimestamp;

	// Constructors

	/** default constructor */
	public ExPeriod() {
	}

	/** minimal constructor */
	public ExPeriod(BigDecimal periodid, ExYear exYear, ExMonth exMonth, String name) {
		this.periodid = periodid;
		this.exYear = exYear;
		this.exMonth = exMonth;
		this.name = name;
	}

	/** full constructor */
	public ExPeriod(BigDecimal periodid, Hospital hospital, ExYear exYear, ExMonth exMonth, String name, BigDecimal enabled,
			Set<ExTameioCounter> exTameioCounters, Set<ExPara> exParas, Set<ExAssertion> exAssertions, Timestamp createdTimestamp) {
		this.periodid = periodid;
		this.hospital = hospital;
		this.exYear = exYear;
		this.exMonth = exMonth;
		this.name = name;
		this.enabled = enabled;
		this.exTameioCounters = exTameioCounters;
		this.exParas = exParas;
		this.exAssertions = exAssertions;
		this.createdTimestamp = createdTimestamp;
	}

	// Property accessors
	@Id
	@Column(name = "PERIODID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getPeriodid() {
		return this.periodid;
	}

	public void setPeriodid(BigDecimal periodid) {
		this.periodid = periodid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "HOSPITALID")
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "YEARID", nullable = false)
	public ExYear getExYear() {
		return this.exYear;
	}

	public void setExYear(ExYear exYear) {
		this.exYear = exYear;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MONTHID", nullable = false)
	public ExMonth getExMonth() {
		return this.exMonth;
	}

	public void setExMonth(ExMonth exMonth) {
		this.exMonth = exMonth;
	}

	@Column(name = "NAME", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ENABLED", precision = 22, scale = 0)
	public BigDecimal getEnabled() {
		return this.enabled;
	}

	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exPeriod")
	public Set<ExTameioCounter> getExTameioCounters() {
		return this.exTameioCounters;
	}

	public void setExTameioCounters(Set<ExTameioCounter> exTameioCounters) {
		this.exTameioCounters = exTameioCounters;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exPeriod")
	public Set<ExPara> getExParas() {
		return this.exParas;
	}

	public void setExParas(Set<ExPara> exParas) {
		this.exParas = exParas;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "exPeriod")
	public Set<ExAssertion> getExAssertions() {
		return this.exAssertions;
	}

	public void setExAssertions(Set<ExAssertion> exAssertions) {
		this.exAssertions = exAssertions;
	}
	
	
	@Column(name = "CREATED_TIMESTAMP", nullable = true, length = 11, insertable=false, updatable=true)
	public Timestamp getCreatedTimestamp() {
		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
	
	
	
	// This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof ExPeriod && (periodid != null) ? periodid.equals(((ExPeriod) other).periodid) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return periodid != null ? this.getClass().hashCode() + periodid.hashCode() : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String representation.
    // It is not required by the Converter or so, it just pleases the reading in the logs.
    public String toString() {
        return "Ex:Period[" + periodid + "," + name + "]";
    }

}