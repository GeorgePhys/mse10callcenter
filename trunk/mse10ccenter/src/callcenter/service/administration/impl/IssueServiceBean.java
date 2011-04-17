package callcenter.service.administration.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import callcenter.dto.issue.IssueSearchDTO;
import callcenter.entity.issue.IssueDetail;
import callcenter.service.administration.IssuesService;
import callcenter.service.base.BaseServiceBean;

@Stateless
public class IssueServiceBean extends
		BaseServiceBean<IssueDetail, IssueSearchDTO> implements IssuesService {

	@Override
	public void search(IssueSearchDTO args) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(IssueDetail.class);

		if (args.getAssignedTo() != null) {
			criteria.add(Restrictions.eq("assignee", args.getAssignedTo()));
		}

		if (args.getCreatedBy() != null) {
			criteria.add(Restrictions.eq("reporter", args.getCreatedBy()));
		}

		if (args.getDateCreate() != null) {
			criteria.add(Restrictions.eq("dateCreated", args.getDateCreate()));
		}

		if (args.getDateEnded() != null) {
			criteria.add(Restrictions.eq("dateEnded", args.getDateEnded()));
		}

		if (args.getPriority() != null) {
			criteria.add(Restrictions.eq("priority", args.getPriority()));
		}

		if (args.getResolution() != null && !args.getResolution().isEmpty()) {
			criteria.add(Restrictions.in("resolution", args.getResolution()));
		}

		if (args.getStatus() != null) {
			criteria.add(Restrictions.eq("status", args.getStatus()));
		}

		// select * from issueDetail where assignedTo = 'asdasda'
		List list = criteria.list();
		args.setResult(list);
	}
}
