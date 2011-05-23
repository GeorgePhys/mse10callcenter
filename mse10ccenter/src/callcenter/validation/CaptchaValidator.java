package callcenter.validation;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

@ManagedBean(name = "captchaValidator")
@SessionScoped
public class CaptchaValidator implements Serializable {

	public void validateCaptcha(FacesContext context,
			UIComponent componentToValidate, Object value)
			throws ValidatorException {
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		Captcha secretcaptcha = (Captcha) session.getAttribute(Captcha.NAME);
		if (secretcaptcha.isCorrect(value.toString()))
			return;

		// optional: clear field
		((HtmlInputText) componentToValidate).setSubmittedValue("");

		throw new ValidatorException(new FacesMessage("Captcha does not match"));
	}
}
