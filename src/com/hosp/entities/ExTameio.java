package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import org.eclipse.persistence.annotations.CacheIndex;
import org.eclipse.persistence.annotations.QueryRedirectors;

/**
 * ExTameio entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_TAMEIO", schema = "HOSPITAL")
@CacheIndex(columnNames={"HOSPITAL", "ENABLED"}, updateable=true)
@NamedQuery(
		  name="findHospitalTameia",
		  query="select model from ExTameio model where model.enabled=1 and model.hospital= :hospital",
		  hints={ 
				  @QueryHint(name="eclipselink.query-results-cache", value="true"), 
				  @QueryHint(name="eclipselink.query-results-cache.size", value="10")  
				 
		  })

public class ExTameio implements java.io.Serializable {

	// Fields

	private BigDecimal tameioid;
	private Hospital hospital;
	private BigDecimal tameionumber;
	private String name;
	private BigDecimal enabled;
	private Set<ExTameioCounter> exTameioCounters = new HashSet<ExTameioCounter>(0);
	private Set<ExPara> exParas = new HashSet<ExPara>(0);

	// Constructors

	/** default constructor */
	public ExTameio() {
	}

	/** minimal constructor */
	public ExTameio(BigDecimal tameioid, Hospital hospital, BigDecimal tameionumber) {
		this.tameioid = tameioid;
		this.hospital = hospital;
		this.tameionumber = tameionumber;
	}

	/** full constructor */
	public ExTameio(BigDecimal tameioid, Hospital hospital, BigDecimal tameionumber, String name, BigDecimal enabled, Set<ExTameioCounter> exTameioCounters,
			Set<ExPara> exParas) {
		this.tameioid = tameioid;
		this.hospital = hospital;
		this.tameionumber = tameionumber;
		this.name = name;
		this.enabled = enabled;
		this.exTameioCounters = exTameioCounters;
		this.exParas = exParas;
	}

	// Property accessors
	@Id
	@Column(name = "TAMEIOID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getTameioid() {
		return this.tameioid;
	}

	public void setTameioid(BigDecimal tameioid) {
		this.tameioid = tameioid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITALID", nullable = false)
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Column(name = "TAMEIONUMBER", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTameionumber() {
		return this.tameionumber;
	}

	public void setTameionumber(BigDecimal tameionumber) {
		this.tameionumber = tameionumber;
	}

	@Column(name = "NAME", length = 50)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exTameio")
	public Set<ExTameioCounter> getExTameioCounters() {
		return this.exTameioCounters;
	}

	public void setExTameioCounters(Set<ExTameioCounter> exTameioCounters) {
		this.exTameioCounters = exTameioCounters;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exTameio")
	public Set<ExPara> getExParas() {
		return this.exParas;
	}

	public void setExParas(Set<ExPara> exParas) {
		this.exParas = exParas;
	}
	
	
	// This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof ExTameio && (tameioid != null) ? tameioid.equals(((ExTameio) other).tameioid) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return tameioid != null ? this.getClass().hashCode() + tameioid.hashCode() : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String representation.
    // It is not required by the Converter or so, it just pleases the reading in the logs.
    public String toString() {
        return "ExTameio[" + tameioid + "," + name + "]";
    }

}