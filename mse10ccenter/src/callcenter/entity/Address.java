package callcenter.entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ManagedBean(name = "address")
@RequestScoped
public class Address extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Varchar(100)")
	private String coutry;

	@Column(columnDefinition = "Varchar(100)")
	private String street;

	@Column(columnDefinition = "Varchar(50)")
	private String city;

	@Column(columnDefinition = "Varchar(20)")
	private String postCode;

	@Column(columnDefinition = "Varchar(30)")
	private String municipality;

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

	/**
	 * @param municipality
	 *            the municipality to set
	 */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	/**
	 * @return the municipality
	 */
	public String getMunicipality() {
		return municipality;
	}

}
