package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Maritalstatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MARITALSTATUS", schema = "HOSPITAL")
public class Maritalstatus implements java.io.Serializable {

	// Fields

	private BigDecimal maritalstatusid;
	private String name;
	private Set<Patients> patientses = new HashSet<Patients>(0);

	// Constructors

	/** default constructor */
	public Maritalstatus() {
	}

	/** minimal constructor */
	public Maritalstatus(BigDecimal maritalstatusid) {
		this.maritalstatusid = maritalstatusid;
	}

	/** full constructor */
	public Maritalstatus(BigDecimal maritalstatusid, String name, Set<Patients> patientses) {
		this.maritalstatusid = maritalstatusid;
		this.name = name;
		this.patientses = patientses;
	}

	// Property accessors
	@Id
	@Column(name = "MARITALSTATUSID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getMaritalstatusid() {
		return this.maritalstatusid;
	}

	public void setMaritalstatusid(BigDecimal maritalstatusid) {
		this.maritalstatusid = maritalstatusid;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "maritalstatus")
	public Set<Patients> getPatientses() {
		return this.patientses;
	}

	public void setPatientses(Set<Patients> patientses) {
		this.patientses = patientses;
	}
        
        
            @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Maritalstatus)) {
            return false;
        }

        Maritalstatus compare = (Maritalstatus) obj;

        return compare.maritalstatusid.equals(this.maritalstatusid);
    }

    @Override
    public int hashCode() {
        return maritalstatusid != null ? this.getClass().hashCode() + maritalstatusid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "MaritalStatus{" + "id=" + maritalstatusid + ", name=" + getName() ;
    }
        

}