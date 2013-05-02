/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.model;

import com.hosp.dao.ExParaDAO;
import com.hosp.dao.PatientsDAO;
import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExPara;
import com.hosp.entities.ExPeriod;
import com.hosp.entities.ExType;
import com.hosp.entities.Hospital;
import com.hosp.entities.Insurance;
import com.hosp.entities.Patients;
import com.hosp.entities.Users;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author peukianm
 */
@ManagedBean(name = "lazyPatientDataModel")
@ViewScoped
public class LazyPatientDataModel extends LazyDataModel<Patients> {

    
    private Date searchFromBirthDate;
    private Date searchToBirthDate;
    
    private String searchByName;
    private String searchBySurname;
    private String searchByAmka;
    private Insurance searchByInsurance;
    
    private List<Patients> patients;
    private boolean proceedFetch;
    private int start;
    private int end;

    public void loadParams(String searchByName, String searchBySurname, String searchByAmka,
            Date searchFromBirthDate, Date searchToBirthDate,
            Insurance searchByInsurance, boolean proceedFetch) {
        
        this.searchFromBirthDate = searchFromBirthDate;
        this.searchToBirthDate = searchToBirthDate;
        this.searchByAmka = searchByAmka;
        this.searchByName  =searchByName;
        this.searchBySurname = searchBySurname;
        this.searchByInsurance = searchByInsurance;
        
        this.proceedFetch = proceedFetch;
    }

    @Override
    public List<Patients> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        try {
            if (proceedFetch) {
                int start = first;
                int end = first + pageSize;
                int[] querydata = {start, pageSize};

                String orderBy = null;
                if (sortField != null) {
                    String ordering = SortOrder.ASCENDING.equals(sortOrder) ? "ASC" : "DESC";
                    if (sortField.equals("insurance") ) {
                        orderBy = " order by patient.insurance.name " + ordering ;                    
                    } else {
                        orderBy = " order by patient." + sortField + " " + ordering;
                    }

                }

                PatientsDAO dao = new PatientsDAO();
                List<Patients> data = dao.getSearchPatientResultSet(searchByName, searchBySurname, searchByAmka,
                        searchFromBirthDate, searchToBirthDate, searchByInsurance,  orderBy, querydata);


                this.setRowCount(new Integer(dao.getSearchPatientResultSet(searchByName, searchBySurname, searchByAmka,
                        searchFromBirthDate, searchToBirthDate,searchByInsurance).toString()));

                this.patients = data;
                
            }
            return patients;
        } catch (RuntimeException ex) {
            throw ex;
            
        }


    }


    @Override
    public void setRowIndex(int rowIndex) {
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }

    @Override
    public int getRowIndex() {
        return super.getRowIndex() + start + 1;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
