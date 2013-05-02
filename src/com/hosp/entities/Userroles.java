package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Userroles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "USERROLES", schema = "HOSPITAL")
public class Userroles implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Users users;
	private Role role;
	private BigDecimal primary;

	// Constructors

	/** default constructor */
	public Userroles() {
	}

	/** minimal constructor */
	public Userroles(BigDecimal id, Users users, Role role) {
		this.id = id;
		this.users = users;
		this.role = role;
	}

	/** full constructor */
	public Userroles(BigDecimal id, Users users, Role role, BigDecimal primary) {
		this.id = id;
		this.users = users;
		this.role = role;
		this.primary = primary;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLEID", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "PRIMARY", precision = 22, scale = 0)
	public BigDecimal getPrimary() {
		return this.primary;
	}

	public void setPrimary(BigDecimal primary) {
		this.primary = primary;
	}

}