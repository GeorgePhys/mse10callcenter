package callcenter.web.action.search;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.user.UserSearchDTO;
import callcenter.entity.clients.User;
import callcenter.service.administration.UserServiceBean;
import callcenter.web.action.BaseSearchAction;

@SessionScoped
@ManagedBean(name = "userSearchAction")
public class UserSearchAction extends BaseSearchAction<User, UserSearchDTO>
		implements Serializable {

	private static final long serialVersionUID = -5156711102367948040L;

	@EJB
	private UserServiceBean service;

	@Override
	public String previewSearchResult(User result) {
		getBaseAction().setTargetEntity(result);
		getBaseAction().setReadonly(true);
		return "userRegistration";
	}

	@Override
	public UserServiceBean getService() {
		return service;
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

}
