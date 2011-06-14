package callcenter.service.administration.impl;

import static callcenter.util.ObjectUtil.isValid;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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

import callcenter.dto.user.UserSearchDTO;
import callcenter.entity.clients.User;
import callcenter.service.administration.UserService;
import callcenter.service.base.BaseServiceBean;
import callcenter.util.ObjectUtil;
import callcenter.util.PasswordHashUtil;

@Stateless
public class UserServiceBean extends BaseServiceBean<User, UserSearchDTO>
		implements UserService {

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<User> search(UserSearchDTO args, boolean countOnly) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(User.class);

		if (ObjectUtil.isValid(args.getMail())) {
			criteria.add(Restrictions.eq("mail", args.getMail()));
		}

		if (ObjectUtil.isValid(args.getFullName())) {
			criteria.add(Restrictions.like("fullName", args.getFullName(),
					MatchMode.ANYWHERE).ignoreCase());
		}

		if (ObjectUtil.isValid(args.getCountry())) {
			criteria.add(Restrictions.eq("country", args.getCountry()));
		}

		if (ObjectUtil.isValid(args.getCity())) {
			criteria.add(Restrictions.eq("city", args.getCity()));
		}

		if (ObjectUtil.isValid(args.getStreet())) {
			criteria.add(Restrictions.like("street", args.getStreet(),
					MatchMode.ANYWHERE).ignoreCase());
		}

		if (ObjectUtil.isValid(args.getPostCode())) {
			criteria.add(Restrictions.eq("postCode", args.getPostCode()));
		}

		if (ObjectUtil.isValid(args.getPhone())) {
			criteria.add(Restrictions.eq("phone", args.getPhone()));
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

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
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
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
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

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public String hashPassword(String password) {
		String hash = null;
		try {
			hash = PasswordHashUtil.getPasswordHash(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return hash;
	}
}
