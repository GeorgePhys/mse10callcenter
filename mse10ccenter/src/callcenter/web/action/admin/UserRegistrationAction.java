package callcenter.web.action.admin;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.entity.clients.User;
import callcenter.service.administration.UserServiceBean;
import callcenter.web.action.BaseAction;

@ViewScoped
@ManagedBean(name = "userRegistrationAction")
public class UserRegistrationAction extends BaseAction<User> implements
		Serializable {

	private static final long serialVersionUID = -5533722715840256982L;

	@EJB
	private UserServiceBean userService;

	public String register(User user) throws Exception {
		User registerUser = userService.registerUser(user);
		setTargetEntity(registerUser);
		return "successRegister";
	}

}
