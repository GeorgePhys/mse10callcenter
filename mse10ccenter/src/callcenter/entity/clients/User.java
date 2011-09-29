package callcenter.entity.clients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import callcenter.entity.Address;
import callcenter.entity.order.UserOrder;
import callcenter.entity.privileges.PrivilegesGroup;
import callcenter.service.administration.UserServiceBean;

@Entity
@NamedQueries(value = {
	@NamedQuery(name = UserServiceBean.QUERY_EMAIL_EXISTS_KEY, query = UserServiceBean.QUERY_EMAIL_EXISTS),
	@NamedQuery(name = UserServiceBean.QUERY_USER_LOGIN_KEY, query = UserServiceBean.QUERY_USER_LOGIN),
	@NamedQuery(name = UserServiceBean.QUERY_USER_BY_EMAIL_KEY, query = UserServiceBean.QUERY_USER_BY_EMAIL),
	@NamedQuery(name = UserServiceBean.QUERY_USER_ALL_KEY, query = UserServiceBean.QUERY_USER_ALL) })
public class User extends callcenter.entity.Entity implements Serializable {

    private Role role = Role.USER;

    @Column(columnDefinition = "Varchar(50)")
    private String mail;

    @Column(columnDefinition = "Varchar(100)")
    private String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address = new Address();

    @ManyToMany(mappedBy = "representatives")
    private List<Company> companies = new ArrayList<Company>();

    @Column(columnDefinition = "Varchar(20)")
    private String phone;

    @Column(columnDefinition = "Varchar(100)")
    private String password;

    @Column(columnDefinition = "Integer")
    private Integer userType;

    @Column(columnDefinition = "Boolean")
    private Boolean confirmed;

    @OneToMany(mappedBy = "user")
    List<UserOrder> order;

    private Boolean deleted;

    @ManyToMany(mappedBy = "users")
    private List<PrivilegesGroup> groups;

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
    public void setUserType(Integer userType) {
	this.userType = userType;
    }

    /**
     * @return the userType
     */
    public Integer getUserType() {
	return userType;
    }

    public Boolean getConfirmed() {
	return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
	this.confirmed = confirmed;
    }

    @Override
    public void initializeBibirectional() {
	// TODO Auto-generated method stub

    }

    /**
     * @return the role
     */
    public Role getRole() {

	return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(Role role) {
	this.role = role;
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

    public List<UserOrder> getOrder() {
	return order;
    }

    public void setOrder(List<UserOrder> order) {
	this.order = order;
    }

    public List<PrivilegesGroup> getGroups() {
	return groups;
    }

    public void setGroups(List<PrivilegesGroup> groups) {
	this.groups = groups;
    }

}
