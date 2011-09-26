package callcenter.web.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang.StringUtils;

@FacesValidator("equalPasswordsValidator")
public class EqualPasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException {
	UIInput password = (UIInput) component.getAttributes().get(
		"passwordFiled");

	String passwordValue = (String) password.getValue();
	String confirmPassword = (String) value;

	if (!StringUtils.isEmpty(passwordValue)
		&& !passwordValue.equals(confirmPassword)) {
	    ((HtmlInputSecret) component).setSubmittedValue("");
	    ((HtmlInputSecret) password).setSubmittedValue("");
	    String message = "passwords don't match";
	    throw new ValidatorException(new FacesMessage(
		    FacesMessage.SEVERITY_ERROR, message, message));
	}
    }
}
