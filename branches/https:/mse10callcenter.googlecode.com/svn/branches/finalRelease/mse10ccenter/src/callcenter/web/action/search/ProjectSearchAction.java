package callcenter.web.action.search;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import callcenter.dto.project.ProjectSearchDTO;
import callcenter.entity.issue.Project;
import callcenter.service.project.ProjectServiceBean;
import callcenter.web.action.BaseSearchAction;
import callcenter.web.action.issue.ProjectCreateAction;

@SessionScoped
@ManagedBean(name = "projectSearchAction")
public class ProjectSearchAction extends
	BaseSearchAction<Project, ProjectSearchDTO> {

    @ManagedProperty(value = "#{projectCreateAction}")
    private ProjectCreateAction projectAction;

    @EJB
    private ProjectServiceBean service;

    public String startSearch() {
	setDataModel(null);
	return "startNewProjectSearch";
    }

    @Override
    public String previewSearchResult(Project result) {
	return projectAction.preview(result);
    }

    @Override
    public ProjectServiceBean getService() {
	return service;
    }

    @Override
    public Class<Project> getEntityClass() {
	return Project.class;
    }

    /**
     * @return the projectAction
     */
    public ProjectCreateAction getProjectAction() {
	return projectAction;
    }

    /**
     * @param projectAction
     *            the projectAction to set
     */
    public void setProjectAction(ProjectCreateAction projectAction) {
	this.projectAction = projectAction;
    }
}
