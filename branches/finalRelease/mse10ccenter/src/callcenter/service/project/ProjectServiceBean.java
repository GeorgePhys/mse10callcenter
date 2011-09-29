package callcenter.service.project;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import callcenter.dto.project.ProjectSearchDTO;
import callcenter.entity.issue.Project;
import callcenter.service.base.BaseServiceBean;

@Stateless
public class ProjectServiceBean extends
	BaseServiceBean<Project, ProjectSearchDTO> {

    public static final String QUERY_ALL_PROJECT_NAMES_KEY = "QUERY_ALL_PROJECT_NAMES_KEY";
    public static final String QUERY_ALL_PROJECT_NAMES = "select p.name from Project p";

    @Override
    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Project> search(ProjectSearchDTO args, boolean countOnly) {
	Session session = (Session) getEntityManager().getDelegate();
	Criteria criteria = session.createCriteria(Project.class);

	if (StringUtils.isNotEmpty(args.getProjectName())) {
	    criteria.add(Restrictions.like("name", args.getProjectName(),
		    MatchMode.ANYWHERE).ignoreCase());
	}
	if (StringUtils.isNotEmpty(args.getProjectShortName())) {
	    criteria.add(Restrictions.eq("shortName",
		    args.getProjectShortName()));
	}
	if (StringUtils.isNotEmpty(args.getDescription())) {
	    criteria.add(Restrictions.like("description",
		    args.getDescription(), MatchMode.ANYWHERE).ignoreCase());
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

	List<Project> list = criteria.list();
	return list;
    }

    @SuppressWarnings("unchecked")
    public List<String> listAllProjectNames() {
	Query query = getEntityManager().createNamedQuery(
		QUERY_ALL_PROJECT_NAMES_KEY);
	return query.getResultList();
    }
}
