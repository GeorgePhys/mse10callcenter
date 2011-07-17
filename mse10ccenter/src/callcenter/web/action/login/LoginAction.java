package callcenter.web.action.login;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import callcenter.entity.clients.User;
import callcenter.service.administration.UserServiceBean;
import callcenter.web.action.BaseAction;

@SessionScoped
@ManagedBean(name = "loginAction")
public class LoginAction extends BaseAction {

	@EJB
	private UserServiceBean userService;

	public String login(User user) {
		User checkLogin = userService.checkLogin(user);
		if (checkLogin == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "This user dont exist",
					"asdasda");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		setUser(checkLogin);
		return "loginSuccessful";
	}

	public String logout() {
		setUser(null);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.invalidate();
		return "loginPage";
	}
}
