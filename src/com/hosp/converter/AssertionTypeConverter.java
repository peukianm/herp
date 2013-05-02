package com.hosp.converter;

import java.math.BigDecimal;
import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.hosp.entities.ExAssertionType;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;

public class AssertionTypeConverter implements Converter {

    private PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();

    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().isEmpty()) {
            return null;
        } else {
            try {
                BigDecimal number = new BigDecimal(submittedValue);

                ExAssertionType assertionType = persistenceHelper.getEntityManager().find(ExAssertionType.class, number);
                return assertionType;


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

                return String.valueOf(((ExAssertionType) value).getAssertiontypeid());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
