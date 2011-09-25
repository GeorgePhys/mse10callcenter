package callcenter.web.action.search;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.BaseDTO;
import callcenter.dto.project.ProjectSearchDTO;
import callcenter.entity.issue.Project;
import callcenter.service.base.BaseServiceBean;
import callcenter.service.project.ProjectServiceBean;
import callcenter.web.action.BaseSearchAction;
import callcenter.web.action.search.datamodel.JPADataModel;

@SessionScoped
@ManagedBean(name = "projectSearchAction")
@SuppressWarnings("rawtypes")
public class ProjectSearchAction extends
	BaseSearchAction<Project, ProjectSearchDTO> {

    @EJB
    private ProjectServiceBean service;

    private static final class ProjectDataModel extends JPADataModel<Project> {

	private ProjectDataModel(BaseServiceBean service, BaseDTO dto) {
	    super(service, dto, Project.class);
	}

	@Override
	protected Object getId(Project t) {
	    return t.getId();
	}
    }

    public String startSearch() {
	setDataModel(null);
	return "startNewProjectSearch";
    }

    @Override
    public String previewSearchResult(Project result) {
	getBaseAction().setTargetEntity(result);
	getBaseAction().setReadonly(true);
	return "createNewProject";
    }

    @Override
    public ProjectServiceBean getService() {
	return service;
    }

    @Override
    public Class<Project> getEntityClass() {
	return Project.class;
    }
}
