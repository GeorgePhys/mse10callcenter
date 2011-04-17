package callcenter.entity.clients;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import callcenter.entity.Address;

@Entity
public class User extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Varchar(20)")
	private String user;

	@Column(columnDefinition = "Varchar(50)")
	private String mail;

	@Column(columnDefinition = "Varchar(100)")
	private String fullName;

	@OneToOne
	private Address address;

	@Column(columnDefinition = "Varchar(50)")
	private String companies;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

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

	public String getCompanies() {
		return companies;
	}

	public void setCompanies(String companies) {
		this.companies = companies;
	}
}
