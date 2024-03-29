package callcenter.entity.privileges;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import callcenter.entity.clients.User;

@Entity
public class PrivilegesGroup extends callcenter.entity.Entity implements
	Serializable {

    @Column(columnDefinition = "Varchar(50)")
    private String name;

    @Column(columnDefinition = "Varchar(250)")
    private String description;

    @ManyToMany
    private List<Privilege> privileges = new ArrayList<Privilege>();

    @ManyToMany
    private List<User> users = new ArrayList<User>();

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public List<Privilege> getPrivileges() {
	return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
	this.privileges = privileges;
    }

    @Override
    public void initializeBibirectional() {
	// TODO Auto-generated method stub

    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
	return users;
    }

    /**
     * @param users
     *            the users to set
     */
    public void setUsers(List<User> users) {
	this.users = users;
    }
}
