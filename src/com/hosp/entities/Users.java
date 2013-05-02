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
 * Users entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "USERS", schema = "HOSPITAL")
public class Users implements java.io.Serializable {

    // Fields
    private BigDecimal userid;
    private Hospital hospital;
    private Department department;
    private Role role;
    private String username;
    private String password;
    private String description;
    private String name;
    private String surname;
    private BigDecimal exotep;    
    private Set<ExPara> exParas = new HashSet<ExPara>(0);
    private Set<Auditing> auditings = new HashSet<Auditing>(0);

    // Constructors
    /**
     * default constructor
     */
    public Users() {
    }

    /**
     * minimal constructor
     */
    public Users(BigDecimal userid, Hospital hospital, Department department, String username, String password) {
        this.userid = userid;
        this.hospital = hospital;
        this.department = department;
        this.username = username;
        this.password = password;
    }

    /**
     * full constructor
     */
    public Users(BigDecimal userid, Hospital hospital, Department department, Role role, String username, String password, String description, String name,
            String surname, Set<ExPara> exParas, Set<Auditing> auditings, BigDecimal exotep) {
        this.userid = userid;
        this.hospital = hospital;
        this.department = department;
        this.role = role;
        this.username = username;
        this.password = password;
        this.description = description;
        this.name = name;
        this.surname = surname;
        this.exParas = exParas;
        this.auditings = auditings;
        this.exotep = exotep;
    }

    // Property accessors
    @Id
    @Column(name = "USERID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getUserid() {
        return this.userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
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
    @JoinColumn(name = "DEPARTMENTID", nullable = false)
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLEID")
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "USERNAME", nullable = false, length = 100)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD", nullable = false, length = 100)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "DESCRIPTION", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "NAME", length = 80)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SURNAME", length = 80)
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<ExPara> getExParas() {
        return this.exParas;
    }

    public void setExParas(Set<ExPara> exParas) {
        this.exParas = exParas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Auditing> getAuditings() {
        return this.auditings;
    }

    public void setAuditings(Set<Auditing> auditings) {
        this.auditings = auditings;
    }
    
    
    @Column(name = "EXOTEP", precision = 22, scale = 0)
    public BigDecimal getExotep() {
        return exotep;
    }

    public void setExotep(BigDecimal exotep) {
        this.exotep = exotep;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Users)) {
            return false;
        }

        Users compare = (Users) obj;

        return compare.userid.equals(this.userid);
    }

    @Override
    public int hashCode() {
        return userid != null ? this.getClass().hashCode() + userid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "User{" + "id=" + userid + ", usernname=" + username + " role=" + getRole().getRoleid() + "}";
    }
}