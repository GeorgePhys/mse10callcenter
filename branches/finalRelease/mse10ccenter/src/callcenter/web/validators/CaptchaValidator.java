package callcenter.web.validators;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;
import callcenter.service.cache.MessagesCache;
import callcenter.util.CommonUtil;

@FacesValidator(value = "captchaValidator")
public class CaptchaValidator implements Validator, Serializable {

    @Override
    public void validate(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException {
	HttpSession session = (HttpSession) context.getExternalContext()
		.getSession(false);
	Captcha secretcaptcha = (Captcha) session.getAttribute(Captcha.NAME);
	if (secretcaptcha.isCorrect(value != null ? value.toString() : "")) {
	    return;
	}

	((HtmlInputText) component).setSubmittedValue("");

	try {
	    String message = CommonUtil.lookupSessionBean(MessagesCache.class)
		    .getMessage(context.getViewRoot().getLocale().toString(),
			    "captchaNotMatching");
	    throw new ValidatorException(new FacesMessage(
		    FacesMessage.SEVERITY_ERROR, message, message));
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
