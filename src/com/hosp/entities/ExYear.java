package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ExYear entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_YEAR", schema = "HOSPITAL")
public class ExYear implements java.io.Serializable {

	// Fields

	private BigDecimal yearid;
	private String name;
	private Set<ExAssertion> exAssertions = new HashSet<ExAssertion>(0);
	private Set<ExPeriod> exPeriods = new HashSet<ExPeriod>(0);

	// Constructors

	/** default constructor */
	public ExYear() {
	}

	/** minimal constructor */
	public ExYear(BigDecimal yearid, String name) {
		this.yearid = yearid;
		this.name = name;
	}

	/** full constructor */
	public ExYear(BigDecimal yearid, String name, Set<ExAssertion> exAssertions, Set<ExPeriod> exPeriods) {
		this.yearid = yearid;
		this.name = name;
		this.exAssertions = exAssertions;
		this.exPeriods = exPeriods;
	}

	// Property accessors
	@Id
	@Column(name = "YEARID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getYearid() {
		return this.yearid;
	}

	public void setYearid(BigDecimal yearid) {
		this.yearid = yearid;
	}

	@Column(name = "NAME", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exYear")
	public Set<ExAssertion> getExAssertions() {
		return this.exAssertions;
	}

	public void setExAssertions(Set<ExAssertion> exAssertions) {
		this.exAssertions = exAssertions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exYear")
	public Set<ExPeriod> getExPeriods() {
		return this.exPeriods;
	}

	public void setExPeriods(Set<ExPeriod> exPeriods) {
		this.exPeriods = exPeriods;
	}
	
	
	// This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof ExYear && (yearid != null) ? yearid.equals(((ExYear) other).yearid) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return yearid != null ? this.getClass().hashCode() + yearid.hashCode() : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String representation.
    // It is not required by the Converter or so, it just pleases the reading in the logs.
    public String toString() {
        return "ExYear[" + yearid + "," + name + "]";
    }

}