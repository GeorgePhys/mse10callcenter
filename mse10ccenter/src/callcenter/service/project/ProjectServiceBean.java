package callcenter.service.project;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import callcenter.dto.issue.IssueSearchDTO;
import callcenter.dto.project.ProjectSearchDTO;
import callcenter.entity.issue.IssueDetail;
import callcenter.entity.issue.Project;
import callcenter.service.base.BaseServiceBean;
import callcenter.util.ObjectUtil;

@Stateless
public class ProjectServiceBean extends
		BaseServiceBean<Project, ProjectSearchDTO> {

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Project> search(ProjectSearchDTO args, boolean countOnly) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(IssueDetail.class);
		
		if (StringUtils.isNotEmpty(args.getProjectName())) {
			criteria.add(Restrictions.eq("projectName", args.getProjectName()));
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
