package callcenter.web.action.login;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import callcenter.entity.clients.User;
import callcenter.service.administration.UserServiceBean;

@ManagedBean(name = "loginAction")
@SessionScoped
public class LoginAction {

	@EJB
	private UserServiceBean userService;

	public String login(User user) {
		User checkLogin = userService.checkLogin(user);
		if (checkLogin == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "asdkjash", "asdasda");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		setUser(checkLogin);
		return "loginSuccessful";
	}

	public boolean isLoggedin() {
		return getUser() != null;
	}

	public User getUser() {
		return (User) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("user");
	}

	public void setUser(User user) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("user", user);
	}

}
