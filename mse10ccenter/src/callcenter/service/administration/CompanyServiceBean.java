package callcenter.service.administration;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import callcenter.dto.company.CompanySearchDTO;
import callcenter.entity.clients.Company;
import callcenter.service.base.BaseServiceBean;
import callcenter.util.ObjectUtil;

@Stateless
public class CompanyServiceBean extends
	BaseServiceBean<Company, CompanySearchDTO> {

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Company> search(CompanySearchDTO args, boolean countOnly) {
	Session session = (Session) getEntityManager().getDelegate();
	Criteria criteria = session.createCriteria(Company.class);

	if (ObjectUtil.isValid(args.getName())) {
	    criteria.add(Restrictions.like("name", args.getName(),
		    MatchMode.ANYWHERE).ignoreCase());
	}
	if (ObjectUtil.isValid(args.getBulstat())) {
	    criteria.add(Restrictions.eq("bulstat", args.getBulstat()));
	}
	if (args.hasAddressCriteria()) {
	    Criteria addressCriteria = criteria.createCriteria("address");
	    if (ObjectUtil.isValid(args.getCountry())) {
		addressCriteria.add(Restrictions.eq("country",
			args.getCountry()));
	    }
	    if (ObjectUtil.isValid(args.getCity())) {
		addressCriteria.add(Restrictions.eq("city", args.getCity()));
	    }
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
