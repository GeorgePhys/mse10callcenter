package callcenter.timers;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import callcenter.dto.user.UserRegistrationKey;
import callcenter.entity.clients.User;
import callcenter.util.ObjectUtil;

@LocalBean
@Singleton
public class UserRegistrationTimer {

    @Resource
    private SessionContext context;

    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void scheduleUserRegistrationCheck(UserRegistrationKey key,
	    Date expirationDate) {
	TimerService timerService = context.getTimerService();
	TimerConfig config = new TimerConfig(key, true);
	timerService.createSingleActionTimer(expirationDate, config);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void cancelTimer(Long id, String uuid) {
	Collection<Timer> timers = context.getTimerService().getTimers();
	if (ObjectUtil.isValid(timers)) {
	    for (Timer timer : timers) {
		Serializable info = timer.getInfo();
		if (info instanceof UserRegistrationKey) {
		    UserRegistrationKey key = (UserRegistrationKey) info;
		    if (id.equals(key.getId()) && uuid.equals(key.getUuid())) {
			timer.cancel();
			break;
		    }
		}
	    }
	}
    }

    @Timeout
    public void timerTimeout(Timer timer) {
	Long userId = ((UserRegistrationKey) timer.getInfo()).getId();
	System.out.println("deleting user " + userId);
	User user = entityManager.find(User.class, userId);
	entityManager.remove(user);
    }
}
