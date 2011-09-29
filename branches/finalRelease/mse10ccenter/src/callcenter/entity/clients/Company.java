package callcenter.entity.clients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import callcenter.entity.Address;

@Entity
@ManagedBean(name = "company")
@RequestScoped
public class Company extends callcenter.entity.Entity implements Serializable {

    @Column(columnDefinition = "Varchar(100)")
    private String name;

    @Column(columnDefinition = "Varchar(13)")
    private String bulstat;

    @Column(columnDefinition = "Varchar(50)")
    private String webAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address = new Address();

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
	    CascadeType.REFRESH })
    private List<User> representatives = new ArrayList<User>();

    @Column(columnDefinition = "Varchar(20)")
    private String phone;

    @Column(columnDefinition = "Varchar(50)")
    private String mail;

    private Boolean deleted;

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

    @Override
    public void initializeBibirectional() {

    }

    /**
     * @return the deleted
     */
    public Boolean getDeleted() {
	return deleted;
    }

    /**
     * @param deleted
     *            the deleted to set
     */
    public void setDeleted(Boolean deleted) {
	this.deleted = deleted;
    }
}