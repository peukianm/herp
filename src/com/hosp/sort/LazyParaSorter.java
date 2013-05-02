package com.hosp.sort;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExPara;
import com.hosp.entities.ExPeriod;
import com.hosp.entities.Patients;
import com.hosp.entities.Users;
import java.lang.reflect.Field;

public class LazyParaSorter implements Comparator<ExPara> {

    private String sortField;
    private SortOrder sortOrder;

    public LazyParaSorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(ExPara para1, ExPara para2) {
        try {            
            Object value1 = null;
            Object value2 = null;
            try {
                Field f1 = ExPara.class.getDeclaredField(this.sortField);                 
                f1.setAccessible(true);
                
                //value1 = f1.get(para1);
                //value2 = f1.get(para2);
                
                value1 = para1.getValid();
                value2 = para2.getValid();
                
             
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
            int value = 0;

            
            if (sortField.equals("exAssertion")) {
                value = sortPeriod(para1.getExAssertion().getExPeriod(),para2.getExAssertion().getExPeriod());
                
            } else if (sortField.equals("exAssertion.exPeriod")) {
                value = sortPeriod(para1.getExAssertion().getExPeriod(),para2.getExAssertion().getExPeriod());
            
            } else if (sortField.equals("patients")) {
                value = sortPerson(para1.getPatients(), para2.getPatients());
            
            } else if (sortField.equals("users")) {
                value = sortPerson(para1.getUsers(), para2.getUsers());
            
            } else {
                value = ((Comparable) value1).compareTo(value2);
            }
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public int sortPeriod(Object obj1, Object obj2) {        
        int value = 0;
        if (obj1 == null || obj2 == null) {
            return value;
        }
        ExPeriod period1 = ((ExPeriod) obj1);
        ExPeriod period2 = ((ExPeriod) obj2);

        if (period1 == null || period2 == null) {
            return value;
        }

        if (period1.getExYear().getYearid().intValue() > period2.getExYear().getYearid().intValue()) {
            value = 1;
            //return value;
        } else if (period1.getExYear().getYearid().intValue() < period2.getExYear().getYearid().intValue()) {
            value = -1;
            //return value;
        } else if (period1.getExYear().getYearid().intValue() == period2.getExYear().getYearid().intValue()) {

            if (period1.getExMonth().getMonthid().intValue() > period2.getExMonth().getMonthid().intValue()) {
                value = 1;
                //return value;
            }

            if (period1.getExMonth().getMonthid().intValue() < period2.getExMonth().getMonthid().intValue()) {
                value = -1;
                //return value;
            }

            if (period1.getExMonth().getMonthid().intValue() == period2.getExMonth().getMonthid().intValue()) {
                value = 0;
                //return value;
            }
        }
        return value;
    }
    
    
     public int sortPerson(Object obj1, Object obj2) {
        int value = 0;
        if (obj1 == null || obj2 == null) {
            return value;
        }
        
        String name1="";
        String name2="";
        String surname1="";
        String surname2="";
        
        if (obj1 instanceof Users) {
            name1 = ((Users)obj1).getName();
            surname1 = ((Users)obj1).getSurname();
            name2 = ((Users)obj2).getName();
            surname2 = ((Users)obj2).getSurname();
        }
        if (obj1 instanceof Patients) {
            name1 = ((Patients)obj1).getName();
            surname1 = ((Patients)obj1).getSurname();
            name2 = ((Patients)obj2).getName();
            surname2 = ((Patients)obj2).getSurname();
        }
        
        value = ((Comparable) surname1).compareTo(surname2);
        
        if (value==0){
            value = ((Comparable)name1).compareTo(name2);
        }
        
        return value;
    }
    
}
