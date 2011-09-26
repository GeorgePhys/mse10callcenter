package callcenter.web.action.issue;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.entity.issue.Project;
import callcenter.service.administration.IssueServiceBean;
import callcenter.service.project.ProjectServiceBean;
import callcenter.web.action.BaseAction;

@ViewScoped
@ManagedBean(name = "projectCreateAction")
public class ProjectCreateAction extends BaseAction<Project> implements
	Serializable {

    private static final long serialVersionUID = -5533722715840256982L;

    private boolean visible = true;

    private Project project;

    @EJB
    private ProjectServiceBean projectService;
    @EJB
    private IssueServiceBean issueService;

    public String createNewProject() {

	return "createNewProject";
    }

    public String createProject() {

	projectService.saveOrUpdate(project);
	setReadonly(true);
	setVisible(false);
	return null;
    }

    public void editProject(Project project) {
	setReadonly(false);

    }

    //
    // public String create() {
    //
    // issueService.saveOrUpdate(getTargetEntity());
    // setReadonly(true);
    // return null;
    // }
    //
    // public void edit(IssueDetail issue) {
    // setReadonly(false);
    //
    // }

    //
    public Project getProject() {
	if (project == null)
	    project = new Project();
	return project;
    }

    public void setProject(Project project) {
	this.project = project;
    }

    public boolean getVisible() {
	return visible;
    }

    public void setVisible(boolean visible) {
	this.visible = visible;
    }

}
