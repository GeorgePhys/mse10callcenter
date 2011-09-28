/**
 * 
 */
package callcenter.web.action.search;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import callcenter.dto.privilege.PrivilegesGroupDTO;
import callcenter.entity.privileges.PrivilegesGroup;
import callcenter.service.administration.PrivilegesGroupServiceBean;
import callcenter.web.action.BaseSearchAction;
import callcenter.web.action.privileges.CreateGroupAction;

/**
 * @author bassextremist
 * 
 */
@ManagedBean(name = "privilegesGroupSearchAction")
@ViewScoped
public class PrivilegesGroupSearchAction extends
	BaseSearchAction<PrivilegesGroup, PrivilegesGroupDTO> {
    @EJB
    private PrivilegesGroupServiceBean privilegesGroupServiceBean;

    @ManagedProperty(value = "#{createGroupAction}")
    private CreateGroupAction groupAction;

    @Override
    public String previewSearchResult(PrivilegesGroup result) {
	return groupAction.perview(result);
    }

    @Override
    public PrivilegesGroupServiceBean getService() {
	return privilegesGroupServiceBean;
    }

    @Override
    public Class<PrivilegesGroup> getEntityClass() {

	return PrivilegesGroup.class;
    }

    public String init() {
	setDataModel(null);
	return "groupSearch";
    }

    public CreateGroupAction getGroupAction() {
	return groupAction;
    }

    public void setGroupAction(CreateGroupAction groupAction) {
	this.groupAction = groupAction;
    }

}
