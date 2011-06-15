package callcenter.service.administration;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import callcenter.dto.user.UserRegistrationKey;

@Singleton
public class UsersPendingConfirmationBean {

	private Map<String, UserRegistrationKey> pending = new HashMap<String, UserRegistrationKey>();

	@Lock(LockType.WRITE)
	public UserRegistrationKey getAndRemove(String uuid) {
		UserRegistrationKey key = pending.get(uuid);
		if (key != null) {
			pending.remove(uuid);
		}
		return key;
	}

	@Lock(LockType.WRITE)
	public void put(String uuid, UserRegistrationKey key) {
		pending.put(uuid, key);
	}

	@Lock(LockType.READ)
	public boolean exists(String uuid) {
		return pending.containsKey(uuid);
	}
}
