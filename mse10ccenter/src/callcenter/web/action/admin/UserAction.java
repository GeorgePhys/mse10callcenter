package callcenter.web.action.admin;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.entity.clients.User;
import callcenter.service.administration.UserServiceBean;
import callcenter.web.action.BaseAction;

@SessionScoped
@ManagedBean(name = "userAction")
public class UserAction extends BaseAction<User> implements Serializable {

	private static final long serialVersionUID = -5533722715840256982L;

	@EJB
	private UserServiceBean userService;

	public String newRegistration() {
		setTargetEntity(new User());
		return "userRegistration";
	}

	public String register() throws Exception {
		User registerUser = userService.registerUser(getTargetEntity());
		setTargetEntity(registerUser);
		return "successRegister";
	}

	public String loadProfile() {
		setTargetEntity(getUser());
		return "userProfile";
	}

	public String saveProfile() {
		User saveUserProfile = userService.saveOrUpdate(getTargetEntity());
		setTargetEntity(saveUserProfile);
		setUser(saveUserProfile);
		return "saveUserProfile";
	}

}
