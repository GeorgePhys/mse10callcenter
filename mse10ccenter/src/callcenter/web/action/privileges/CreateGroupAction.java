/**
 * 
 */
package callcenter.web.action.privileges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import callcenter.entity.clients.User;
import callcenter.entity.privileges.Privilege;
import callcenter.entity.privileges.PrivilegesGroup;
import callcenter.service.administration.PrivilegesServiseBean;
import callcenter.web.action.BaseAction;

/**
 * @author bassextremist
 * 
 */
@ManagedBean(name = "createGroupAction")
@SessionScoped
public class CreateGroupAction extends BaseAction<PrivilegesGroup> {

    @EJB
    private PrivilegesServiseBean privilegesServiseBean;

    private List<User> selectedUsers = new LinkedList<User>();

    private List<String> selected = new ArrayList<String>();

    public String getGroupName() {
	return groupName;
    }

    public String getGroupDescription() {
	return groupDescription;
    }

    private String groupName;

    private String groupDescription;

    public List<Privilege> getPrivileges(String entityArea) {
	List<Privilege> list = privilegesServiseBean
		.getPrivilegesByArea(entityArea);
	return list;
    }

    public List<String> getSelected() {
	return selected;
    }

    public void setSelected(List<String> selected) {
	if (this.selected != null) {
	    for (String string : selected) {
		this.selected.add(string);
	    }
	} else {
	    this.selected = selected;

	}
    }

    public void setGroupName(String groupName) {
	this.groupName = groupName;
    }

    public void setGroupDescription(String description) {
	this.groupDescription = description;
    }

    public String getLabel(Privilege privilege) {
	String lacaleCode = FacesContext.getCurrentInstance().getViewRoot()
		.getLocale().toString();
	if ("bg_BG".equals(lacaleCode)) {
	    return privilege.getDescriptionBg();
	} else {
	    return privilege.getDescription();
	}
    }

    public String init() {
	setTargetEntity(new PrivilegesGroup());
	setReadonly(false);
	return "createGroup";
    }

    public String perview(PrivilegesGroup pg) {
	setTargetEntity(pg);
	setReadonly(true);
	return "createGroup";
    }

    public void saveGroup() {
	setReadonly(true);
	List<Privilege> realPrevileges = new ArrayList<Privilege>();
	for (String p : selected) {
	    realPrevileges.add(privilegesServiseBean.find(Privilege.class,
		    Long.valueOf(p)));
	}

	getTargetEntity().getPrivileges().clear();
	getTargetEntity().getPrivileges().addAll(realPrevileges);

	getTargetEntity().getUsers().clear();
	getTargetEntity().getUsers().addAll(getSelectedUsers());

	getTargetEntity().setName(groupName);
	getTargetEntity().setDescription(groupDescription);

	setTargetEntity(privilegesServiseBean.save(getTargetEntity()));

    }

    /**
     * @return the selectedUsers
     */
    public List<User> getSelectedUsers() {
	return selectedUsers;
    }

    /**
     * @param selectedUsers
     *            the selectedUsers to set
     */
    public void setSelectedUsers(List<User> selectedUsers) {
	System.out.println(selectedUsers);
	this.selectedUsers = selectedUsers;
    }

}
