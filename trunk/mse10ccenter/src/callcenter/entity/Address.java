package callcenter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Address extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Varchar(100)")
	private String coutry;

	@Column(columnDefinition = "Varchar(100)")
	private String street;

	@Column(columnDefinition = "Varchar(50)")
	private String city;

	@Column(columnDefinition = "Varchar(20)")
	private String postCode;

	public String getCoutry() {
		return coutry;
	}

	public void setCoutry(String coutry) {
		this.coutry = coutry;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
