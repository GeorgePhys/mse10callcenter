package callcenter.service.administration;

import callcenter.dto.user.UserSearchDTO;
import callcenter.entity.clients.User;
import callcenter.service.base.BaseService;

public interface UserService extends BaseService<User, UserSearchDTO> {

	String QUERY_EMAIL_EXISTS_KEY = "QUERY_EMAIL_EXISTS_KEY";
	String QUERY_EMAIL_EXISTS = "select u.id from User u where u.mail = :email";

	boolean userEmailExists(String email);

	boolean checkLogin(User user);
}
