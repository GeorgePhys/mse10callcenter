package callcenter.web.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.NamingException;

import callcenter.service.administration.UserServiceBean;
import callcenter.util.CommonUtil;

@FacesValidator("checkEmail")
public class CheckEmail implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException {
	try {
	    if (CommonUtil.lookupSessionBean(UserServiceBean.class)
		    .userEmailExists((String) value)) {
		FacesMessage msg = new FacesMessage(
			"This E-mail already exist.",
			"This E-mail already exist.");

		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ValidatorException(msg);
	    }
	} catch (NamingException e) {
	    e.printStackTrace();
	}

    }

}
