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
 * ExMonth entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_MONTH", schema = "HOSPITAL")
public class ExMonth implements java.io.Serializable {

	// Fields

	private BigDecimal monthid;
	private String name;
	private Set<ExPeriod> exPeriods = new HashSet<ExPeriod>(0);
	private Set<ExAssertion> exAssertions = new HashSet<ExAssertion>(0);

	// Constructors

	/** default constructor */
	public ExMonth() {
	}

	/** minimal constructor */
	public ExMonth(BigDecimal monthid, String name) {
		this.monthid = monthid;
		this.name = name;
	}

	/** full constructor */
	public ExMonth(BigDecimal monthid, String name, Set<ExPeriod> exPeriods, Set<ExAssertion> exAssertions) {
		this.monthid = monthid;
		this.name = name;
		this.exPeriods = exPeriods;
		this.exAssertions = exAssertions;
	}

	// Property accessors
	@Id
	@Column(name = "MONTHID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getMonthid() {
		return this.monthid;
	}

	public void setMonthid(BigDecimal monthid) {
		this.monthid = monthid;
	}

	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exMonth")
	public Set<ExPeriod> getExPeriods() {
		return this.exPeriods;
	}

	public void setExPeriods(Set<ExPeriod> exPeriods) {
		this.exPeriods = exPeriods;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exMonth")
	public Set<ExAssertion> getExAssertions() {
		return this.exAssertions;
	}

	public void setExAssertions(Set<ExAssertion> exAssertions) {
		this.exAssertions = exAssertions;
	}
	
	
	// This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof ExMonth && (monthid != null) ? monthid.equals(((ExMonth) other).monthid) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return monthid != null ? this.getClass().hashCode() + monthid.hashCode() : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String representation.
    // It is not required by the Converter or so, it just pleases the reading in the logs.
    public String toString() {
        return "ExMonth[" + monthid + "," + name + "]";
    }

}