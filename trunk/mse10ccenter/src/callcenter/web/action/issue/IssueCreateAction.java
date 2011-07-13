package callcenter.web.action.issue;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.entity.issue.IssueDetail;
import callcenter.service.administration.IssueServiceBean;

@ViewScoped
@ManagedBean(name = "issueCreateAction")
public class IssueCreateAction implements Serializable {

	private static final long serialVersionUID = -5533722715840256982L;
	private boolean readonly;
	private boolean disabled;
	

	private IssueDetail issue;

	@EJB
	private IssueServiceBean issueService;

	public String create(IssueDetail issueDetail) {
		issueService.saveOrUpdate(issueDetail);
		// issue= issueDetail;
		setReadonly(true);
		return "successCreateIssue";
	}

	public void edit(IssueDetail issue) {
		setReadonly(false);

	}
	
	public void editDate(IssueDetail issue) {
		setDisabled(false);

	}

	// metod 1) nova instaciq na issue(new IssueDetail) i da setna flaga na
	// false

	public boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	
	public boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
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