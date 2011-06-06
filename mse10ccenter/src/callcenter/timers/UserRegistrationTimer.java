package callcenter.timers;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
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
public class UserRegistrationTimer {

	@Resource
	private SessionContext context;

	@PersistenceContext
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void scheduleUserRegistrationCheck(User user) {
		TimerService timerService = context.getTimerService();
		TimerConfig config = new TimerConfig(new UserRegistrationKey(
				user.getMail(), user.getId()), true);
		timerService.createSingleActionTimer(2000L, config);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void cancelTimer(User user) {
		Collection<Timer> timers = context.getTimerService().getTimers();
		if (ObjectUtil.isValid(timers)) {
			for (Timer timer : timers) {
				Serializable info = timer.getInfo();
				if (info instanceof UserRegistrationKey) {
					UserRegistrationKey key = (UserRegistrationKey) info;
					String mail = user.getMail();
					Long id = user.getId();
					if (id.equals(key.getId()) && mail.equals(key.getEmail())) {
						timer.cancel();
						break;
					}
				}
			}
		}
	}

	@Timeout
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void timerTimeout(Timer timer) {
		Long userId = ((UserRegistrationKey) timer.getInfo()).getId();
		User user = entityManager.find(User.class, userId);
		entityManager.remove(user);
	}
}
