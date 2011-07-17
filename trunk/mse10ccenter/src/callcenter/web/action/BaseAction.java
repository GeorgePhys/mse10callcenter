package callcenter.web.action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import callcenter.entity.clients.User;

@SessionScoped
@ManagedBean(name = "baseAction")
public class BaseAction {

	public boolean getLoggedIn() {
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
