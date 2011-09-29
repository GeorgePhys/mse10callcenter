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
    private String country;

    @Column(columnDefinition = "Varchar(80)")
    private String street;

    @Column(columnDefinition = "Varchar(50)")
    private String city;

    @Column(columnDefinition = "Integer")
    private Integer postCode;

    @Column(columnDefinition = "Varchar(30)")
    private String municipality;

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
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

    public Integer getPostCode() {
	return postCode;
    }

    public void setPostCode(Integer postCode) {
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

    @Override
    public void initializeBibirectional() {
	// TODO Auto-generated method stub

    }

}
