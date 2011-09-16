package callcenter.web.action.issue;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.ValidatorException;

import callcenter.entity.issue.IssueDetail;
import callcenter.service.administration.IssueServiceBean;
import callcenter.service.project.ProjectServiceBean;
import callcenter.web.action.BaseAction;

@SessionScoped
@ManagedBean(name = "issueCreateAction")
public class IssueCreateAction extends BaseAction<IssueDetail> implements
		Serializable {

	private static final long serialVersionUID = -5533722715840256982L;

	@EJB
	private ProjectServiceBean projectService;

	@EJB
	private IssueServiceBean issueService;

	public String create() {
		if (getTargetEntity().getDateCreated().after(
				getTargetEntity().getDateEnded())) {

			String message = "Date may not be later than today.";
			throw new ValidatorException(new FacesMessage(message));
		}
		issueService.saveOrUpdate(getTargetEntity());
		setReadonly(true);
		return null;
	}

	public void edit(IssueDetail issue) {
		setReadonly(false);

	}

	public List<String> getSearchProject() {
		return projectService.listAllProjectNames();
	}

	public String open(IssueDetail is) {
		setTargetEntity(is);
		setReadonly(true);
		return "createNewIssue";

	}

	public String createNewIssue() {
		setReadonly(false);
		setTargetEntity(new IssueDetail());
		return "createNewIssue";
	}
}