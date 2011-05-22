package callcenter.service.administration;

import callcenter.dto.user.UserSearchDTO;
import callcenter.entity.clients.User;
import callcenter.service.base.BaseService;

public interface UserService extends BaseService<User, UserSearchDTO> {

	String QUERY_EMAIL_EXISTS_KEY = "QUERY_EMAIL_EXISTS_KEY";
	String QUERY_EMAIL_EXISTS = "select u.id from User u where u.mail = :email";

	String QUERY_USER_LOGIN_KEY = "QUERY_USER_LOGIN_KEY";
	String QUERY_USER_LOGIN = "from User u where u.mail = :mail and u.password = :pass";

	boolean userEmailExists(String email);

	User checkLogin(User user);

	String hashPassword(String password);
}
