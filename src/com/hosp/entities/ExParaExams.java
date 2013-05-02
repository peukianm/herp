package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * ExParaExams entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "EX_PARA_EXAMS", schema = "HOSPITAL")
public class ExParaExams implements java.io.Serializable {

    // Fields
    private BigDecimal paraexamid;
    private ExExam exExam;
    private ExPara exPara;
    private BigDecimal cost;
    private BigDecimal enabled;
    private BigDecimal quantity;
    private BigDecimal participation;
    
    private BigDecimal totalCost;
    private BigDecimal participationPrice; 

   
    // Constructors
    /**
     * default constructor
     */
    public ExParaExams() {
    }

    /**
     * full constructor
     */
    public ExParaExams(BigDecimal paraexamid, ExExam exExam, ExPara exPara, BigDecimal cost, BigDecimal enabled, BigDecimal quantity, BigDecimal participation) {
        this.paraexamid = paraexamid;
        this.exExam = exExam;
        this.exPara = exPara;
        this.cost = cost;
        this.enabled = enabled;
        this.quantity = quantity;
        this.participation = participation;
    }

    /**
     * full constructor
     */
    public ExParaExams(ExExam exExam, ExPara exPara, BigDecimal cost, BigDecimal enabled, BigDecimal quantity, BigDecimal participation) {
        this.paraexamid = paraexamid;
        this.exExam = exExam;
        this.exPara = exPara;
        this.cost = cost;
        this.enabled = enabled;
        this.quantity = quantity;
        this.participation = participation;
    }

    // Property accessors
    @Id
    @Column(name = "PARAEXAMID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getParaexamid() {
        return this.paraexamid;
    }

    public void setParaexamid(BigDecimal paraexamid) {
        this.paraexamid = paraexamid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EXAMID", nullable = false)
    public ExExam getExExam() {
        return this.exExam;
    }

    public void setExExam(ExExam exExam) {
        this.exExam = exExam;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARAID", nullable = false)
    public ExPara getExPara() {
        return this.exPara;
    }

    public void setExPara(ExPara exPara) {
        this.exPara = exPara;
    }

    @Column(name = "COST", nullable = false, precision = 22, scale = 2)
    public BigDecimal getCost() {
        return this.cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Column(name = "ENABLED", nullable = false, precision = 22, scale = 0)
    public BigDecimal getEnabled() {
        return this.enabled;
    }

    public void setEnabled(BigDecimal enabled) {
        this.enabled = enabled;
    }

    @Column(name = "QUANTITY", nullable = false, precision = 22, scale = 0)
    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    
    
    
    @Column(name = "PARTICIPATION", precision = 22, scale = 0)
    public BigDecimal getParticipation() {
        return participation;
    }

    public void setParticipation(BigDecimal participation) {
        this.participation = participation;
    }
    
    

    @Transient
    public BigDecimal getTotalCost() {
        //return new BigDecimal(cost.doubleValue() * quantity.doubleValue());
        return new BigDecimal(getParticipationPrice().doubleValue() * getQuantity().doubleValue());
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
    
    
    @Transient
    public BigDecimal getParticipationPrice() {       
        return new BigDecimal(getCost().doubleValue()- getCost().doubleValue()*getParticipation().doubleValue()) ;        
    }

    public void setParticipationPrice(BigDecimal participationPrice) {
        this.participationPrice = participationPrice;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ExParaExams)) {
            return false;
        }

        ExParaExams compare = (ExParaExams) obj;
        
        if (paraexamid==null)
            return compare.exExam.equals(this.exExam); 
        else {
            return compare.paraexamid.equals(this.paraexamid);
        }
    }

    @Override
    public int hashCode() {
        return paraexamid != null ? this.getClass().hashCode() + paraexamid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "ExParaExams{" + "id=" + paraexamid + ", exam=" + exExam + '}';
    }
}