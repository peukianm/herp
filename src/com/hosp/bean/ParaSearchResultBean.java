package com.hosp.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.hosp.entities.ExPara;
import javax.annotation.PreDestroy;

@ManagedBean(name = "paraSearchResultBean")
@ViewScoped
public class ParaSearchResultBean implements Serializable {

    private static final long serialVersionUID = -8920113052182166987L;
    public ExPara para;

    public ExPara getPara() {
        return para;
    }

    public void setPara(ExPara para) {
        this.para = para;
    }
    public BigDecimal amount;
    public BigDecimal amountWithParticipation;
    public Long countExams;

    public ParaSearchResultBean(ExPara para, Long countExams,BigDecimal amount) {
        this.amount = amount;
        this.para = para;
        this.countExams = countExams;
    }

    
    public ParaSearchResultBean(ExPara para, Long countExams,BigDecimal amount,  BigDecimal amountWithParticipation) {
        this.amount = amount;
        this.para = para;
        this.countExams = countExams;
        this.amountWithParticipation = amountWithParticipation;
    }
    
    
    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void reset() {
        para = null;
        amount = null;
        countExams = null;
        amountWithParticipation = null;
    }

    public BigDecimal getAmountWithParticipation() {
        return amountWithParticipation;
    }

    public void setAmountWithParticipation(BigDecimal amountWithParticipation) {
        this.amountWithParticipation = amountWithParticipation;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getCountExams() {
        return countExams;
    }

    public void setCountExams(Long countExams) {
        this.countExams = countExams;
    }
}
