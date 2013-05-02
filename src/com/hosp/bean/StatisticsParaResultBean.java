package com.hosp.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExExam;
import com.hosp.entities.ExParaExams;
import javax.annotation.PreDestroy;

@ManagedBean(name = "statisticsParaResultBean")
@ViewScoped
public class StatisticsParaResultBean implements Serializable {

    private static final long serialVersionUID = -8920113052182166987L;

    public ExExam exam;
    public BigDecimal amount;
    public BigDecimal netAmount;   
    public BigDecimal countExams;

    public StatisticsParaResultBean(ExExam exam, BigDecimal countExams) {
        this.exam = exam;
        this.countExams = countExams;
    }   
    
     public StatisticsParaResultBean(ExExam exam, BigDecimal countExams, BigDecimal amount, BigDecimal netAmount) {
        this.exam = exam;
        this.countExams = countExams;
        this.amount = amount;
        this.netAmount = netAmount;
    }

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void reset() {
       exam = null;
       amount = null;
       netAmount = null;   
       countExams = null;
    }

        public ExExam getExam() {
        return exam;
    }

    public void setExam(ExExam exam) {
        this.exam = exam;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getCountExams() {
        return countExams;
    }

    public void setCountExams(BigDecimal countExams) {
        this.countExams = countExams;
    }
     

    @Override
    public String toString() {
        return "Exam="+ exam+"count="+countExams;
    }
}
