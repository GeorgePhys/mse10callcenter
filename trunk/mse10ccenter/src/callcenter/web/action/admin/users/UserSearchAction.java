package callcenter.web.action.admin.users;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

import callcenter.dto.user.UserSearchDTO;
import callcenter.entity.clients.User;
import callcenter.service.administration.UserService;

@ManagedBean(name = "userSearchAction")
@SessionScoped
public class UserSearchAction extends DataModel<User> {

	@EJB
	private UserService service;

	private List<User> result;

	public String search(UserSearchDTO args) {
		service.search(args);
		setResult(args.getResult());
		return null;
	}

	public List<User> getResult() {
		return result;
	}

	public void setResult(List<User> result) {
		this.result = result;
	}

	@Override
	public int getRowCount() {
		return (result == null) ? 0 : result.size();
	}

	@Override
	public User getRowData() {
		if (result == null) {
			return null;
		} else if (!isRowAvailable()) {
			throw new IllegalArgumentException();
		}
		return result.get(getRowIndex());
	}

	@Override
	public int getRowIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getWrappedData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRowAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRowIndex(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWrappedData(Object arg0) {
		// TODO Auto-generated method stub

	}
}
