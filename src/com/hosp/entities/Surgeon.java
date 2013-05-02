package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
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
 * Surgeon entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SURGEON", schema = "HOSPITAL")
public class Surgeon implements java.io.Serializable {

	// Fields

	private BigDecimal surgeonid;
	private Hospital hospital;
	private Department department;
	private Doctorrank doctorrank;
	private Speciality speciality;
	private String name;
	private String surname;
	private String fathername;
	private Set<Surgery> surgeriesForFirstassistantid = new HashSet<Surgery>(0);
	private Set<Surgery> surgeriesForSecondsurgeonid = new HashSet<Surgery>(0);
	private Set<Surgery> surgeriesForSecondassistantid = new HashSet<Surgery>(0);
	private Set<Surgery> surgeriesForFirstsurgeonid = new HashSet<Surgery>(0);

	// Constructors

	/** default constructor */
	public Surgeon() {
	}

	/** minimal constructor */
	public Surgeon(BigDecimal surgeonid, String name, String surname) {
		this.surgeonid = surgeonid;
		this.name = name;
		this.surname = surname;
	}

	/** full constructor */
	public Surgeon(BigDecimal surgeonid, Hospital hospital, Department department, Doctorrank doctorrank, Speciality speciality, String name, String surname,
			String fathername, Set<Surgery> surgeriesForFirstassistantid, Set<Surgery> surgeriesForSecondsurgeonid, Set<Surgery> surgeriesForSecondassistantid,
			Set<Surgery> surgeriesForFirstsurgeonid) {
		this.surgeonid = surgeonid;
		this.hospital = hospital;
		this.department = department;
		this.doctorrank = doctorrank;
		this.speciality = speciality;
		this.name = name;
		this.surname = surname;
		this.fathername = fathername;
		this.surgeriesForFirstassistantid = surgeriesForFirstassistantid;
		this.surgeriesForSecondsurgeonid = surgeriesForSecondsurgeonid;
		this.surgeriesForSecondassistantid = surgeriesForSecondassistantid;
		this.surgeriesForFirstsurgeonid = surgeriesForFirstsurgeonid;
	}

	// Property accessors
	@Id
	@Column(name = "SURGEONID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getSurgeonid() {
		return this.surgeonid;
	}

	public void setSurgeonid(BigDecimal surgeonid) {
		this.surgeonid = surgeonid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITALID")
	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENTID")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RANKID")
	public Doctorrank getDoctorrank() {
		return this.doctorrank;
	}

	public void setDoctorrank(Doctorrank doctorrank) {
		this.doctorrank = doctorrank;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPECIALITYID")
	public Speciality getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SURNAME", nullable = false, length = 100)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "FATHERNAME", length = 70)
	public String getFathername() {
		return this.fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "surgeonByFirstassistantid")
	public Set<Surgery> getSurgeriesForFirstassistantid() {
		return this.surgeriesForFirstassistantid;
	}

	public void setSurgeriesForFirstassistantid(Set<Surgery> surgeriesForFirstassistantid) {
		this.surgeriesForFirstassistantid = surgeriesForFirstassistantid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "surgeonBySecondsurgeonid")
	public Set<Surgery> getSurgeriesForSecondsurgeonid() {
		return this.surgeriesForSecondsurgeonid;
	}

	public void setSurgeriesForSecondsurgeonid(Set<Surgery> surgeriesForSecondsurgeonid) {
		this.surgeriesForSecondsurgeonid = surgeriesForSecondsurgeonid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "surgeonBySecondassistantid")
	public Set<Surgery> getSurgeriesForSecondassistantid() {
		return this.surgeriesForSecondassistantid;
	}

	public void setSurgeriesForSecondassistantid(Set<Surgery> surgeriesForSecondassistantid) {
		this.surgeriesForSecondassistantid = surgeriesForSecondassistantid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "surgeonByFirstsurgeonid")
	public Set<Surgery> getSurgeriesForFirstsurgeonid() {
		return this.surgeriesForFirstsurgeonid;
	}

	public void setSurgeriesForFirstsurgeonid(Set<Surgery> surgeriesForFirstsurgeonid) {
		this.surgeriesForFirstsurgeonid = surgeriesForFirstsurgeonid;
	}

}