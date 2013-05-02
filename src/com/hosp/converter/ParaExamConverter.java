package com.hosp.converter;

import com.hosp.bean.ParaBean;
import java.math.BigDecimal;
import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExParaExams;
import com.hosp.util.EJBUtil;
import com.hosp.util.FacesUtils;
import com.hosp.util.PersistenceHelper;

public class ParaExamConverter implements Converter {

    private PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();

    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {        
        if (submittedValue.trim().isEmpty()) {
            return null;
        } else {
            try {
                
                BigDecimal number = new BigDecimal(submittedValue);
                
                ParaBean paraBean = (ParaBean) FacesUtils.getManagedBean("paraBean");
                for (ExParaExams p : paraBean.getTempExParaExams()) {  
                    if (p.getParaexamid()!=null) {                        
                        return persistenceHelper.getEntityManager().find(ExParaExams.class, number);
                    } else {
                        if (p.getExExam().getExamid().equals(number)) {  
                            return p;  
                        }
                    }
                }                                  
            } catch (Exception exception) {
                exception.printStackTrace();
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Month"));
            }
        }
        return null;


    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        try {
            if (value == null || value.equals("")) {
                return "";
            } else {                
                if (((ExParaExams)value).getParaexamid() == null   )
                    return String.valueOf(((ExParaExams) value).getExExam().getExamid()  );
                else
                    return String.valueOf(((ExParaExams) value).getParaexamid()  );                            
                            
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
