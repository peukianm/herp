/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.bean;

import com.hosp.dao.ExAssertionDAO;
import com.hosp.dao.ExPeriodDAO;
import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExExam;
import com.hosp.entities.ExPara;
import com.hosp.entities.ExParaExams;
import com.hosp.entities.ExPeriod;
import com.hosp.entities.ExType;
import com.hosp.entities.Patients;
import com.hosp.entities.Users;
import com.hosp.model.LazyParaDataModel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "searchParaBean")
@ViewScoped
public class SearchParaBean implements Serializable {

    private ExAssertion searchByAssertion;
    private ExType searchByType;
    private ExPeriod searchByPeriod;
    private Patients searchByPatient;
    private Date searchFromExecutionDate;
    private Date searchToExecutionDate;
    private Date searchFromIssueDate;
    private Date searchToIssueDate;
    private Users searchByUser;
    private String serachByParaCode;
    private ExExam searchByExam = null;
   
    private List<ExAssertion> assertions;    
    private List<ExPeriod> periods;
//    
//    @ManagedProperty(value = "#{lazyParaDataModel}")
//    private transient LazyDataModel<ExPara> paraModel;
    @ManagedProperty(value = "#{lazyParaDataModel}")
    private LazyParaDataModel paraModel;
    private List<ExPara> paras;
    private ExPara selectedPara;
    private AssertionSearchResultBean assertionData;
    private ParaSearchResultBean paraData;

   
    private Patients selectedSurnamePatient;
    private Patients selectedAmkaPatient;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    private boolean processSearch = false;
    private ExPara currentPara;
    
    private List<StatisticsParaResultBean> statisticsData;
    private StatisticsParaResultBean selectedStatisticParaResult;
    private ExExam selectedExamByName;
    
    
    @PostConstruct
    public void init() {        
        try {
            assertions = (new ExAssertionDAO()).getAssertions(sessionBean.getUsers().getHospital(), true, false);            
            periods = (new ExPeriodDAO()).fetchPeriods(sessionBean.getUsers().getHospital(), Boolean.TRUE);
            if (sessionBean.getUsers().getRole().getRoleid().intValue() == 8) {                
                setSearchFromExecutionDate(new Date());
                setSearchToExecutionDate(new Date());
            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw ex;

        }
    }

   

    @PreDestroy
    public void reset() {        
        searchByAssertion = null;
        searchByType = null;
        searchByPeriod = null;
        searchByPatient = null;
        searchByUser = null;
        serachByParaCode = null;

        searchFromExecutionDate = null;
        searchToExecutionDate = null;
        searchFromIssueDate = null;
        searchToIssueDate = null;
        
        searchByExam = null;

//        paraModel = null;
        paras = null;
        selectedPara = null;
        assertionData = null;

        selectedSurnamePatient = null;
        selectedAmkaPatient = null;
        processSearch = false;
        paraData = null;
        currentPara = null;
        
        statisticsData = null;
        selectedStatisticParaResult = null;
        selectedExamByName = null;
    }

    
    
    public ExExam getSelectedExamByName() {
        return selectedExamByName;
    }

    public void setSelectedExamByName(ExExam selectedExamByName) {
        this.selectedExamByName = selectedExamByName;
    }
    
    
    public StatisticsParaResultBean getSelectedStatisticParaResult() {
        return selectedStatisticParaResult;
    }

    public void setSelectedStatisticParaResult(StatisticsParaResultBean selectedStatisticParaResult) {
        this.selectedStatisticParaResult = selectedStatisticParaResult;
    }
    
    public ExPara getCurrentPara() {
        return currentPara;
    }

    public void setCurrentPara(ExPara currentPara) {
        this.currentPara = currentPara;
    }
    
    public boolean isProcessSearch() {
        return processSearch;
    }

    public void setProcessSearch(boolean processSearch) {
        this.processSearch = processSearch;
    }

    public Patients getSelectedSurnamePatient() {
        return selectedSurnamePatient;
    }

    public void setSelectedSurnamePatient(Patients selectedSurnamePatient) {
        this.selectedSurnamePatient = selectedSurnamePatient;
    }

    public Patients getSelectedAmkaPatient() {
        return selectedAmkaPatient;
    }

    public void setSelectedAmkaPatient(Patients selectedAmkaPatient) {
        this.selectedAmkaPatient = selectedAmkaPatient;
    }

    public AssertionSearchResultBean getAssertionData() {
        return assertionData;
    }

    public void setAssertionData(AssertionSearchResultBean assertionData) {
        this.assertionData = assertionData;
    }

    public LazyParaDataModel getParaModel() {
        return paraModel;
    }

    public void setParaModel(LazyParaDataModel paraModel) {
        this.paraModel = paraModel;
    }

    public void searchParaAction() {

        setProcessSearch(true);
        paraModel.loadParams(searchByAssertion, searchByType, searchByPeriod, searchByPatient, searchFromExecutionDate,
                searchToExecutionDate, searchFromIssueDate, searchToIssueDate, searchByUser, serachByParaCode, sessionBean.getUsers().getHospital(), processSearch);



        //            setProcessSearch(true);
//            
//            setParaModel(new LazyParaDataModel(getSearchByAssertion(), getSearchByType(), getSearchByPeriod(),
//                    getSearchByPatient(), getSearchFromExecutionDate(), getSearchToExecutionDate(), getSearchFromIssueDate(),
//                    getSearchToIssueDate(), getSearchByUser(), getSerachByParaCode(), sessionBean.getUsers().getHospital(), true));

        //getParaModel();


//             if (paras.size()>=1500) {
//                  sessionBean.setAlertMessage(MessageBundleLoader.getMessage("manySearchResults"));
//                  FacesUtils.callRequestContext("alertMessageDialog.show()");
//                  FacesUtils.updateHTMLComponnetWIthJS("primeAlertPanel");
//             }



    }

//    public LazyDataModel<ExPara> getParaModel() {
//        if (paraModel == null) {
////            paraModel = new LazyParaDataModel(searchByAssertion, searchByType, searchByPeriod, searchByPatient, searchFromExecutionDate, 
////                    searchToExecutionDate, searchFromIssueDate, searchToIssueDate, searchByUser, serachByParaCode, sessionBean.getUsers().getHospital(), processSearch);
//            
////                  LazyParaDataModel model =  FacesUtils.getManagedBeanJSF2("lazyParaDataModel");
//                   
//                  
//            
////                    model.loadParams(searchByAssertion, searchByType, searchByPeriod, searchByPatient, searchFromExecutionDate, 
////                    searchToExecutionDate, searchFromIssueDate, searchToIssueDate, searchByUser, serachByParaCode, sessionBean.getUsers().getHospital(), true);
////                   paraModel = model;
//                   
//                   
//        }        
//        return paraModel;
//    }
//
//    public void setParaModel(LazyDataModel<ExPara> paraModel) {
//        this.paraModel = paraModel;
//    }
    public List<ExPara> getParas() {
        return paras;
    }

    public void setParas(List<ExPara> paras) {
        this.paras = paras;
    }

    public ExPara getSelectedPara() {
        return selectedPara;
    }

    public void setSelectedPara(ExPara selectedPara) {
        this.selectedPara = selectedPara;
    }

    public ExAssertion getSearchByAssertion() {
        return searchByAssertion;
    }

    public void setSearchByAssertion(ExAssertion searchByAssertion) {
        this.searchByAssertion = searchByAssertion;
    }

    public ExType getSearchByType() {
        return searchByType;
    }

    public void setSearchByType(ExType searchByType) {
        this.searchByType = searchByType;
    }

    public ExPeriod getSearchByPeriod() {
        return searchByPeriod;
    }

    public void setSearchByPeriod(ExPeriod searchByPeriod) {
        this.searchByPeriod = searchByPeriod;
    }

    public Patients getSearchByPatient() {
        return searchByPatient;
    }

    public void setSearchByPatient(Patients searchByPatient) {
        this.searchByPatient = searchByPatient;
    }

    public Users getSearchByUser() {
        return searchByUser;
    }

    public void setSearchByUser(Users searchByUser) {
        this.searchByUser = searchByUser;
    }

    public String getSerachByParaCode() {
        return serachByParaCode;
    }

    public void setSerachByParaCode(String serachByParaCode) {
        this.serachByParaCode = serachByParaCode;
    }

    public List<ExAssertion> getAssertions() {
        return assertions;
    }

    public void setAssertions(List<ExAssertion> assertions) {
        this.assertions = assertions;
    }


    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public List<ExPeriod> getPeriods() {
        return periods;
    }

    public void setPeriods(List<ExPeriod> periods) {
        this.periods = periods;
    }

    public Date getSearchFromExecutionDate() {
        return searchFromExecutionDate;
    }

    public void setSearchFromExecutionDate(Date searchFromExecutionDate) {
        this.searchFromExecutionDate = searchFromExecutionDate;
    }

    public Date getSearchToExecutionDate() {
        return searchToExecutionDate;
    }

    public void setSearchToExecutionDate(Date searchToExecutionDate) {
        this.searchToExecutionDate = searchToExecutionDate;
    }

    public Date getSearchFromIssueDate() {
        return searchFromIssueDate;
    }

    public void setSearchFromIssueDate(Date searchFromIssueDate) {
        this.searchFromIssueDate = searchFromIssueDate;
    }

    public Date getSearchToIssueDate() {
        return searchToIssueDate;
    }

    public void setSearchToIssueDate(Date searchToIssueDate) {
        this.searchToIssueDate = searchToIssueDate;
    }
    
    public ParaSearchResultBean getParaData() {
        return paraData;
    }

    public void setParaData(ParaSearchResultBean paraData) {
        this.paraData = paraData;
    }
    
     public ExExam getSearchByExam() {
        return searchByExam;
    }

    public void setSearchByExam(ExExam searchByExam) {
        this.searchByExam = searchByExam;
    }
    
    public List<StatisticsParaResultBean> getStatisticsData() {
        return statisticsData;
    }

    public void setStatisticsData(List<StatisticsParaResultBean> statisticsData) {
        this.statisticsData = statisticsData;
    }
}
