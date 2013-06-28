package com.hosp.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * ExAssertion entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "EX_ASSERTION", schema = "HOSPITAL")
@SequenceGenerator(name = "SEQ_EX_ASSERTION", sequenceName = "EX_ASSERTION_SEQ",allocationSize=1)
public class ExAssertion implements java.io.Serializable {

    // Fields
    /**
     *
     */
    private static final long serialVersionUID = -5694653315838098098L;
    private BigDecimal assertionid;
    private ExContract exContract;
    private Hospital hospital;
    private ExYear exYear;
    private ExPeriod exPeriod;
    private ExAssertionType exAssertionType;
    private ExMonth exMonth;
    private String name;
    private BigDecimal amount;
    private String code;
    private BigDecimal enabled;
    private String submission;
    private BigDecimal opened;
    private Set<ExPara> exParas = new HashSet<ExPara>(0);
    private List<ExTimol> exTimols = new ArrayList<ExTimol>(0);
    private Timestamp createdTimestamp;
    private Set<ExParaCounter> exParaCounters = new HashSet<ExParaCounter>(0);
    private BigDecimal totlaTimolAMount;

    

    // Constructors
    /**
     * default constructor
     */
    public ExAssertion() {
        exTimols = new ArrayList<ExTimol>(0);
    }

    /**
     * minimal constructor
     */
    public ExAssertion(BigDecimal assertionid, Hospital hospital) {
        this.assertionid = assertionid;
        this.hospital = hospital;
    }

    /**
     * full constructor
     */
    public ExAssertion(BigDecimal assertionid, ExContract exContract, Hospital hospital, ExYear exYear, ExPeriod exPeriod, ExAssertionType exAssertionType,
            ExMonth exMonth, String name, BigDecimal amount, String code, BigDecimal enabled, String submission, BigDecimal opened, Set<ExPara> exParas,
            List<ExTimol> exTimols, Timestamp createdTimestamp, Set<ExParaCounter> exParaCounters) {
        this.assertionid = assertionid;
        this.exContract = exContract;
        this.hospital = hospital;
        this.exYear = exYear;
        this.exPeriod = exPeriod;
        this.exAssertionType = exAssertionType;
        this.exMonth = exMonth;
        this.name = name;
        this.amount = amount;
        this.code = code;
        this.enabled = enabled;
        this.submission = submission;
        this.opened = opened;
        this.exParas = exParas;
        this.exTimols = exTimols;
        this.createdTimestamp = createdTimestamp;
        this.exParaCounters = exParaCounters;
    }

    // Property accessors
    @Id
    @Column(name = "ASSERTIONID", unique = true, nullable = false, precision = 22, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EX_ASSERTION")
    public BigDecimal getAssertionid() {
        return this.assertionid;
    }

    public void setAssertionid(BigDecimal assertionid) {
        this.assertionid = assertionid;
    }

    @ManyToOne(fetch = FetchType.LAZY) //UPDATED!!!!!!!!!!!!!!!!!!!!!!
    @JoinColumn(name = "CONTRACTID")
    public ExContract getExContract() {
        return this.exContract;
    }

    public void setExContract(ExContract exContract) {
        this.exContract = exContract;
    }

    @ManyToOne(fetch = FetchType.LAZY)    //UPDATED!!!!!!!!!!!!!!!!!!!
    @JoinColumn(name = "HOSPITALID", nullable = false)
    public Hospital getHospital() {
        return this.hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @ManyToOne(fetch = FetchType.LAZY)   //UPDATED!!!!!!!!!!!!!!!!!!!
    @JoinColumn(name = "YEARID")
    public ExYear getExYear() {
        return this.exYear;
    }

    public void setExYear(ExYear exYear) {
        this.exYear = exYear;
    }

    @ManyToOne(fetch = FetchType.LAZY)   //UPDATED!!!!!!!!!!!!!!!!!!!
    @JoinColumn(name = "PERIODID")
    public ExPeriod getExPeriod() {
        return this.exPeriod;
    }

    public void setExPeriod(ExPeriod exPeriod) {
        this.exPeriod = exPeriod;
    }

    @ManyToOne(fetch = FetchType.LAZY)    //UPDATED!!!!!!!!!!!!!!!!!!!
    @JoinColumn(name = "ASSERIONTYPEID")
    public ExAssertionType getExAssertionType() {
        return this.exAssertionType;
    }

    public void setExAssertionType(ExAssertionType exAssertionType) {
        this.exAssertionType = exAssertionType;
    }

    @ManyToOne(fetch = FetchType.LAZY)   //UPDATED!!!!!!!!!!!!!!!!!!!
    @JoinColumn(name = "MONTHID")
    public ExMonth getExMonth() {
        return this.exMonth;
    }

    public void setExMonth(ExMonth exMonth) {
        this.exMonth = exMonth;
    }

    @Column(name = "NAME", length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "AMOUNT", precision = 22, scale = 2)
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "CODE", length = 50)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "ENABLED", precision = 22, scale = 0)
    public BigDecimal getEnabled() {
        return this.enabled;
    }

    public void setEnabled(BigDecimal enabled) {
        this.enabled = enabled;
    }

    @Column(name = "SUBMISSION", length = 80)
    public String getSubmission() {
        return this.submission;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
    }

    @Column(name = "OPENED", precision = 22, scale = 0)
    public BigDecimal getOpened() {
        return this.opened;
    }

    public void setOpened(BigDecimal opened) {
        this.opened = opened;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exAssertion")
    public Set<ExPara> getExParas() {
        //exParas.size();
        return this.exParas;
    }

    public void setExParas(Set<ExPara> exParas) {
        this.exParas = exParas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exAssertion")
    public Set<ExParaCounter> getExParaCounters() {
        return this.exParaCounters;
    }

    public void setExParaCounters(Set<ExParaCounter> exParaCounters) {
        this.exParaCounters = exParaCounters;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exAssertion")    //UPDATED !!!!!!!!!!!!!!!!!
    public List<ExTimol> getExTimols() {
        //exTimols.size();
        return this.exTimols;
    }

    public void setExTimols(List<ExTimol> exTimols) {
        this.exTimols = exTimols;
    }

    @Column(name = "CREATED_TIMESTAMP", nullable = true, length = 11, insertable = false, updatable = true)
    public Timestamp getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
    
    
    @Transient
    public BigDecimal getTotlaTimolAMount() {
        totlaTimolAMount = BigDecimal.ZERO;
        for(ExTimol timol : exTimols){
            totlaTimolAMount = totlaTimolAMount.add(timol.getAmount());
        }
        return totlaTimolAMount;
    }

    public void setTotlaTimolAMount(BigDecimal totlaTimolAMount) {
        this.totlaTimolAMount = totlaTimolAMount;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ExAssertion)) {
            return false;
        }

        ExAssertion compare = (ExAssertion) obj;

        return compare.assertionid.equals(this.assertionid);
    }

    @Override
    public int hashCode() {
        return assertionid != null ? this.getClass().hashCode() + assertionid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "ExAssertion{" + "id=" + assertionid + ", period=" + exPeriod.getName() + ", hospital=" + hospital.getName() + '}';
    }
}