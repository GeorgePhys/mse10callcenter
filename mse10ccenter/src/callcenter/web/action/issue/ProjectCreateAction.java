package callcenter.web.action.issue;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.entity.issue.Project;
import callcenter.service.administration.IssueServiceBean;

@ViewScoped
@ManagedBean(name = "projectCreateAction")
public class ProjectCreateAction implements Serializable {

	private static final long serialVersionUID = -5533722715840256982L;

	private boolean visible = true;

	private Project project;

	@EJB
	private IssueServiceBean issueService;

	public String createProject() {

		issueService.save(project);
		visible = false;
		return null;
	}

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
