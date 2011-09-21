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
public class LoginAction extends BaseAction<User> {

    @EJB
    private UserServiceBean userService;

    public String initLogin() {
	setTargetEntity(new User());
	return "loginPage";
    }

    public String login() {
	User checkLogin = userService.checkLogin(getTargetEntity());
	if (checkLogin == null) {
	    FacesMessage message = new FacesMessage(
		    FacesMessage.SEVERITY_ERROR, "This user dont exist",
		    "asdasda");
	    FacesContext.getCurrentInstance().addMessage(null, message);
	    return null;
	}
	setTargetEntity(null);
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

    @Override
    public User getTargetEntity() {
	// issue #78 - This is needed because login page may be called from
	// filter
	// redirection and thence targetEntity will be null
	User user = super.getTargetEntity();
	if (user == null) {
	    user = new User();
	    setTargetEntity(user);
	}
	return user;
    }
}
