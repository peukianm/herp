package com.hosp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import com.hosp.dao.*;
import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExAssertionType;
import com.hosp.entities.ExMonth;
import com.hosp.entities.ExPeriod;
import com.hosp.entities.ExTimol;
import com.hosp.entities.ExYear;
import com.hosp.util.FacesUtils;
import com.hosp.util.MessageBundleLoader;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedProperty;
//import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

@ManagedBean(name = "assertionBean")
@ViewScoped
public class AssertionBean implements Serializable {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    private static final Logger logger = Logger.getLogger(AssertionBean.class);
    private SelectItem[] submissions;
    private List<ExPeriod> periods;
    private List<ExTimol> invoiceList;
    private ExPeriod period;
    private ExAssertion assertion;
    private ExTimol selectedInvoice;
    private ExAssertionType selectedAssertionType;
    private String selectedSubmissionType;
    private ExPeriod selectedPeriod;
    private ExMonth selectedMonth;
    private ExYear selectedYear;
    private ExAssertion selectedAssertion;
    private AssertionSearchResultBean selectedResult;
    private LazyDataModel<AssertionSearchResultBean> lazyModel;
    private List<AssertionSearchResultBean> assertionSearchResultBeanList;
    private ExAssertion updateAssertion;
    private ExTimol newInvoice = new ExTimol();
    private AssertionSearchResultBean currentResult;
    private String searchByOpen;
    private String showDeleted ;

    
   

    @PostConstruct
    public void init() {

        //lazyModel = new LazyAssertionDataModel(sessionBean.getUsers().getHospital()); 

        try {
            //SessionBean sessionBean = FacesUtils.getManagedBeanJSF2("sessionBean");
            searchByOpen = "1";
            showDeleted = "0" ;
            
            ExAssertionDAO dao = new ExAssertionDAO();
            setAssertionSearchResultBeanList(dao.assertionSearchResults(sessionBean.getUsers().getHospital(), searchByOpen, showDeleted,  null));

            ExPeriodDAO dao2 = new ExPeriodDAO();
            sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
            periods = dao2.fetchPeriods(sessionBean.getUsers().getHospital(), true);

//            submissions = new SelectItem[2];
//            submissions[0] = new SelectItem(MessageBundleLoader.getMessage("importData"), MessageBundleLoader.getMessage("importData"));
//            submissions[1] = new SelectItem(MessageBundleLoader.getMessage("archive"), MessageBundleLoader.getMessage("archive"));
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }

    }

    @PreDestroy
    public void reset() {
        submissions = null;
        periods = null;
        invoiceList = null;
        period = null;
        assertion = null;
        selectedInvoice = null;
        selectedAssertionType = null;
        selectedSubmissionType = null;
        selectedPeriod = null;
        selectedMonth = null;
        selectedYear = null;
        selectedAssertion = null;
        selectedResult = null;
        lazyModel = null;
        assertionSearchResultBeanList = null;
        updateAssertion = null;
        newInvoice = new ExTimol();
        currentResult = null;
        searchByOpen = null;
        showDeleted = null;

    }

//	public SessionBean getSessionBean() {
//		return sessionBean;
//	}
//
//	public void setSessionBean(SessionBean sessionBean) {
//		this.sessionBean = sessionBean;
//	}
    
    
    
    
     public String getShowDeleted() {
        return showDeleted;
    }

    public void setShowDeleted(String showDeleted) {
        this.showDeleted = showDeleted;
    }
    
    public String getSearchByOpen() {
        return searchByOpen;
    }

    public void setSearchByOpen(String searchByOpen) {
        this.searchByOpen = searchByOpen;
    }

    
    public AssertionSearchResultBean getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(AssertionSearchResultBean currentResult) {
        this.currentResult = currentResult;
    }
    
    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public SelectItem[] getSubmissions() {
        return submissions;
    }

    public void setSubmissions(SelectItem[] submissions) {
        this.submissions = submissions;
    }

    public List<ExPeriod> getPeriods() {
        return periods;
    }

    public void setPeriods(List<ExPeriod> periods) {
        this.periods = periods;
    }

    public ExPeriod getPeriod() {
        return period;
    }

    public void setPeriod(ExPeriod period) {
        this.period = period;
    }

    public ExAssertion getAssertion() {
        return assertion;
    }

    public void setAssertion(ExAssertion assertion) {
        this.assertion = assertion;
    }

    public ExAssertionType getSelectedAssertionType() {
        return selectedAssertionType;
    }

    public void setSelectedAssertionType(ExAssertionType selectedAssertionType) {
        this.selectedAssertionType = selectedAssertionType;
    }

    public String getSelectedSubmissionType() {
        return selectedSubmissionType;
    }

    public void setSelectedSubmissionType(String selectedSubmissionType) {
        this.selectedSubmissionType = selectedSubmissionType;
    }

    public ExPeriod getSelectedPeriod() {
        return selectedPeriod;
    }

    public void setSelectedPeriod(ExPeriod selectedPeriod) {
        this.selectedPeriod = selectedPeriod;
    }

    public ExMonth getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(ExMonth selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public ExYear getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(ExYear selectedYear) {
        this.selectedYear = selectedYear;
    }

    public LazyDataModel<AssertionSearchResultBean> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<AssertionSearchResultBean> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public ExAssertion getSelectedAssertion() {
        return selectedAssertion;
    }

    public void setSelectedAssertion(ExAssertion selectedAssertion) {
        this.selectedAssertion = selectedAssertion;
    }

    public AssertionSearchResultBean getSelectedResult() {
        return selectedResult;
    }

    public void setSelectedResult(AssertionSearchResultBean selectedResult) {
        this.selectedResult = selectedResult;
    }

    public List<AssertionSearchResultBean> getAssertionSearchResultBeanList() {
        return assertionSearchResultBeanList;
    }

    public void setAssertionSearchResultBeanList(List<AssertionSearchResultBean> assertionSearchResultBeanList) {
        this.assertionSearchResultBeanList = assertionSearchResultBeanList;
    }

    public List<ExTimol> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<ExTimol> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public ExTimol getSelectedInvoice() {
        return selectedInvoice;
    }

    public void setSelectedInvoice(ExTimol selectedInvoice) {
        this.selectedInvoice = selectedInvoice;
    }

    public ExTimol getNewInvoice() {
        return newInvoice;
    }

    public void setNewInvoice(ExTimol newInvoice) {
        this.newInvoice = newInvoice;
    }

    public ExAssertion getUpdateAssertion() {
        return updateAssertion;
    }

    public void setUpdateAssertion(ExAssertion updateAssertion) {
        this.updateAssertion = updateAssertion;
    }
}
