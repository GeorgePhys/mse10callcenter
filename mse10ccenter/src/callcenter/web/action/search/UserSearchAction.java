package callcenter.web.action.search;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.BaseDTO;
import callcenter.dto.user.UserSearchDTO;
import callcenter.entity.clients.User;
import callcenter.service.administration.UserServiceBean;
import callcenter.service.base.BaseServiceBean;
import callcenter.web.action.search.datamodel.JPADataModel;

@SessionScoped
@ManagedBean(name = "userSearchAction")
@SuppressWarnings("rawtypes")
public class UserSearchAction implements Serializable {

	private static final long serialVersionUID = -5156711102367948040L;

	@EJB
	private UserServiceBean service;

	private UserDataModel dataModel;

	private static final class UserDataModel extends JPADataModel<User> {

		private UserDataModel(BaseServiceBean service, BaseDTO dto) {
			super(service, dto, User.class);
		}

		@Override
		protected Object getId(User t) {
			return t.getId();
		}
	}

	public String search(UserSearchDTO dto) {
		service.search(dto, true);
		setDataModel(new UserDataModel(service, dto));
		return null;
	}

	public Object getDataModel() {
		return dataModel;
	}

	public void setDataModel(UserDataModel dataModel) {
		this.dataModel = dataModel;
	}
}
