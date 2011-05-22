package callcenter.web.action.login;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import callcenter.entity.clients.User;
import callcenter.service.administration.UserService;

public class LoginAction {

	@EJB
	private UserService userService;

	public String login(User user) {
		User checkLogin = userService.checkLogin(user);
		if (checkLogin == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "asdkjash", "asdasda");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		return "loginSuccessful";
	}
}
