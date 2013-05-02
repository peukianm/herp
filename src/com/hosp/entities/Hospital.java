package com.hosp.entities;

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
 * Hospital entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(true)
@Table(name = "HOSPITAL", schema = "HOSPITAL")
public class Hospital implements java.io.Serializable {

    // Fields
    private Double hospitalid;
    private Dype dype;
    private String name;
    private String description;
    private String address;
    private String phone1;
    private String phone2;
    private String prefecture;
    private String town;
    private String admin;
    private String finadmin;
    private Double primeforeas;
    private String dapycode;
    private String doy;
    private String dapyadmin;
    private String afm;
    private String hunitcode;
    private Set<Surgeon> surgeons = new HashSet<Surgeon>(0);
    private Set<Surgery> surgeries = new HashSet<Surgery>(0);
    private Set<Users> userses = new HashSet<Users>(0);
    private Set<ExAssertion> exAssertions = new HashSet<ExAssertion>(0);
    private Set<FinProtocol> finProtocols = new HashSet<FinProtocol>(0);
    private Set<ExPeriod> exPeriods = new HashSet<ExPeriod>(0);
    private Set<Department> departments = new HashSet<Department>(0);
    private Set<ExPara> exParas = new HashSet<ExPara>(0);
    private Set<ExContract> exContracts = new HashSet<ExContract>(0);
    private Set<Drugbalance> drugbalances = new HashSet<Drugbalance>(0);
    private Set<FinTimol> finTimols = new HashSet<FinTimol>(0);
    private Set<Lab> labs = new HashSet<Lab>(0);
    private Set<ExParaCounter> exParaCounters = new HashSet<ExParaCounter>(0);
    private Set<Auditing> auditings = new HashSet<Auditing>(0);
    private Set<ExTimol> exTimols = new HashSet<ExTimol>(0);
    private Set<ExTameio> exTameios = new HashSet<ExTameio>(0);
    private Set<ExParaType> exParaTypes = new HashSet<ExParaType>(0);
    private Set<Orders> orderses = new HashSet<Orders>(0);
    private Set<Recipe> recipes = new HashSet<Recipe>(0);
    private Set<FinBudget> finBudgets = new HashSet<FinBudget>(0);
    private Set<FinEntal> finEntals = new HashSet<FinEntal>(0);
    private Set<Admission> admissions = new HashSet<Admission>(0);
    private Set<ExTameioCounter> exTameioCounters = new HashSet<ExTameioCounter>(0);
    private Set<Foreas> foreases = new HashSet<Foreas>(0);
    private Set<FinDesm> finDesms = new HashSet<FinDesm>(0);

    // Constructors
    /**
     * default constructor
     */
    public Hospital() {
    }

    /**
     * minimal constructor
     */
    public Hospital(Double hospitalid, String name) {
        this.hospitalid = hospitalid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public Hospital(Double hospitalid, Dype dype, String name, String description, String address, String phone1, String phone2, String prefecture, String hunticode,
            String town, String admin, String finadmin, Double primeforeas, String dapycode, String doy, String dapyadmin, String afm, Set<Surgeon> surgeons,
            Set<Surgery> surgeries, Set<Users> userses, Set<ExAssertion> exAssertions, Set<FinProtocol> finProtocols, Set<ExPeriod> exPeriods,
            Set<Department> departments, Set<ExPara> exParas, Set<ExContract> exContracts, Set<Drugbalance> drugbalances, Set<FinTimol> finTimols,
            Set<Lab> labs, Set<ExParaCounter> exParaCounters, Set<Auditing> auditings, Set<ExTimol> exTimols, Set<ExTameio> exTameios,
            Set<ExParaType> exParaTypes, Set<Orders> orderses, Set<Recipe> recipes, Set<FinBudget> finBudgets, Set<FinEntal> finEntals,
            Set<Admission> admissions, Set<ExTameioCounter> exTameioCounters, Set<Foreas> foreases, Set<FinDesm> finDesms) {
        this.hospitalid = hospitalid;
        this.dype = dype;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.prefecture = prefecture;
        this.town = town;
        this.admin = admin;
        this.finadmin = finadmin;
        this.primeforeas = primeforeas;
        this.dapycode = dapycode;
        this.doy = doy;
        this.dapyadmin = dapyadmin;
        this.afm = afm;
        this.surgeons = surgeons;
        this.surgeries = surgeries;
        this.userses = userses;
        this.exAssertions = exAssertions;
        this.finProtocols = finProtocols;
        this.exPeriods = exPeriods;
        this.departments = departments;
        this.exParas = exParas;
        this.exContracts = exContracts;
        this.drugbalances = drugbalances;
        this.finTimols = finTimols;
        this.labs = labs;
        this.exParaCounters = exParaCounters;
        this.auditings = auditings;
        this.exTimols = exTimols;
        this.exTameios = exTameios;
        this.exParaTypes = exParaTypes;
        this.orderses = orderses;
        this.recipes = recipes;
        this.finBudgets = finBudgets;
        this.finEntals = finEntals;
        this.admissions = admissions;
        this.exTameioCounters = exTameioCounters;
        this.foreases = foreases;
        this.finDesms = finDesms;
        this.hunitcode = hunticode;
    }

    // Property accessors
    @Id
    @Column(name = "HOSPITALID", unique = true, nullable = false, precision = 0)
    public Double getHospitalid() {
        return this.hospitalid;
    }

    public void setHospitalid(Double hospitalid) {
        this.hospitalid = hospitalid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DYPEID")
    public Dype getDype() {
        return this.dype;
    }

    public void setDype(Dype dype) {
        this.dype = dype;
    }

    @Column(name = "NAME", nullable = false, length = 4000)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION", length = 4000)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "ADDRESS", length = 4000)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "PHONE1", length = 4000)
    public String getPhone1() {
        return this.phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    @Column(name = "PHONE2", length = 4000)
    public String getPhone2() {
        return this.phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    @Column(name = "PREFECTURE", length = 100)
    public String getPrefecture() {
        return this.prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    @Column(name = "TOWN", length = 100)
    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "ADMIN", length = 120)
    public String getAdmin() {
        return this.admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Column(name = "FINADMIN", length = 120)
    public String getFinadmin() {
        return this.finadmin;
    }

    public void setFinadmin(String finadmin) {
        this.finadmin = finadmin;
    }

    @Column(name = "PRIMEFOREAS", precision = 0)
    public Double getPrimeforeas() {
        return this.primeforeas;
    }

    public void setPrimeforeas(Double primeforeas) {
        this.primeforeas = primeforeas;
    }

    @Column(name = "DAPYCODE", length = 20)
    public String getDapycode() {
        return this.dapycode;
    }

    public void setDapycode(String dapycode) {
        this.dapycode = dapycode;
    }

    @Column(name = "DOY", length = 40)
    public String getDoy() {
        return this.doy;
    }

    public void setDoy(String doy) {
        this.doy = doy;
    }

    @Column(name = "DAPYADMIN", length = 50)
    public String getDapyadmin() {
        return this.dapyadmin;
    }

    public void setDapyadmin(String dapyadmin) {
        this.dapyadmin = dapyadmin;
    }

    @Column(name = "AFM", length = 20)
    public String getAfm() {
        return this.afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    @Column(name = "HUNITCODE", length = 20)
    public String getHunitcode() {
        return this.hunitcode;
    }

    public void setHunitcode(String hunitcode) {
        this.hunitcode = hunitcode;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Surgeon> getSurgeons() {
        return this.surgeons;
    }

    public void setSurgeons(Set<Surgeon> surgeons) {
        this.surgeons = surgeons;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Surgery> getSurgeries() {
        return this.surgeries;
    }

    public void setSurgeries(Set<Surgery> surgeries) {
        this.surgeries = surgeries;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Users> getUserses() {
        return this.userses;
    }

    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<ExAssertion> getExAssertions() {
        return this.exAssertions;
    }

    public void setExAssertions(Set<ExAssertion> exAssertions) {
        this.exAssertions = exAssertions;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<FinProtocol> getFinProtocols() {
        return this.finProtocols;
    }

    public void setFinProtocols(Set<FinProtocol> finProtocols) {
        this.finProtocols = finProtocols;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<ExPeriod> getExPeriods() {
        return this.exPeriods;
    }

    public void setExPeriods(Set<ExPeriod> exPeriods) {
        this.exPeriods = exPeriods;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Department> getDepartments() {
        return this.departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<ExPara> getExParas() {
        return this.exParas;
    }

    public void setExParas(Set<ExPara> exParas) {
        this.exParas = exParas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<ExContract> getExContracts() {
        return this.exContracts;
    }

    public void setExContracts(Set<ExContract> exContracts) {
        this.exContracts = exContracts;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Drugbalance> getDrugbalances() {
        return this.drugbalances;
    }

    public void setDrugbalances(Set<Drugbalance> drugbalances) {
        this.drugbalances = drugbalances;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<FinTimol> getFinTimols() {
        return this.finTimols;
    }

    public void setFinTimols(Set<FinTimol> finTimols) {
        this.finTimols = finTimols;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Lab> getLabs() {
        return this.labs;
    }

    public void setLabs(Set<Lab> labs) {
        this.labs = labs;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<ExParaCounter> getExParaCounters() {
        return this.exParaCounters;
    }

    public void setExParaCounters(Set<ExParaCounter> exParaCounters) {
        this.exParaCounters = exParaCounters;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Auditing> getAuditings() {
        return this.auditings;
    }

    public void setAuditings(Set<Auditing> auditings) {
        this.auditings = auditings;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<ExTimol> getExTimols() {
        return this.exTimols;
    }

    public void setExTimols(Set<ExTimol> exTimols) {
        this.exTimols = exTimols;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<ExTameio> getExTameios() {
        return this.exTameios;
    }

    public void setExTameios(Set<ExTameio> exTameios) {
        this.exTameios = exTameios;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<ExParaType> getExParaTypes() {
        return this.exParaTypes;
    }

    public void setExParaTypes(Set<ExParaType> exParaTypes) {
        this.exParaTypes = exParaTypes;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Recipe> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<FinBudget> getFinBudgets() {
        return this.finBudgets;
    }

    public void setFinBudgets(Set<FinBudget> finBudgets) {
        this.finBudgets = finBudgets;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<FinEntal> getFinEntals() {
        return this.finEntals;
    }

    public void setFinEntals(Set<FinEntal> finEntals) {
        this.finEntals = finEntals;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Admission> getAdmissions() {
        return this.admissions;
    }

    public void setAdmissions(Set<Admission> admissions) {
        this.admissions = admissions;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<ExTameioCounter> getExTameioCounters() {
        return this.exTameioCounters;
    }

    public void setExTameioCounters(Set<ExTameioCounter> exTameioCounters) {
        this.exTameioCounters = exTameioCounters;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<Foreas> getForeases() {
        return this.foreases;
    }

    public void setForeases(Set<Foreas> foreases) {
        this.foreases = foreases;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
    public Set<FinDesm> getFinDesms() {
        return this.finDesms;
    }

    public void setFinDesms(Set<FinDesm> finDesms) {
        this.finDesms = finDesms;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Hospital)) {
            return false;
        }

        Hospital compare = (Hospital) obj;

        return compare.hospitalid.equals(this.hospitalid);
    }

    @Override
    public int hashCode() {
        return hospitalid != null ? this.getClass().hashCode() + hospitalid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "Hospital{" + "id=" + hospitalid + ", name=" + getName() + " }";
    }
}