package forms;

import java.util.Date;

public class UserData {
	private String comment;
	private String name;
	private String password;
	private String address;
	private Boolean over18;
	private String gender;
	private String city;
	private Date creationDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getOver18() {
		return over18;
	}

	public void setOver18(Boolean over18) {
		this.over18 = over18;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "userData [name=" + name + ", password=" + password
				+ ", address=" + address + ", over18=" + over18 + ", gender="
				+ gender + ", city=" + city + ", creationDate=" + creationDate
				+ ", comment=" + comment
				+ "]";
	}
}
