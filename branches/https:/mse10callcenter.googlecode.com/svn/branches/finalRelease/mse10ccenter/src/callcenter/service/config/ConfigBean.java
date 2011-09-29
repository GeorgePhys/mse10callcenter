package callcenter.service.config;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import callcenter.entity.clients.Role;
import callcenter.entity.clients.User;
import callcenter.service.administration.UserServiceBean;
import callcenter.util.ObjectUtil;
import callcenter.util.PasswordHashUtil;

@Startup
@Singleton
public class ConfigBean {

    public static final String SYS_ADMIN_EMAIL = "noreply.ccenter@gmail.com";

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private UserServiceBean userServiceBean;

    @PostConstruct
    public void configure() {
	User admin = userServiceBean.getUserByEmail(ConfigBean.SYS_ADMIN_EMAIL);
	if (!ObjectUtil.isValid(admin)) {
	    admin = new User();
	    admin.setRole(Role.ADMIN);
	    admin.setConfirmed(Boolean.TRUE);
	    admin.setMail(ConfigBean.SYS_ADMIN_EMAIL);
	    admin.setFullName("Initial System User");
	    admin.setAddress(null);
	    try {
		admin.setPassword(PasswordHashUtil
			.getPasswordHash("1234567890"));
	    } catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	    }
	    entityManager.persist(admin);
	}
    }
}
