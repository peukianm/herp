package com.hosp.converter;

import java.math.BigDecimal;
import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import com.hosp.entities.ExYear;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;

public class YearConverter implements Converter {

    private PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();

    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().isEmpty()) {
            return null;
        } else {
            try {
                BigDecimal number = new BigDecimal(submittedValue);

                ExYear year = persistenceHelper.getEntityManager().find(ExYear.class, number);
                return year;


            } catch (Exception exception) {
                exception.printStackTrace();
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Month"));
            }
        }


    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        try {
            if (value == null || value.equals("")) {
                return "";
            } else {

                return String.valueOf(((ExYear) value).getYearid());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
