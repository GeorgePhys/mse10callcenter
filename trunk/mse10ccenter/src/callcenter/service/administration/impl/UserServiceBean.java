package callcenter.service.administration.impl;

import static callcenter.util.ObjectUtil.isValid;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;

import callcenter.dto.user.UserSearchDTO;
import callcenter.entity.clients.User;
import callcenter.service.administration.UserService;
import callcenter.service.base.BaseServiceBean;

@Stateless
public class UserServiceBean extends BaseServiceBean<User, UserSearchDTO>
		implements UserService {

	@Override
	public void search(UserSearchDTO args) {

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
	public boolean checkLogin(User user) {
		return false;
	}

}
