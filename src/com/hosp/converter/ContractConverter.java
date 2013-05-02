package com.hosp.converter;

import java.math.BigDecimal;
import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import com.hosp.entities.ExContract;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;

public class ContractConverter implements Converter {

    private PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
    
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().isEmpty()) {
            return null;
        } else {
            try {
                BigDecimal number = new BigDecimal(submittedValue);

                ExContract contract = persistenceHelper.getEntityManager().find(ExContract.class, number);
                return contract;


            } catch (Exception exception) {
                exception.printStackTrace();
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Contract"));
            }
        }


    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        try {
            if (value == null || value.equals("")) {
                return "";
            } else {

                return String.valueOf(((ExContract) value).getContractid());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
