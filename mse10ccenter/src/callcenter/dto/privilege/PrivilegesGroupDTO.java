/**
 * 
 */
package callcenter.dto.privilege;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.privileges.Privilege;
import callcenter.entity.privileges.PrivilegesGroup;

/**
 * @author bassextremist
 * 
 */
@ManagedBean(name = "groupDTO")
@ViewScoped
public class PrivilegesGroupDTO extends BaseDTO<PrivilegesGroup> {

    private String name;

    private String description;

    private List<Privilege> privileges = new ArrayList<Privilege>();

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
}
