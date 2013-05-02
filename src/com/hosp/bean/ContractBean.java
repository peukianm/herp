package com.hosp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.hosp.dao.ExContractDAO;
import com.hosp.entities.ExContract;
import javax.annotation.PreDestroy;

@ManagedBean(name = "contractBean")
@ViewScoped
public class ContractBean implements Serializable {

    private static final Logger logger = Logger.getLogger(ContractBean.class);
    List<ExContract> contracts;
    ExContract selectedContract;
    
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    @PostConstruct
    public void init() {
        try {
            ExContractDAO dao = new ExContractDAO();
            List<ExContract> contracts = dao.fetchContract(sessionBean.getUsers().getHospital());
            setContracts(contracts);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @PreDestroy
    public void reset() {
        contracts = null;
        selectedContract = null;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public ExContract getSelectedContract() {
        return selectedContract;
    }

    public void setSelectedContract(ExContract selectedContract) {
        this.selectedContract = selectedContract;
    }

    public List<ExContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<ExContract> contracts) {
        this.contracts = contracts;
    }
}
