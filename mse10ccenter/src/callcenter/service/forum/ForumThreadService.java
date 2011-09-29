package callcenter.service.forum;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import callcenter.dto.forum.ThreadDTO;
import callcenter.entity.forum.ForumThread;
import callcenter.service.base.BaseServiceBean;
import callcenter.util.ObjectUtil;

@Stateless
public class ForumThreadService extends BaseServiceBean<ForumThread, ThreadDTO> {

    @Override
    public List<ForumThread> search(ThreadDTO args, boolean countOnly) {
	Session session = (Session) getEntityManager().getDelegate();
	Criteria criteria = session.createCriteria(ForumThread.class);

	if (ObjectUtil.isValid(args.getTitle())) {
	    criteria.add(Restrictions.like("title", args.getTitle(),
		    MatchMode.ANYWHERE).ignoreCase());
	}

	if (ObjectUtil.isValid(args.getText())) {
	    criteria.add(Restrictions.like("text", args.getText(),
		    MatchMode.ANYWHERE).ignoreCase());
	}

	if (ObjectUtil.isValid(args.getOwner())) {
	    criteria.createAlias("createdBy", "u");
	    criteria.add(Restrictions.like("u.fullName", args.getOwner(),
		    MatchMode.ANYWHERE).ignoreCase());
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
