package callcenter.web.action.issue;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.entity.issue.IssueDetail;
import callcenter.service.administration.IssueServiceBean;

@ViewScoped
@ManagedBean(name = "issueEditAction")
public class IssueEditAction implements Serializable {

	private static final long serialVersionUID = -5533722715840256982L;

	@EJB
	private IssueServiceBean issueService;

	public String edit(IssueDetail issueDetail) {
		issueService.saveOrUpdate(issueDetail);
		return "editIssue";
	}
}


