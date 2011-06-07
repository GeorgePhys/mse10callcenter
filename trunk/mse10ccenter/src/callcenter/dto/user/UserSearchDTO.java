package callcenter.dto.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.clients.User;

@ManagedBean(name = "userDto")
@ViewScoped
public class UserSearchDTO extends BaseDTO<User> {

	private String fullName;

	private String mail;

	private String phone;

	private String country;

	private String city;

	private String street;

	private String postCode;

	private String password;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
