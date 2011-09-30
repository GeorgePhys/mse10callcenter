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
import callcenter.service.administration.UserServiceBean;
import callcenter.web.action.BaseAction;

/**
 * @author bassextremist
 * 
 */
@ManagedBean(name = "createGroupAction")
@SessionScoped
public class CreateGroupAction extends BaseAction<PrivilegesGroup> {

    private List<String> selectedUserArea = new ArrayList<String>();
    private List<String> selectedForumArea = new ArrayList<String>();
    private List<String> selectedShopArea = new ArrayList<String>();
    private List<String> selectedIssueArea = new ArrayList<String>();
    private List<String> selectedFaqArea = new ArrayList<String>();
    private List<String> selectedProjectArea = new ArrayList<String>();

    public List<String> getSelectedUserArea() {
	return selectedUserArea;
    }

    public void setSelectedUserArea(List<String> selectedUserArea) {
	this.selectedUserArea = selectedUserArea;
    }

    public List<String> getSelectedForumArea() {
	return selectedForumArea;
    }

    public void setSelectedForumArea(List<String> selectedForumArea) {
	this.selectedForumArea = selectedForumArea;
    }

    public List<String> getSelectedShopArea() {
	return selectedShopArea;
    }

    public void setSelectedShopArea(List<String> selectedShopArea) {
	this.selectedShopArea = selectedShopArea;
    }

    public List<String> getSelectedIssueArea() {
	return selectedIssueArea;
    }

    public void setSelectedIssueArea(List<String> selectedIssueArea) {
	this.selectedIssueArea = selectedIssueArea;
    }

    public List<String> getSelectedFaqArea() {
	return selectedFaqArea;
    }

    public void setSelectedFaqArea(List<String> selectedFaqArea) {
	this.selectedFaqArea = selectedFaqArea;
    }

    public List<String> getSelectedProjectArea() {
	return selectedProjectArea;
    }

    public void setSelectedProjectArea(List<String> selectedProjectArea) {
	this.selectedProjectArea = selectedProjectArea;
    }

    @EJB
    private PrivilegesServiseBean privilegesServiseBean;

    @EJB
    private UserServiceBean userServiceBean;

    private List<String> selectedUsers = new LinkedList<String>();

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
	selectedFaqArea.clear();
	selectedForumArea.clear();
	selectedIssueArea.clear();
	selectedProjectArea.clear();
	selectedShopArea.clear();
	selectedUserArea.clear();
	selectedUsers.clear();
	groupDescription = null;
	groupName = null;
	setReadonly(false);
	return "createGroup";
    }

    public String perview(PrivilegesGroup pg) {
	init();
	pg = privilegesServiseBean.find(PrivilegesGroup.class, pg.getId());
	setTargetEntity(pg);

	this.groupName = pg.getName();
	this.groupDescription = pg.getDescription();

	for (Privilege privilege : pg.getPrivileges()) {
	    if ("user".equals(privilege.getEntityArea())) {
		selectedUserArea.add(privilege.getId().toString());
		continue;
	    }
	    if ("forum".equals(privilege.getEntityArea())) {
		selectedForumArea.add(privilege.getId().toString());
		continue;
	    }
	    if ("shop".equals(privilege.getEntityArea())) {
		selectedShopArea.add(privilege.getId().toString());
		continue;
	    }
	    if ("issue".equals(privilege.getEntityArea())) {
		selectedIssueArea.add(privilege.getId().toString());
		continue;
	    }
	    if ("FAQ".equals(privilege.getEntityArea())) {
		selectedFaqArea.add(privilege.getId().toString());
		continue;
	    }
	    if ("project".equals(privilege.getEntityArea())) {
		selectedProjectArea.add(privilege.getId().toString());
		continue;
	    }
	}
	for (User user : pg.getUsers()) {
	    selectedUsers.add(user.getId().toString());
	}
	setReadonly(true);
	return "createGroup";
    }

    public void saveGroup() {
	setReadonly(true);
	List<Privilege> realPrevileges = new ArrayList<Privilege>();
	for (String p : getSelectedFaqArea()) {
	    realPrevileges.add(privilegesServiseBean.find(Privilege.class,
		    Long.valueOf(p)));
	}
	for (String p : getSelectedForumArea()) {
	    realPrevileges.add(privilegesServiseBean.find(Privilege.class,
		    Long.valueOf(p)));
	}
	for (String p : getSelectedIssueArea()) {
	    realPrevileges.add(privilegesServiseBean.find(Privilege.class,
		    Long.valueOf(p)));
	}
	for (String p : getSelectedProjectArea()) {
	    realPrevileges.add(privilegesServiseBean.find(Privilege.class,
		    Long.valueOf(p)));
	}
	for (String p : getSelectedShopArea()) {
	    realPrevileges.add(privilegesServiseBean.find(Privilege.class,
		    Long.valueOf(p)));
	}
	for (String p : getSelectedUserArea()) {
	    realPrevileges.add(privilegesServiseBean.find(Privilege.class,
		    Long.valueOf(p)));
	}

	getTargetEntity().getUsers().clear();
	for (String user : selectedUsers) {
	    User usr = privilegesServiseBean.load(User.class,
		    Long.valueOf(user));
	    usr.getGroups().add(getTargetEntity());
	    getTargetEntity().getUsers().add(usr);
	}

	getTargetEntity().getPrivileges().clear();
	getTargetEntity().getPrivileges().addAll(realPrevileges);

	getTargetEntity().setName(groupName);
	getTargetEntity().setDescription(groupDescription);

	setTargetEntity(privilegesServiseBean.save(getTargetEntity()));

    }

    /**
     * @return the selectedUsers
     */
    public List<String> getSelectedUsers() {
	return selectedUsers;
    }

    /**
     * @param selectedUsers
     *            the selectedUsers to set
     */
    public void setSelectedUsers(List<String> selectedUsers) {
	this.selectedUsers = selectedUsers;
    }

}
