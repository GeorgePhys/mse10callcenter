package callcenter.web.action.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang.StringUtils;

import callcenter.entity.clients.Company;
import callcenter.entity.clients.Role;
import callcenter.entity.clients.User;
import callcenter.service.administration.UserServiceBean;
import callcenter.util.PasswordHashUtil;
import callcenter.web.action.BaseAction;

@SessionScoped
@ManagedBean(name = "userAction")
public class UserAction extends BaseAction<User> implements Serializable {

	private static final long serialVersionUID = -5533722715840256982L;

	@EJB
	private UserServiceBean userService;

	private String password;

	private String confirmPassword;

	private Map<Long, Company> selectedCompanies = new HashMap<Long, Company>();

	public List<Company> getCompanies() {
		return new ArrayList<Company>(selectedCompanies.values());
	}

	public void addCompany(Company company) {
		getSelectedCompanies().put(company.getId(), company);
	}

	public void removeCompany(Company company) {
		getSelectedCompanies().remove(company.getId());
	}

	public Map<Long, Company> getSelectedCompanies() {
		return selectedCompanies;
	}

	public String newRegistration() {
		setTargetEntity(new User());
		setPassword(null);
		setConfirmPassword(null);
		return "userRegistration";
	}

	public String register() throws Exception {
		if (!StringUtils.isEmpty(password)) {
			getTargetEntity().setPassword(getPassword());
		}
		getTargetEntity().getCompanies().addAll(getCompanies());
		User registerUser = userService.registerUser(getTargetEntity());
		setTargetEntity(registerUser);
		return "successRegister";
	}

	public String loadProfile() {
		setTargetEntity(getUser());
		setPassword(null);
		setConfirmPassword(null);
		return "userProfile";
	}

	public String saveProfile() throws Exception {
		if (!StringUtils.isEmpty(password)) {
			getTargetEntity().setPassword(
					PasswordHashUtil.getPasswordHash(password));
		}
		User user = userService.saveOrUpdate(getTargetEntity());
		setTargetEntity(user);
		setUser(user);
		return "saveUserProfile";
	}

	public String[] getRoles() {
		String[] roles = new String[Role.values().length];
		int i = 0;
		for (Role role : Role.values()) {
			roles[i++] = new String(role.getLabel());
		}
		return roles;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
