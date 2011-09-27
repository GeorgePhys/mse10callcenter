/**
 * 
 */
package callcenter.web.action.privileges;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

    private int[] selected;

    public List<Privilege> getPrivileges(String entityArea) {
	return privilegesServiseBean.getPrivilegesByArea(entityArea);
    }

    public int[] getSelected() {
	return selected;
    }

    public void setSelected(int[] selected) {
	this.selected = selected;
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

    public void saveGroup() {
	setReadonly(true);
	for (int p : selected) {
	    System.out.println(p);
	}
    }
}
