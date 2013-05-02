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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "DEPARTMENT", schema = "HOSPITAL")
public class Department implements java.io.Serializable {

	// Fields

	private BigDecimal departmentid;
	private Hospital hospital;
	private String name;
	private String extraorder;
	private String type;
	private Set<Users> userses = new HashSet<Users>(0);
	private Set<Drugbalance> drugbalances = new HashSet<Drugbalance>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Surgery> surgeries = new HashSet<Surgery>(0);
	private Set<Recipe> recipes = new HashSet<Recipe>(0);
	private Set<Surgeon> surgeons = new HashSet<Surgeon>(0);
	private Set<Auditing> auditings = new HashSet<Auditing>(0);
	private Set<Admission> admissions = new HashSet<Admission>(0);
	private Set<Lab> labs = new HashSet<Lab>(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(BigDecimal departmentid, String name) {
		this.departmentid = departmentid;
		this.name = name;
	}

	/** full constructor */
	public Department(BigDecimal departmentid, Hospital hospital, String name, String extraorder, String type, Set<Users> userses,
			Set<Drugbalance> drugbalances, Set<Orders> orderses, Set<Surgery> surgeries, Set<Recipe> recipes, Set<Surgeon> surgeons, Set<Auditing> auditings,
			Set<Admission> admissions, Set<Lab> labs) {
		this.departmentid = departmentid;
		this.hospital = hospital;
		this.name = name;
		this.extraorder = extraorder;
		this.type = type;
		this.userses = userses;
		this.drugbalances = drugbalances;
		this.orderses = orderses;
		this.surgeries = surgeries;
		this.recipes = recipes;
		this.surgeons = surgeons;
		this.auditings = auditings;
		this.admissions = admissions;
		this.labs = labs;
	}

	// Property accessors
	@Id
	@Column(name = "DEPARTMENTID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDepartmentid() {
		return this.departmentid;
	}

	public void setDepartmentid(BigDecimal departmentid) {
		this.departmentid = departmentid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITALID")
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EXTRAORDER", length = 40)
	public String getExtraorder() {
		return this.extraorder;
	}

	public void setExtraorder(String extraorder) {
		this.extraorder = extraorder;
	}

	@Column(name = "TYPE", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Drugbalance> getDrugbalances() {
		return this.drugbalances;
	}

	public void setDrugbalances(Set<Drugbalance> drugbalances) {
		this.drugbalances = drugbalances;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Surgery> getSurgeries() {
		return this.surgeries;
	}

	public void setSurgeries(Set<Surgery> surgeries) {
		this.surgeries = surgeries;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Surgeon> getSurgeons() {
		return this.surgeons;
	}

	public void setSurgeons(Set<Surgeon> surgeons) {
		this.surgeons = surgeons;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Auditing> getAuditings() {
		return this.auditings;
	}

	public void setAuditings(Set<Auditing> auditings) {
		this.auditings = auditings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Admission> getAdmissions() {
		return this.admissions;
	}

	public void setAdmissions(Set<Admission> admissions) {
		this.admissions = admissions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Lab> getLabs() {
		return this.labs;
	}

	public void setLabs(Set<Lab> labs) {
		this.labs = labs;
	}
        
         @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Department)) {
            return false;
        }

        Department compare = (Department) obj;

        return compare.departmentid.equals(this.departmentid);
    }

    @Override
    public int hashCode() {
        return departmentid != null ? this.getClass().hashCode() + departmentid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + departmentid + ", name=" + getName() + " }";
    }

}