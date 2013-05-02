/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.model;

import com.hosp.dao.ExParaDAO;
import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExPara;
import com.hosp.entities.ExPeriod;
import com.hosp.entities.ExType;
import com.hosp.entities.Hospital;
import com.hosp.entities.Patients;
import com.hosp.entities.Users;
import com.hosp.sort.LazyParaSorter;
import com.hosp.sort.LazySorter;
import java.util.Collections;
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
@ManagedBean(name = "lazyParaDataModel")
@ViewScoped
public class LazyParaDataModel extends LazyDataModel<ExPara> {

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
    private Hospital hospital;
    private List<ExPara> paras;
    private boolean proceedFetch;
    private int start;
    private int end;

    public void loadParams(ExAssertion searchByAssertion, ExType searchByType, ExPeriod searchByPeriod,
            Patients searchByPatient, Date searchFromExecutionDate, Date searchToExecutionDate, Date searchFromIssueDate,
            Date searchToIssueDate, Users searchByUser, String serachByParaCode, Hospital hospital, boolean proceedFetch) {
        this.searchByAssertion = searchByAssertion;
        this.searchByType = searchByType;
        this.searchByPeriod = searchByPeriod;
        this.searchByPatient = searchByPatient;
        this.searchFromExecutionDate = searchFromExecutionDate;
        this.searchToExecutionDate = searchToExecutionDate;
        this.searchFromIssueDate = searchFromIssueDate;
        this.searchToIssueDate = searchToIssueDate;
        this.searchByUser = searchByUser;
        this.serachByParaCode = serachByParaCode;
        this.hospital = hospital;
        this.proceedFetch = proceedFetch;
    }

    @Override
    public List<ExPara> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        try {
            if (proceedFetch) {
                int start = first;
                int end = first + pageSize;
//            System.out.println("---------------------------------------------------------------------------");
//            System.out.println("first=" + first);
//            System.out.println("pagesize=" + pageSize);
//            System.out.println("sortOrder=" + sortOrder);
//            System.out.println("sortField=" + sortField);
//            System.out.println("start=" + first);
//            System.out.println("end=" + end);
//            System.out.println("---------------------------------------------------------------------------");
//            setStart(first);
//            setEnd(end);

                int[] querydata = {start, pageSize};

                String orderBy = null;
                if (sortField != null) {
                    String ordering = SortOrder.ASCENDING.equals(sortOrder) ? "ASC" : "DESC";
                    if (sortField.equals("exAssertion") || sortField.equals("exAssertion.exPeriod")) {
                        orderBy = " order by para.exAssertion.exPeriod.exYear.yearid " + ordering + " , para.exAssertion.exPeriod.exMonth.monthid " + ordering;
                    } else if (sortField.equals("patients")) {
                        orderBy = " order by para.patients.surname " + ordering + " ,  para.patients.name " + ordering;
                    } else if (sortField.equals("users")) {
                        orderBy = " order by para.users.surname " + ordering + " ,  para.users.name " + ordering;
                    } else if (sortField.equals("exType")) {
                        orderBy = " order by para.exType.name " + ordering;
                    } else {
                        if (!sortField.equals("valid")) {
                            orderBy = " order by para." + sortField + " " + ordering;
                        }
                    }
                }

                ExParaDAO dao = new ExParaDAO();
                List<ExPara> data = dao.getSearchParaResultSet(hospital, searchByAssertion, searchByPeriod, searchByType, searchFromExecutionDate,
                        searchToExecutionDate, searchFromIssueDate, searchToIssueDate, serachByParaCode, searchByPatient, orderBy, querydata);


                this.setRowCount(new Integer(dao.getSearchParaResultSet(hospital, searchByAssertion, searchByPeriod, searchByType, searchFromExecutionDate,
                        searchToExecutionDate, searchFromIssueDate, searchToIssueDate, serachByParaCode, searchByPatient).toString()));

               
                if (sortField!=null && sortField.equals("valid")) {
                    LazyParaSorter sorter = new LazyParaSorter(sortField, sortOrder);                                                                                                    
                    Collections.sort(data, sorter);                      
                }


//            System.out.println("ToTAL ROW COUNT=" + this.getRowCount());
//            System.out.println("PARTIAL ROW COUNT=" + data.size());
                this.paras = data;
                
            }
            return paras;
        } catch (RuntimeException ex) {
            throw ex;
            
        }


    }

//    @Override
//    public ExPara getRowData(String paraid) {
//        System.out.println("GET ROW DATA!!!!!!!!!!!!!!!!  for="+paraid);
//        for (ExPara pr : paras) {
//            if(paraid.equals(pr.getParpapemptikoid().toString())){
//                return pr;
//            }
//        }
//
//        return null;
//    }
//    
//    
//    @Override
//    public String getRowKey(ExPara para) {
//        System.out.println("GET ROW KEY!!!!!!!!!!!!!!!!  for="+para);
//        return para.getParpapemptikoid().toString();
//    }
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
