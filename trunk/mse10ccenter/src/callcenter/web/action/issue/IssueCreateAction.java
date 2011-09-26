package callcenter.web.action.issue;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.entity.issue.IssueDetail;
import callcenter.entity.issue.Project;
import callcenter.service.administration.IssueServiceBean;
import callcenter.util.MailSender;
import callcenter.web.action.BaseAction;

@SessionScoped
@ManagedBean(name = "issueCreateAction")
public class IssueCreateAction extends BaseAction<IssueDetail> implements
	Serializable {

    private static final long serialVersionUID = -5533722715840256982L;

    @EJB
    private IssueServiceBean issueService;

    public void create() {
	IssueDetail issue = issueService.saveOrUpdate(getTargetEntity());
	setTargetEntity(issue);
	MailSender.sendCreateIssueMessage(getTargetEntity());
	setReadonly(true);
    }

    public void addProject(Project project) {
	getTargetEntity().setProject(project);
    }

    public void edit(IssueDetail issue) {
	setReadonly(false);
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