package callcenter.service.administration;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import callcenter.entity.issue.IssueDetail;
import callcenter.entity.issue.dto.IssueSearchDTO;
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

		// select * from issueDetail where assignedTo = 'asdasda'
		List list = criteria.list();
	}

}
