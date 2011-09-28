/**
 * 
 */
package callcenter.service.administration;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import callcenter.dto.privilege.PrivilegesGroupDTO;
import callcenter.entity.privileges.PrivilegesGroup;
import callcenter.service.base.BaseServiceBean;
import callcenter.util.ObjectUtil;

/**
 * @author bassextremist
 * 
 */
@Stateless
public class PrivilegesGroupServiceBean extends
	BaseServiceBean<PrivilegesGroup, PrivilegesGroupDTO> {

    public static final String QUERY_PRIVILEGES_GROUP_BY_NAME_KEY = "QUERY_PRIVILEGES_GROUP_BY_NAME_KEY";
    public static final String QUERY_PRIVILEGES_GROUP_BY_NAME = "from PrivilegesGroup pg where pg.name = :name";

    public List<PrivilegesGroup> getPrivilegesGroupByName(String name) {
	Query query = getEntityManager().createNamedQuery(
		QUERY_PRIVILEGES_GROUP_BY_NAME_KEY);
	query.setParameter("name", name);
	return query.getResultList();
    }

    @Override
    public List<PrivilegesGroup> search(PrivilegesGroupDTO args,
	    boolean countOnly) {
	Session session = (Session) getEntityManager().getDelegate();
	Criteria criteria = session.createCriteria(PrivilegesGroup.class);

	if (ObjectUtil.isValid(args.getName())) {
	    criteria.add(Restrictions.eq("name", args.getName()));
	}

	if (ObjectUtil.isValid(args.getDescription())) {
	    criteria.add(Restrictions.eq("description", args.getDescription()));

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
