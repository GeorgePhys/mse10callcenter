package callcenter.web.validators;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("notAfterDateValidator")
public class NotAfterTodayValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException {
	UIInput secondDate = (UIInput) component.getAttributes().get(
		"compareTo");

	Date secondDateValue = (Date) secondDate.getValue();

	if (secondDateValue == null) {
	    String message = "Date ended may not be later than today.";
	    throw new ValidatorException(new FacesMessage(message));
	}

	Date date = (Date) value;
	if (date.after(secondDateValue)) {
	    String message = "Date may not be later than today.";
	    throw new ValidatorException(new FacesMessage(message));
	}

    }

}