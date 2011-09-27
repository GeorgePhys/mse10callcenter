/**
 * 
 */
package callcenter.web.action.privileges;

import java.util.ArrayList;
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

    private List<String> selected;

    public List<Privilege> getPrivileges(String entityArea) {
	List<Privilege> list = privilegesServiseBean
		.getPrivilegesByArea(entityArea);
	return list;
    }

    public List<String> getSelected() {
	return selected;
    }

    public void setSelected(List<String> selected) {
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
	List<Privilege> realPrevileges = new ArrayList<Privilege>();
	for (String p : selected) {
	    realPrevileges.add(privilegesServiseBean.find(Privilege.class,
		    Long.valueOf(p)));
	}
	getTargetEntity().getPrivileges().clear();
	getTargetEntity().getPrivileges().addAll(realPrevileges);
	setTargetEntity(privilegesServiseBean.save(getTargetEntity()));
    }
}
