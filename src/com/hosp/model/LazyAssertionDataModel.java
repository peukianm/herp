package com.hosp.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.hosp.bean.AssertionSearchResultBean;
import com.hosp.bean.SessionBean;
import com.hosp.dao.ExAssertionDAO;
import com.hosp.dao.UsersDAO;
import com.hosp.entities.ExAssertion;
import com.hosp.entities.Hospital;
import com.hosp.sort.LazySorter;
import com.hosp.util.FacesUtils;

public class LazyAssertionDataModel extends LazyDataModel<AssertionSearchResultBean> {

    private List<AssertionSearchResultBean> datasource;
    private Hospital hospital;

    public LazyAssertionDataModel(List<AssertionSearchResultBean> datasource) {
        this.datasource = datasource;
    }

    public LazyAssertionDataModel(Hospital hospital) {
        this.hospital = hospital;
    }

//	@Override  
//    public AssertionSearchResultBean getRowData(String assertionID) {  
//        for(AssertionSearchResultBean result : datasource) {                      	
//        	if(result.getAssertion().getAssertionid().equals(new BigDecimal(assertionID)))  
//                return result;  
//        }    
//        return null;  
//    }  
//	
//	
//	
//	
    @Override
    public ExAssertion getRowKey(AssertionSearchResultBean assertionSearchResultBean) {
        return assertionSearchResultBean.getAssertion();
    }

    @Override
    public List<AssertionSearchResultBean> load(int first, int pageSize, String sortField, org.primefaces.model.SortOrder sortOrder, Map<String, String> filters) {
        List<AssertionSearchResultBean> data = new ArrayList<AssertionSearchResultBean>();

        ExAssertionDAO dao = new ExAssertionDAO();
        int[] rowStartIdxAndCount = new int[2];
        rowStartIdxAndCount[0] = first;
        rowStartIdxAndCount[1] = pageSize;


        
        //data = dao.assertionSearchResults(hospital, rowStartIdxAndCount);
        LazySorter sorter = new LazySorter(sortField, sortOrder);

        if (sortField != null) {
            Collections.sort(data, sorter);
        }


        //rowCount  
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate  
        if (dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            } catch (IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        } else {
            return data;
        }

    }
}
