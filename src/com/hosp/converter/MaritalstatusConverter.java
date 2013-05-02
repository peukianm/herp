package com.hosp.converter;

import java.math.BigDecimal;
import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.hosp.entities.Familystatus;
import com.hosp.entities.Maritalstatus;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;

public class MaritalstatusConverter implements Converter {
    
    private PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();

    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().isEmpty()) {
            return null;
        } else {
            try {
                BigDecimal number = new BigDecimal(submittedValue);

                Maritalstatus maritalStatus = persistenceHelper.getEntityManager().find(Maritalstatus.class, number);
                return maritalStatus;


            } catch (Exception exception) {
                exception.printStackTrace();
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Family Status"));
            }
        }


    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        try {
            if (value == null || value.equals("")) {
                return "";
            } else {

                return String.valueOf(((Maritalstatus) value).getMaritalstatusid());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
