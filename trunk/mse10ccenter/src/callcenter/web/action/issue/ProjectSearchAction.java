package callcenter.web.action.issue;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.BaseDTO;
import callcenter.dto.issue.IssueSearchDTO;
import callcenter.entity.issue.IssueDetail;
import callcenter.entity.issue.Project;
import callcenter.service.administration.IssueServiceBean;
import callcenter.service.base.BaseServiceBean;

import callcenter.web.action.search.datamodel.JPADataModel;

@SessionScoped
@ManagedBean(name = "projectSearchAction")
@SuppressWarnings("rawtypes")
public class ProjectSearchAction implements Serializable {

    @EJB
    private IssueServiceBean service;

    private ProjectDataModel dataModel;

    private static final class ProjectDataModel extends JPADataModel<Project> {

	private ProjectDataModel(BaseServiceBean service, BaseDTO dto) {
	    super(service, dto, Project.class);
	}

	@Override
	protected Object getId(Project t) {
	    return t.getId();
	}
    }

    public String search(IssueSearchDTO dto) {
	service.search(dto, true);
	setDataModel(new ProjectDataModel(service, dto));
	return null;
    }

    public Object getDataModel() {
	return dataModel;
    }

    public void setDataModel(ProjectDataModel dataModel) {
	this.dataModel = dataModel;
    }

    public String startSearch() {
	this.dataModel = null;
	return "startNewSearch";
    }
}
