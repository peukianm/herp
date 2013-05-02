package com.hosp.sort;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import com.hosp.bean.AssertionSearchResultBean;
import com.hosp.entities.ExAssertion;


public class LazySorter implements Comparator<AssertionSearchResultBean>  {
	 private String sortField;
	    
	    private SortOrder sortOrder;
	    
	    public LazySorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    public int compare(AssertionSearchResultBean assertion1, AssertionSearchResultBean assertion2) {
	        try {
	            Object value1 = AssertionSearchResultBean.class.getField(this.sortField).get(assertion1);
	            Object value2 = AssertionSearchResultBean.class.getField(this.sortField).get(assertion2);
	            
	            int value = 0;
	            if (sortField.equals("assertion")) {	            	
	            	
	            	if ( ((ExAssertion)value1).getExPeriod().getExYear().getYearid().equals(((ExAssertion)value2).getExPeriod().getExYear().getYearid())){
	            		
	            		if ( ((ExAssertion)value1).getExPeriod().getExMonth().getMonthid().intValue()<((ExAssertion)value2).getExPeriod().getExMonth().getMonthid().intValue() ) {
	            			value = -1;
	            		} else if ( ((ExAssertion)value1).getExPeriod().getExMonth().getMonthid().intValue()<((ExAssertion)value2).getExPeriod().getExMonth().getMonthid().intValue() ) {
	            			value = 1;
	            		} else {
	            			value = 0;
	            		}
	            		
	            		
	            	} else if ( ((ExAssertion)value1).getExPeriod().getExYear().getYearid().intValue()<((ExAssertion)value2).getExPeriod().getExYear().getYearid().intValue() ) {
	            		value = -1;
	            	
	            	} else if ( ((ExAssertion)value1).getExPeriod().getExYear().getYearid().intValue()>((ExAssertion)value2).getExPeriod().getExYear().getYearid().intValue() ) {
	            		value = 1;	            	
	            	}
	            	
	            	
	            	
	            	//value = ((ExAssertion)value1).getAssertionid().compareTo(((ExAssertion)value2).getAssertionid());	            		            	
	            	//value = ((Comparable)value1).compareTo(value2);
	            } else {
	            	value = ((Comparable)value1).compareTo(value2);
	            }
	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	            throw new RuntimeException();
	        }
	    }
		
}
