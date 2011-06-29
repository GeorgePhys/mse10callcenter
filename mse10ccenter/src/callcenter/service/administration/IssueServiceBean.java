package callcenter.service.administration;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import callcenter.dto.issue.IssueSearchDTO;
import callcenter.entity.issue.IssueDetail;
import callcenter.service.base.BaseServiceBean;
import callcenter.util.ObjectUtil;

@Stateless
public class IssueServiceBean extends
		BaseServiceBean<IssueDetail, IssueSearchDTO> {

	@Override
	public List<IssueDetail> search(IssueSearchDTO args, boolean countOnly) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(IssueDetail.class);

		if (StringUtils.isNotEmpty(args.getAssignedTo())) {
			criteria.add(Restrictions.eq("assignee", args.getAssignedTo()));
		}

		if (StringUtils.isNotEmpty(args.getCreatedBy())) {
			criteria.add(Restrictions.eq("reporter", args.getCreatedBy()));
		}

		if (ObjectUtil.isValid(args.getDateCreate())) {
			criteria.add(Restrictions.eq("dateCreated", args.getDateCreate()));
		}

		if (ObjectUtil.isValid(args.getDateEnded())) {
			criteria.add(Restrictions.eq("dateEnded", args.getDateEnded()));
		}

		if (StringUtils.isNotEmpty(args.getPriority())) {
			criteria.add(Restrictions.eq("priority", args.getPriority()));
		}

		if (ObjectUtil.isValid(args.getResolution())) {
			criteria.add(Restrictions.in("resolution", args.getResolution()));
		}

		if (StringUtils.isNotEmpty(args.getStatus())) {
			criteria.add(Restrictions.eq("status", args.getStatus()));
		}

		if (countOnly) {
			criteria.setProjection(Projections.count("id"));
			Number count = (Number) criteria.list().get(0);
			if (count == null || count.intValue() == 0) {
				args.setTotalNumberOfRows(0);
			} else {
				args.setTotalNumberOfRows(count.intValue());
			}
			return null;
		}

		criteria.setMaxResults(args.getMaxResults());
		criteria.setFirstResult(args.getFirstResult());

		List list = criteria.list();
		return list;
	}
}
