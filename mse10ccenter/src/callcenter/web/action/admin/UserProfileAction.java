package callcenter.web.action.admin;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.entity.clients.User;
import callcenter.service.administration.UserServiceBean;

@ViewScoped
@ManagedBean(name = "userProfileAction")
public class UserProfileAction {

	private static final long serialVersionUID = -5533722715840256982L;
	private boolean readonly;

	private User user;

	@EJB
	private UserServiceBean userService;

	public String profile() {
		
		setReadonly(true);
		return "userProfile";
	}

	public void edit(User user) {
		setReadonly(false);

	}

	public boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public User getUser() {
		if (user == null)
			user = new User();
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
