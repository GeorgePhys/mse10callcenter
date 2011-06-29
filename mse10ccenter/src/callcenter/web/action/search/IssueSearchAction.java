package callcenter.web.action.search;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.service.administration.IssueServiceBean;

@SessionScoped
@ManagedBean(name = "issueSearchAction")
public class IssueSearchAction {

	@EJB
	private IssueServiceBean service;
}