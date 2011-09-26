package callcenter.web.action.issue;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.entity.issue.Project;
import callcenter.service.project.ProjectServiceBean;
import callcenter.web.action.BaseAction;

/**
 * Manages creation of a project.
 * 
 * @author yasko
 * @author sibel
 * 
 */
@SessionScoped
@ManagedBean(name = "projectCreateAction")
public class ProjectCreateAction extends BaseAction<Project> implements
	Serializable {

    private static final long serialVersionUID = -5533722715840256982L;

    @EJB
    private ProjectServiceBean projectService;

    /**
     * Initializes project create action by setting new empty instance of
     * {@link Project} as the target entity then return navigation string for
     * the project creation screen.
     * 
     * @return Navigation string for project creation screen.
     */
    public String createNewProject() {
	setTargetEntity(new Project());
	return "createNewProject";
    }

    /**
     * Persists the initialized targetEntity resets targetEntity with the new
     * instance return by the back-end service and sets the read-only flag
     * causing the for to be not editable.
     */
    public void createProject() {
	Project project = projectService.saveOrUpdate(getTargetEntity());
	setTargetEntity(project);
	setReadonly(true);
    }

    /**
     * Resets the read-only to make the for editable again.
     */
    public void editProject() {
	setReadonly(false);
    }
}
