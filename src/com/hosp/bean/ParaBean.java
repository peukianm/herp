package com.hosp.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import com.hosp.dao.ExAssertionDAO;
import com.hosp.entities.Country;
import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExExam;
import com.hosp.entities.ExPara;
import com.hosp.entities.ExParaExams;
import com.hosp.entities.Patients;
import com.hosp.util.FacesUtils;
import com.hosp.ws.ExamPrescription;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PreDestroy;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "paraBean")
@ViewScoped
public class ParaBean implements Serializable {

    private static final Logger logger = Logger.getLogger(ParaBean.class);
    private static final long serialVersionUID = 1L;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    
    private ExPara newPara = new ExPara();
    private List<ExAssertion> assertions;
    private String patientName;
    private String patientSurname;
    private String patientAmka;
    private String tempAmka;
    private ExParaExams selectedParaExamByCode;
    private ExParaExams selectedParaExamByName;
    private List<ExParaExams> paraExams = new ArrayList<ExParaExams>();
    private transient DataModel<ExParaExams> paraExamsModel;
    private List<ExParaExams> tempExParaExams = new ArrayList<ExParaExams>();
    private String ikaCode;
    private Patients selectedPatient = new Patients();
    private Patients selectedPatientByAmka;
    private Patients selectedPatientBySurname;
    
    private Map<ExExam, Boolean> selectedExams = new HashMap<ExExam, Boolean>();
    
    private ExamPrescription examPrescription;
   
    @PostConstruct
    public void init() {        
        try {
            if (sessionBean.getParameter() != null && sessionBean.getParameter() instanceof ExPara) {
                assertions = (new ExAssertionDAO()).getAssertions(sessionBean.getUsers().getHospital(), true, false);
                newPara = (ExPara) sessionBean.getParameter();
                selectedPatient = new Patients();
                //sessionBean.setParameter(null);

                paraExams = newPara.getExParaExamses();
                setPatientAmka(newPara.getPatients().getAmka());
                setPatientName(newPara.getPatients().getName());
                setPatientSurname(newPara.getPatients().getSurname());
                if (newPara.getPatients().getInsurance().getInsuranceid().intValue()==1) {
                    setIkaCode(newPara.getPatients().getInsurancenumber());
                } else {
                    setIkaCode("-");
                }    


            } else {
                
                assertions = (new ExAssertionDAO()).getAssertions(sessionBean.getUsers().getHospital(), true, true);                               
                newPara = new ExPara();
                newPara.setHospital(sessionBean.getUsers().getHospital());
                newPara.setExecutiondate(new Date());
                newPara.setCodehealthunit(sessionBean.getUsers().getHospital().getHunitcode());
                newPara.setDoctorcode("-");
                newPara.setUsers(sessionBean.getUsers());
                
                
                //newPara.setExTameio(sessionBean.getTameio());

                if (sessionBean.getCurrentNormalAssertion() != null) {
                    newPara.setExAssertion(sessionBean.getCurrentNormalAssertion());
                    newPara.setExPeriod(sessionBean.getCurrentNormalAssertion().getExPeriod());
                    newPara.setExContract(sessionBean.getCurrentNormalAssertion().getExContract());
                } else {
                    ExAssertion assertion = (new ExAssertionDAO()).getSingleAssertion(sessionBean.getUsers().getHospital(), true, true);                    
                    newPara.setExAssertion(assertion);
                    newPara.setExPeriod(assertion.getExPeriod());
                    newPara.setExContract(assertion.getExContract());
                }

                selectedPatient = new Patients();

            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw ex;

        }
    }

    //PreDestroy
    public void reset() {
        newPara = new ExPara();
        assertions = null;
        paraExams = new ArrayList<ExParaExams>();
        patientName = null;
        patientSurname = null;
        patientAmka = null;
        tempAmka = null;
        ikaCode = null;
        selectedPatient = new Patients();
        selectedPatientByAmka = null;
        selectedPatientBySurname = null;
        selectedParaExamByCode = null;
        selectedParaExamByName = null;
        paraExamsModel = null;
        tempExParaExams = new ArrayList<ExParaExams>();
        selectedExams = new HashMap<ExExam, Boolean>();
        examPrescription = null;
    }

    
    
    public ExamPrescription getExamPrescription() {
        return examPrescription;
    }

    public void setExamPrescription(ExamPrescription examPrescription) {
        this.examPrescription = examPrescription;
    }
    
    public Map<ExExam, Boolean> getSelectedExams() {
        return selectedExams;
    }

    public void setSelectedExams(Map<ExExam, Boolean> selectedExams) {
        this.selectedExams = selectedExams;
    }
    
    public List<ExParaExams> getTempExParaExams() {
        return tempExParaExams;
    }

    public void setTempExParaExams(List<ExParaExams> tempExParaExams) {
        this.tempExParaExams = tempExParaExams;
    }

    public ExParaExams getSelectedParaExamByCode() {
        return selectedParaExamByCode;
    }

    public void setSelectedParaExamByCode(ExParaExams selectedParaExamByCode) {
        this.selectedParaExamByCode = selectedParaExamByCode;
    }

    public ExParaExams getSelectedParaExamByName() {
        return selectedParaExamByName;
    }

    public void setSelectedParaExamByName(ExParaExams selectedParaExamByName) {
        this.selectedParaExamByName = selectedParaExamByName;
    }

    public String getTempAmka() {
        return tempAmka;
    }

    public void setTempAmka(String tempAmka) {
        this.tempAmka = tempAmka;
    }

    public ExPara getNewPara() {
        return newPara;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public void setNewPara(ExPara newPara) {
        this.newPara = newPara;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientAmka() {
        return patientAmka;
    }

    public void setPatientAmka(String patientAmka) {
        this.patientAmka = patientAmka;
    }

    public String getIkaCode() {
        return ikaCode;
    }

    public void setIkaCode(String ikaCode) {
        this.ikaCode = ikaCode;
    }

    public Patients getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patients selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    public List<ExAssertion> getAssertions() {
        return assertions;
    }

    public void setAssertions(List<ExAssertion> assertions) {
        this.assertions = assertions;
    }

    public List<ExParaExams> getParaExams() {
        return paraExams;
    }

    public void setParaExams(List<ExParaExams> paraExams) {
        this.paraExams = paraExams;
    }

    public Patients getSelectedPatientByAmka() {
        return selectedPatientByAmka;
    }

    public void setSelectedPatientByAmka(Patients selectedPatientByAmka) {
        this.selectedPatientByAmka = selectedPatientByAmka;
    }

    public Patients getSelectedPatientBySurname() {
        return selectedPatientBySurname;
    }

    public void setSelectedPatientBySurname(Patients selectedPatientBySurname) {
        this.selectedPatientBySurname = selectedPatientBySurname;
    }

    public DataModel<ExParaExams> getParaExamsModel() {        
        if (paraExamsModel == null) {            
            paraExamsModel = new ListDataModel<ExParaExams>(paraExams);
        }
        return paraExamsModel;
    }

    public void setParaExamsModel(DataModel<ExParaExams> paraExamsModel) {
        this.paraExamsModel = paraExamsModel;
    }
}
