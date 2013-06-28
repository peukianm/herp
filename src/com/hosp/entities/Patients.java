package com.hosp.entities;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Patients entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "PATIENTS", schema = "HOSPITAL")
//@SequenceGenerator(name = "SEQ_PATIENTS", sequenceName = "PATIENTS_SEQ",allocationSize=1)
public class Patients implements java.io.Serializable {

    // Fields
    private BigDecimal patientid;
    private Relegion relegion;
    private Proffesion proffesion;
    private Country country;
    private Insurance insurance;
    private Race race;
    private Nationality nationality;
    private Maritalstatus maritalstatus;
    private Sex sex;
    private Bloodtype bloodtype;
    private City city;
    private Prefecture prefecture;
    private String name;
    private String surname;
    private String amka;
    private String address;
    private Date dateofbirth;
    private String fathername;
    private String idnumber;
    private String mobile;
    private String phone;
    private String city_1;
    private String job;
    private String personalhistory;
    private String familyhistory;
    private String previousadmissions;
    private String comments;
    private String inside;
    private String insurancenumber;
    private BigDecimal enable;
    private Integer direct;
    private Set<Surgery> surgeries = new HashSet<Surgery>(0);
    private Set<Lab> labs = new HashSet<Lab>(0);
    private Set<ExPara> exParas = new HashSet<ExPara>(0);
    private Set<Auditing> auditings = new HashSet<Auditing>(0);
    private Set<Admission> admissions = new HashSet<Admission>(0);
    private Set<Recipe> recipes = new HashSet<Recipe>(0);

    // Constructors
    /**
     * default constructor
     */
    public Patients() {
    }

    /**
     * minimal constructor
     */
    public Patients(BigDecimal patientid, Insurance insurance, String name, String surname, String fathername, String insurancenumber) {
        this.patientid = patientid;
        this.insurance = insurance;
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.insurancenumber = insurancenumber;
    }

    /**
     * full constructor
     */
    public Patients(BigDecimal patientid, Relegion relegion, Proffesion proffesion, Country country, Insurance insurance, Race race, Nationality nationality,
            Maritalstatus maritalstatus, Sex sex, Bloodtype bloodtype, City city, Prefecture prefecture, String name, String surname, String amka,
            String address, Date dateofbirth, String fathername, String idnumber, String mobile, String phone, String city_1, String job, Integer direct,
            String personalhistory, String familyhistory, String previousadmissions, String comments, String inside, String insurancenumber, BigDecimal enable,
            Set<Surgery> surgeries, Set<Lab> labs, Set<ExPara> exParas, Set<Auditing> auditings, Set<Admission> admissions, Set<Recipe> recipes) {
        this.patientid = patientid;
        this.relegion = relegion;
        this.proffesion = proffesion;
        this.country = country;
        this.insurance = insurance;
        this.race = race;
        this.nationality = nationality;
        this.maritalstatus = maritalstatus;
        this.sex = sex;
        this.bloodtype = bloodtype;
        this.city = city;
        this.prefecture = prefecture;
        this.name = name;
        this.surname = surname;
        this.amka = amka;
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.fathername = fathername;
        this.idnumber = idnumber;
        this.mobile = mobile;
        this.phone = phone;
        this.city_1 = city_1;
        this.job = job;
        this.personalhistory = personalhistory;
        this.familyhistory = familyhistory;
        this.previousadmissions = previousadmissions;
        this.comments = comments;
        this.inside = inside;
        this.insurancenumber = insurancenumber;
        this.enable = enable;
        this.surgeries = surgeries;
        this.labs = labs;
        this.exParas = exParas;
        this.auditings = auditings;
        this.admissions = admissions;
        this.recipes = recipes;
        this.direct = direct;
    }

    // Property accessors
    @Id
    @Column(name = "PATIENTID", unique = true, nullable = false, precision = 22, scale = 0)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PATIENTS")
    public BigDecimal getPatientid() {
        return this.patientid;
    }

    public void setPatientid(BigDecimal patientid) {
        this.patientid = patientid;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "RELEGIONID")
    public Relegion getRelegion() {
        return this.relegion;
    }

    public void setRelegion(Relegion relegion) {
        this.relegion = relegion;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "PROFFESIONID")
    public Proffesion getProffesion() {
        return this.proffesion;
    }

    public void setProffesion(Proffesion proffesion) {
        this.proffesion = proffesion;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "COUNTRYID")
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "INSURANCEID", nullable = false)
    public Insurance getInsurance() {
        return this.insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "RACEID")
    public Race getRace() {
        return this.race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "NATIONALITYID")
    public Nationality getNationality() {
        return this.nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "MARITASSTATUSID")
    public Maritalstatus getMaritalstatus() {
        return this.maritalstatus;
    }

    public void setMaritalstatus(Maritalstatus maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "SEXID")
    public Sex getSex() {
        return this.sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "BLOODTYPEID")
    public Bloodtype getBloodtype() {
        return this.bloodtype;
    }

    public void setBloodtype(Bloodtype bloodtype) {
        this.bloodtype = bloodtype;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "CITYID")
    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!
    @JoinColumn(name = "PREFECTUREID")
    public Prefecture getPrefecture() {
        return this.prefecture;
    }

    public void setPrefecture(Prefecture prefecture) {
        this.prefecture = prefecture;
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

    @Column(name = "AMKA", length = 100)
    public String getAmka() {
        return this.amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    @Column(name = "ADDRESS", length = 100)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATEOFBIRTH", length = 7)
    public Date getDateofbirth() {
        return this.dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    @Column(name = "FATHERNAME", nullable = false, length = 100)
    public String getFathername() {
        return this.fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Column(name = "IDNUMBER", length = 100)
    public String getIdnumber() {
        return this.idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    @Column(name = "MOBILE", length = 100)
    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "PHONE", length = 100)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "CITY", length = 100)
    public String getCity_1() {
        return this.city_1;
    }

    public void setCity_1(String city_1) {
        this.city_1 = city_1;
    }

    @Column(name = "JOB", length = 100)
    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Column(name = "PERSONALHISTORY", length = 300)
    public String getPersonalhistory() {
        return this.personalhistory;
    }

    public void setPersonalhistory(String personalhistory) {
        this.personalhistory = personalhistory;
    }

    @Column(name = "FAMILYHISTORY", length = 300)
    public String getFamilyhistory() {
        return this.familyhistory;
    }

    public void setFamilyhistory(String familyhistory) {
        this.familyhistory = familyhistory;
    }

    @Column(name = "PREVIOUSADMISSIONS", length = 300)
    public String getPreviousadmissions() {
        return this.previousadmissions;
    }

    public void setPreviousadmissions(String previousadmissions) {
        this.previousadmissions = previousadmissions;
    }

    @Column(name = "COMMENTS", length = 300)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "INSIDE", length = 50)
    public String getInside() {
        return this.inside;
    }

    public void setInside(String inside) {
        this.inside = inside;
    }

    @Column(name = "INSURANCENUMBER", nullable = false, length = 100)
    public String getInsurancenumber() {
        return this.insurancenumber;
    }

    public void setInsurancenumber(String insurancenumber) {
        this.insurancenumber = insurancenumber;
    }

    @Column(name = "ENABLE", precision = 22, scale = 0)
    public BigDecimal getEnable() {
        return this.enable;
    }

    public void setEnable(BigDecimal enable) {
        this.enable = enable;
    }

    @Column(name = "DIRECT", precision = 0)
    public Integer getDirect() {
        return this.direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
    public Set<Surgery> getSurgeries() {
        return this.surgeries;
    }

    public void setSurgeries(Set<Surgery> surgeries) {
        this.surgeries = surgeries;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
    public Set<Lab> getLabs() {
        return this.labs;
    }

    public void setLabs(Set<Lab> labs) {
        this.labs = labs;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
    public Set<ExPara> getExParas() {
        return this.exParas;
    }

    public void setExParas(Set<ExPara> exParas) {
        this.exParas = exParas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
    public Set<Auditing> getAuditings() {
        return this.auditings;
    }

    public void setAuditings(Set<Auditing> auditings) {
        this.auditings = auditings;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
    public Set<Admission> getAdmissions() {
        return this.admissions;
    }

    public void setAdmissions(Set<Admission> admissions) {
        this.admissions = admissions;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patients")
    public Set<Recipe> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ExPara)) {
            return false;
        }

        Patients compare = (Patients) obj;

        return compare.patientid.equals(this.patientid);
    }

    @Override
    public int hashCode() {
        return patientid != null ? this.getClass().hashCode() + patientid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + patientid + ", name=" + getName() + ", surname=" + getSurname() + '}';
    }
}