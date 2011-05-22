package callcenter.entity.clients;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import callcenter.entity.Address;
import callcenter.service.administration.UserService;

@Entity
@ManagedBean(name = "user")
@RequestScoped
@NamedQueries(value = {
		@NamedQuery(name = UserService.QUERY_EMAIL_EXISTS_KEY, query = UserService.QUERY_EMAIL_EXISTS),
		@NamedQuery(name = UserService.QUERY_USER_LOGIN_KEY, query = UserService.QUERY_USER_LOGIN) })
public class User extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Varchar(50)")
	private String mail;

	@Column(columnDefinition = "Varchar(100)")
	private String fullName;

	@OneToOne
	private Address address;

	@ManyToMany
	private List<Company> companies;

	@Column(columnDefinition = "Varchar(20)")
	private String phone;

	@Column(columnDefinition = "Varchar(15)")
	private String password;

	@Column(columnDefinition = "Integer")
	private String userType;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * Validation for the required data
	 */
	@Override
	public void validate() {
		super.validate();
	}
}
