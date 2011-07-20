package callcenter.web.action.issue;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.entity.issue.IssueDetail;
import callcenter.entity.issue.Project;
import callcenter.service.administration.IssueServiceBean;

@ViewScoped
@ManagedBean(name = "issueCreateAction")
public class IssueCreateAction implements Serializable {

	private static final long serialVersionUID = -5533722715840256982L;
	private boolean readonly;

	private IssueDetail issue;

	@EJB
	private IssueServiceBean issueService;

	public String create() {
		issueService.saveOrUpdate(issue);
		setReadonly(true);
		return null;
	}

	public void edit(IssueDetail issue) {
		setReadonly(false);

	}
	
	public String createProject(Project project){
		
		issueService.saveOrUpdate(issue);
		
		return null;
	}

	public String createNewIssue() {
		setReadonly(false);
		issue = new IssueDetail();
		return "createNewIssue";
	}

	public boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public IssueDetail getIssue() {
		if (issue == null)
			issue = new IssueDetail();
		return issue;
	}

	public void setIssue(IssueDetail issue) {
		this.issue = issue;
	}

}