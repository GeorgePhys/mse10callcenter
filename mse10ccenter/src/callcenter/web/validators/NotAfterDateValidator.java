package callcenter.web.validators;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang.time.DateUtils;

@FacesValidator("notAfterDateValidator")
public class NotAfterDateValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException {
	// Retrieve the connected calendar component
	UIInput secondDate = (UIInput) component.getAttributes().get(
		"compareTo");

	// Strip down hours, minutes, seconds and milliseconds.
	Date secondDateValue = DateUtils.round((Date) secondDate.getValue(),
		Calendar.DATE);
	Date date = DateUtils.round((Date) value, Calendar.DATE);

	// Compare the dates
	if (date.before(secondDateValue)) {
	    String message = "Date may not be later than today.";
	    throw new ValidatorException(new FacesMessage(message));
	}

    }

}