package com.hosp.validator;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.hosp.util.MessageBundleLoader;

@FacesValidator("com.validator.ListSizeValidator")
public class ListSizeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) {
        if (value == null) {
            return;
        }

        try {
            if (value instanceof java.util.List) {
                if ((new ArrayList((List) value)).isEmpty()) {
                    FacesMessage message = new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            MessageBundleLoader.getMessage("emptyList"), null);
                }


            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    MessageBundleLoader.getMessage("emptyList"), null);
            throw new ValidatorException(message);
        }
    }
}
