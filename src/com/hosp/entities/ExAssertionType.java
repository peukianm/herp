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
 * ExAssertionType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_ASSERTION_TYPE", schema = "HOSPITAL")
public class ExAssertionType implements java.io.Serializable {

	// Fields

	private BigDecimal assertiontypeid;
	private String name;
	private Set<ExAssertion> exAssertions = new HashSet<ExAssertion>(0);

	// Constructors

	/** default constructor */
	public ExAssertionType() {
	}

	/** minimal constructor */
	public ExAssertionType(BigDecimal assertiontypeid, String name) {
		this.assertiontypeid = assertiontypeid;
		this.name = name;
	}

	/** full constructor */
	public ExAssertionType(BigDecimal assertiontypeid, String name, Set<ExAssertion> exAssertions) {
		this.assertiontypeid = assertiontypeid;
		this.name = name;
		this.exAssertions = exAssertions;
	}

	// Property accessors
	@Id
	@Column(name = "ASSERTIONTYPEID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getAssertiontypeid() {
		return this.assertiontypeid;
	}

	public void setAssertiontypeid(BigDecimal assertiontypeid) {
		this.assertiontypeid = assertiontypeid;
	}

	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exAssertionType")
	public Set<ExAssertion> getExAssertions() {
		return this.exAssertions;
	}

	public void setExAssertions(Set<ExAssertion> exAssertions) {
		this.exAssertions = exAssertions;
	}
	
	// This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof ExAssertionType && (assertiontypeid != null) ? assertiontypeid.equals(((ExAssertionType) other).assertiontypeid) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return assertiontypeid != null ? this.getClass().hashCode() + assertiontypeid.hashCode() : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String representation.
    // It is not required by the Converter or so, it just pleases the reading in the logs.
    public String toString() {
        return "ExAssertionType[" + assertiontypeid + "," + name + "]";
    }

}