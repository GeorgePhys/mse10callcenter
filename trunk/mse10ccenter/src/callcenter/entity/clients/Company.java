package callcenter.entity.clients;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import callcenter.entity.Address;

@Entity
public class Company extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Varchar(20)")
	private String name;

	@Column(columnDefinition = "Varchar(14)")
	private String bulstat;

	@Column(columnDefinition = "Varchar(50)")
	private String webAddress;

	@OneToOne
	private Address address;

	@ManyToMany
	private List<User> representatives;

	@Column(columnDefinition = "Varchar(20)")
	private String phone;

	@Column(columnDefinition = "Varchar(50)")
	private String mail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBulstat() {
		return bulstat;
	}

	public void setBulstat(String bulstat) {
		this.bulstat = bulstat;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<User> getRepresentatives() {
		return representatives;
	}

	public void setRepresentatives(List<User> representatives) {
		this.representatives = representatives;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}