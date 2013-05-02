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
 * ExExam entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_EXAM", schema = "HOSPITAL")
public class ExExam implements java.io.Serializable {

    // Fields
    private BigDecimal examid;
    private ExExamCat exExamCat;
    private String name;
    private String abbrevation;
    private String code;
    private BigDecimal enabled;
    private BigDecimal ordered;
    private Set<ExContractExams> exContractExamses = new HashSet<ExContractExams>(0);
    private Set<ExParaExams> exParaExamses = new HashSet<ExParaExams>(0);

    // Constructors
    /**
     * default constructor
     */
    public ExExam() {
    }

    /**
     * minimal constructor
     */
    public ExExam(BigDecimal examid, String name) {
        this.examid = examid;
        this.name = name;
    }

    /**
     * full constructor
     */
    public ExExam(BigDecimal examid, ExExamCat exExamCat, String name, String code, BigDecimal enabled, BigDecimal ordered,
            Set<ExContractExams> exContractExamses, Set<ExParaExams> exParaExamses, String abbrevation) {
        this.examid = examid;
        this.exExamCat = exExamCat;
        this.name = name;
        this.code = code;
        this.enabled = enabled;
        this.ordered = ordered;
        this.exContractExamses = exContractExamses;
        this.exParaExamses = exParaExamses;
        this.abbrevation = abbrevation;
    }

    // Property accessors
    @Id
    @Column(name = "EXAMID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getExamid() {
        return this.examid;
    }

    public void setExamid(BigDecimal examid) {
        this.examid = examid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAMCATID")
    public ExExamCat getExExamCat() {
        return this.exExamCat;
    }

    public void setExExamCat(ExExamCat exExamCat) {
        this.exExamCat = exExamCat;
    }

    @Column(name = "NAME", nullable = false, length = 1000)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "ABBREVATION", nullable = true, length = 200)
    public String getAbbrevation() {
        return this.abbrevation;
    }

    public void setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
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

    @Column(name = "ORDERED", precision = 22, scale = 0)
    public BigDecimal getOrdered() {
        return this.ordered;
    }

    public void setOrdered(BigDecimal ordered) {
        this.ordered = ordered;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exExam")
    public Set<ExContractExams> getExContractExamses() {
        return this.exContractExamses;
    }

    public void setExContractExamses(Set<ExContractExams> exContractExamses) {
        this.exContractExamses = exContractExamses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exExam")
    public Set<ExParaExams> getExParaExamses() {
        return this.exParaExamses;
    }

    public void setExParaExamses(Set<ExParaExams> exParaExamses) {
        this.exParaExamses = exParaExamses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ExExam)) {
            return false;
        }

        ExExam compare = (ExExam) obj;
        return compare.examid.equals(this.examid);
    }

    @Override
    public int hashCode() {
        return examid != null ? this.getClass().hashCode() + examid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "ExExam{" + "id=" + examid + ", name=" + getName() + ", code=" + getCode() + '}';
    }
}