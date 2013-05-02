/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.bean;

import com.hosp.dao.BloodtypeDAO;
import com.hosp.dao.CityDAO;
import com.hosp.dao.CountryDAO;
import com.hosp.dao.ExAssertionDAO;
import com.hosp.dao.ExAssertionTypeDAO;
import com.hosp.dao.ExExamDAO;
import com.hosp.dao.ExParaTypeDAO;
import com.hosp.dao.InsuranceDAO;
import com.hosp.dao.MaritalstatusDAO;
import com.hosp.dao.NationalityDAO;
import com.hosp.dao.PrefectureDAO;
import com.hosp.dao.ProffesionDAO;
import com.hosp.dao.RelegionDAO;
import com.hosp.dao.SexDAO;
import com.hosp.entities.Bloodtype;
import com.hosp.entities.City;
import com.hosp.entities.Country;
import com.hosp.entities.ExAssertionType;
import com.hosp.entities.ExExam;
import com.hosp.entities.ExMonth;
import com.hosp.entities.ExParaType;
import com.hosp.entities.ExType;
import com.hosp.entities.ExYear;
import com.hosp.entities.Insurance;
import com.hosp.entities.Maritalstatus;
import com.hosp.entities.Nationality;
import com.hosp.entities.Prefecture;
import com.hosp.entities.Proffesion;
import com.hosp.entities.Relegion;
import com.hosp.entities.Sex;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author peukianm
 */
@ManagedBean(name = "applicationListBean")
@ApplicationScoped
public class ApplicationListBean {

    private List<Country> countries;
    private List<Insurance> insurances;
    private List<Sex> sexes;
    private List<Prefecture> prefectures;
    private List<Proffesion> proffesions;
    private List<Relegion> relegions;
    private List<Nationality> nationalities;
    private List<Bloodtype> bloodTypes;
    private List<City> cities;
    private List<Maritalstatus> maritalStatuses;
    private List<ExType> types;
    private List<ExMonth> months;
    private List<ExYear> years;
    private List<ExAssertionType> assertionTypes;
    private List<ExExam> ctxrays;
    private List<ExExam> mt;
    private List<ExExam> us;
    private List<ExExam> bloodAnoso;
    private List<ExExam> microHormon;
    private List<ExExam> bio;
    
    public List<ExExam> getMt() {
        if (mt == null) {
            ExExamDAO dao = new ExExamDAO();
            mt = dao.fetchmts();
        }        
        return mt;
    }

    public void setMt(List<ExExam> mt) {
        this.mt = mt;
    }

    public List<ExExam> getUs() {
         if (us == null) {
            ExExamDAO dao = new ExExamDAO();
            us = dao.fetchus();
        }   
        return us;
    }

    public void setUs(List<ExExam> us) {
        this.us = us;
    }

    public List<ExExam> getBloodAnoso() {
        if (bloodAnoso == null) {
            ExExamDAO dao = new ExExamDAO();
            bloodAnoso = dao.fetchBloodAnoso();
        }   
        return bloodAnoso;
    }

    public void setBloodAnoso(List<ExExam> bloodAnoso) {
        this.bloodAnoso = bloodAnoso;
    }

    public List<ExExam> getMicroHormon() {
         if (microHormon == null) {
            ExExamDAO dao = new ExExamDAO();
            microHormon =dao.fetchMicroHormon();
        }   
        return microHormon;
    }

    public void setMicroHormon(List<ExExam> microHormon) {
        this.microHormon = microHormon;
    }
    
    public List<ExExam> getBio() {
         if (bio == null) {
            ExExamDAO dao = new ExExamDAO();
            bio =dao.fetchBio();
        }   
        return bio;
    }

    public void setBio(List<ExExam> bio) {
        this.bio = bio;
    }
    
    
    
    public List<ExExam> getCtxrays() {
        if (ctxrays == null) {
            ExExamDAO dao = new ExExamDAO();
            ctxrays = dao.fetchctxrays();
        }
        return ctxrays;
    }

    public void setCtxrays(List<ExExam> ctxrays) {
        this.ctxrays = ctxrays;
    }
    
    
    public List<ExMonth> getMonths() {
        if (months == null) {
            ExAssertionTypeDAO dao1 = new ExAssertionTypeDAO();
            months = dao1.fetchMonths();
        }
        return months;
    }

    public void setMonths(List<ExMonth> months) {
        this.months = months;
    }

    public List<ExYear> getYears() {
        if (years == null) {
            ExAssertionTypeDAO dao1 = new ExAssertionTypeDAO();;
            years = dao1.fetchYears();
        }
        return years;
    }

    public void setYears(List<ExYear> years) {
        this.years = years;
    }

    public List<ExAssertionType> getAssertionTypes() {
        if (assertionTypes == null) {
            ExAssertionTypeDAO dao1 = new ExAssertionTypeDAO();
            assertionTypes = dao1.findAssertionTypes();
        }
        return assertionTypes;
    }

    public void setAssertionTypes(List<ExAssertionType> assertionTypes) {
        this.assertionTypes = assertionTypes;
    }

    public List<ExType> getTypes() {
        if (types == null) {
            types = (new ExAssertionDAO()).findAllDateTypes();
        }
        return types;
    }

    public void setTypes(List<ExType> types) {
        this.types = types;
    }

    public List<ExParaType> getParaTypes() {       
        if (paraTypes == null) {
            paraTypes = (new ExParaTypeDAO()).fetchParaTypes(true);            
        }
        return paraTypes;
    }

    public void setParaTypes(List<ExParaType> paraTypes) {
        this.paraTypes = paraTypes;
    }
    private List<ExParaType> paraTypes;

    public List<Country> getCountries() {        
        if (countries == null) {            
            countries = (new CountryDAO()).fetchCountries();
        }
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Insurance> getInsurances() {
        if (insurances == null) {
            insurances = (new InsuranceDAO()).getInsurances();
        }
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public List<Sex> getSexes() {
        if (sexes == null) {
            sexes = (new SexDAO().findAll());
        }
        return sexes;
    }

    public void setSexes(List<Sex> sexes) {
        this.sexes = sexes;
    }

    public List<Prefecture> getPrefectures() {
        if (prefectures == null) {
            prefectures = (new PrefectureDAO().findAll());
        }
        return prefectures;
    }

    public void setPrefectures(List<Prefecture> prefectures) {
        this.prefectures = prefectures;
    }

    public List<Proffesion> getProffesions() {
        if (proffesions == null) {
            proffesions = new ProffesionDAO().findAll();
        }
        return proffesions;
    }

    public void setProffesions(List<Proffesion> proffesions) {
        this.proffesions = proffesions;
    }

    public List<Relegion> getRelegions() {
        if (relegions == null) {
            relegions = new RelegionDAO().findAll();
        }
        return relegions;
    }

    public void setRelegions(List<Relegion> relegions) {
        this.relegions = relegions;
    }

    public List<Nationality> getNationalities() {
        if (nationalities == null) {
            nationalities = new NationalityDAO().findAll();
        }
        return nationalities;
    }

    public void setNationalities(List<Nationality> nationalities) {
        this.nationalities = nationalities;
    }

    public List<Bloodtype> getBloodTypes() {
        if (bloodTypes == null) {
            bloodTypes = new BloodtypeDAO().findAll();
        }
        return bloodTypes;
    }

    public void setBloodTypes(List<Bloodtype> bloodTypes) {
        this.bloodTypes = bloodTypes;
    }

    public List<City> getCities() {
        if (cities == null) {
            cities = new CityDAO().findAll();
        }
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Maritalstatus> getMaritalStatuses() {
        if (maritalStatuses == null) {
            maritalStatuses = new MaritalstatusDAO().findAll();
        }
        return maritalStatuses;
    }

    public void setMaritalStatuses(List<Maritalstatus> maritalStatuses) {
        this.maritalStatuses = maritalStatuses;
    }
}
