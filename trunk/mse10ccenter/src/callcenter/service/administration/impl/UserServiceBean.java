package callcenter.service.administration.impl;

import static callcenter.util.ObjectUtil.isValid;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import callcenter.dto.user.UserSearchDTO;
import callcenter.entity.clients.User;
import callcenter.service.administration.UserService;
import callcenter.service.base.BaseServiceBean;
import callcenter.util.ObjectUtil;

@Stateless
public class UserServiceBean extends BaseServiceBean<User, UserSearchDTO>
		implements UserService {

	@Override
	public void search(UserSearchDTO args) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(User.class);

		if (StringUtils.isNotEmpty(args.getMail())) {
			criteria.add(Restrictions.eq("mail", args.getMail()));
		}

		if (StringUtils.isNotEmpty(args.getFullName())) {
			criteria.add(Restrictions.like("fullName", args.getFullName(),
					MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotEmpty(args.getCountry())) {
			criteria.add(Restrictions.eq("country", args.getCountry()));
		}

		if (StringUtils.isNotEmpty(args.getCity())) {
			criteria.add(Restrictions.eq("city", args.getCity()));
		}

		if (StringUtils.isNotEmpty(args.getStreet())) {
			criteria.add(Restrictions.like("street", args.getStreet(),
					MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotEmpty(args.getPostCode())) {
			criteria.add(Restrictions.eq("postCode", args.getPostCode()));
		}

		if (StringUtils.isNotEmpty(args.getPhone())) {
			criteria.add(Restrictions.eq("phone", args.getPhone()));
		}

		if (StringUtils.isNotEmpty(args.getPassword())) {
			criteria.add(Restrictions.eq("password", args.getPassword()));
		}

		List list = criteria.list();
		args.setResult(list);
	}

	@Override
	public boolean userEmailExists(String email) {
		Query emailExistsQuery = getEntityManager().createNamedQuery(
				QUERY_EMAIL_EXISTS_KEY);
		if (StringUtils.isNotEmpty(email)) {
			emailExistsQuery.setParameter("email", email);
			emailExistsQuery.setMaxResults(1);
			List list = emailExistsQuery.getResultList();
			return isValid(list);
		}
		return false;
	}

	@Override
	public User checkLogin(User user) {
		Query queryLoginUser = getEntityManager().createNamedQuery(
				QUERY_USER_LOGIN_KEY);
		queryLoginUser.setParameter("mail", user.getMail());
		queryLoginUser.setParameter("pass", user.getPassword());

		@SuppressWarnings("unchecked")
		List<User> resultList = queryLoginUser.getResultList();
		if (ObjectUtil.isValid(resultList)) {
			return resultList.get(0);
		}
		return null;
	}

}
