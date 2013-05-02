package com.hosp.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.hosp.entities.ExAssertion;
import javax.annotation.PreDestroy;

@ManagedBean(name = "assertionSearchResultBean")
@ViewScoped
public class AssertionSearchResultBean implements Serializable {
   
    private static final long serialVersionUID = -8920113052182166987L;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    public ExAssertion assertion;
    public BigDecimal amount;
    public BigDecimal netAmount;   
    public Long countPara;
    public BigDecimal countExams;

    public AssertionSearchResultBean(BigDecimal amount, Long countPara, BigDecimal countExams, ExAssertion assertion) {
        this.amount = amount;
        this.assertion = assertion;
        this.countPara = countPara;
        this.countExams = countExams;        
    }
    
     public AssertionSearchResultBean(BigDecimal amount, Long countPara, BigDecimal countExams, ExAssertion assertion, BigDecimal netAmount) {
        this.amount = amount;
        this.assertion = assertion;
        this.countPara = countPara;
        this.countExams = countExams;
        this.netAmount = netAmount;
    }

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void reset() {
        assertion = null;
        amount = null;
        countPara = null;
        countExams = null;
        netAmount = null;
    }

    
     public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }
    
    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public ExAssertion getAssertion() {
        return assertion;
    }

    public void setAssertion(ExAssertion assertion) {
        this.assertion = assertion;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getCountPara() {
        return countPara;
    }

    public void setCountPara(Long countPara) {
        this.countPara = countPara;
    }

    public BigDecimal getCountExams() {
        return countExams;
    }

    public void setCountExams(BigDecimal countExams) {
        this.countExams = countExams;
    }

    @Override
    public String toString() {
        return "Assertion=" + assertion + " paras=" + countPara + " paraexams=" + countExams + " amount=" + amount;
    }
}
