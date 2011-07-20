package callcenter.web.action.issue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.dto.issue.IssueSearchDTO;
import callcenter.dto.project.ProjectSearchDTO;
import callcenter.entity.issue.IssueDetail;
import callcenter.entity.issue.Project;
import callcenter.service.administration.IssueServiceBean;
import callcenter.service.project.ProjectServiceBean;

@ViewScoped
@ManagedBean(name = "issueCreateAction")
public class IssueCreateAction implements Serializable {

	private static final long serialVersionUID = -5533722715840256982L;
	private boolean readonly;

	private IssueDetail issue;
	@EJB
	private ProjectServiceBean projectList;
	private ProjectSearchDTO dto;

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
	
	public List<Project> searchProject() {
		List<String> projectNames=new ArrayList<String>();
		return projectList.search(dto, false);
		
		
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