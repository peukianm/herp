package com.hosp.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.hosp.util.MessageBundleLoader;

@FacesValidator("MonthValidator")
public class MonthValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) {
        if (value == null) {
            return;
        }

        try {
            //Double dd = new Double(value.toString());
//			if (dd<0) {
//				context.addMessage(component.getClientId(context), 
//						 new FacesMessage(FacesMessage.SEVERITY_ERROR, 
//						 MessageBundleLoader.getMessage("possitiveNumber"), 
//						 MessageBundleLoader.getMessage("possitiveNumber")));								
//			}
        } catch (Exception e) {
//			context.addMessage(component.getClientId(context), 
//					 new FacesMessage(FacesMessage.SEVERITY_ERROR, 
//					 MessageBundleLoader.getMessage("integerValidation"), 
//					 MessageBundleLoader.getMessage("integerValidation")));

            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "ERROR IN VALIDATOR",
                    "ERROR IN VALIDATOR"));
        }
    }
}
