package com.hosp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;



@ManagedBean(name="invoiceBean")
@ViewScoped
public class InvoiceBean implements Serializable {
	
	@ManagedProperty(value="#{sessionBean}") 
	private SessionBean sessionBean;
	
	
	@ManagedProperty(value="#{assertionBean.selectedResult}")
	private AssertionSearchResultBean selectedAssertionResult;
	
	
	@ManagedProperty(value="#{sessionBean.parameter}")
	private AssertionSearchResultBean temp;
	
	
	@PostConstruct   
	 public void init() {
		 		 
	 }



	public SessionBean getSessionBean() {
		return sessionBean;
	}



	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}



	public AssertionSearchResultBean getSelectedAssertionResult() {
		return selectedAssertionResult;
	}



	public void setSelectedAssertionResult(AssertionSearchResultBean selectedAssertionResult) {
		this.selectedAssertionResult = selectedAssertionResult;
	}



	public AssertionSearchResultBean getTemp() {
		return temp;
	}



	public void setTemp(AssertionSearchResultBean temp) {
		this.temp = temp;
	}

}
