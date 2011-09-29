package callcenter.service.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Cache for all messages from the database.
 * 
 * @author yasko
 * 
 */
@Startup
@Singleton
public class MessagesCache {

    public static final String QUERY_LOAD_ALL_MESSAGES_EN_KEY = "QUERY_LOAD_ALL_MESSAGES_EN_KEY";
    public static final String QUERY_LOAD_ALL_MESSAGES_EN = "select v.valueCode, v.valueEn from Value v inner join v.holder h where h.code = 1000";

    public static final String QUERY_LOAD_ALL_MESSAGES_BG_KEY = "QUERY_LOAD_ALL_MESSAGES_BG_KEY";
    public static final String QUERY_LOAD_ALL_MESSAGES_BG = "select v.valueCode, v.valueBg from Value v inner join v.holder h where h.code = 1000";

    @PersistenceContext
    private EntityManager entityManager;

    private Map<String, String> messagesEn;
    private Map<String, String> messagesBg;

    /**
     * Initializes the cache right after the bean has been instantiated.
     */
    @PostConstruct
    public void init() {
	Query messagesEnQuery = entityManager
		.createNamedQuery(QUERY_LOAD_ALL_MESSAGES_EN_KEY);
	@SuppressWarnings("unchecked")
	List<Object[]> messagesEnResult = messagesEnQuery.getResultList();
	Map<String, String> msgEn = new HashMap<String, String>();
	for (Object[] objects : messagesEnResult) {
	    msgEn.put((String) objects[0], (String) objects[1]);
	}
	messagesEn = Collections.unmodifiableMap(msgEn);

	Query messagesBgQuery = entityManager
		.createNamedQuery(QUERY_LOAD_ALL_MESSAGES_BG_KEY);
	@SuppressWarnings("unchecked")
	List<Object[]> messagesBgResult = messagesBgQuery.getResultList();
	Map<String, String> msgBg = new HashMap<String, String>();
	for (Object[] objects : messagesBgResult) {
	    msgBg.put((String) objects[0], (String) objects[1]);
	}
	messagesBg = Collections.unmodifiableMap(msgBg);
    }

    /**
     * Retrieves the English version of a message from the cache by the
     * specified key.
     * 
     * @param key
     *            Message key.
     * @return the corresponding message or empty string if no message for that
     *         key exists.
     */
    public String getMessageEn(String key) {
	String message = messagesEn.get(key);
	if (message == null) {
	    return "!MISSING VALUE FOR KEY: " + key;
	}
	return message;
    }

    /**
     * Retrieves the Bulgarian version of a message from the cache by the
     * specified key.
     * 
     * @param key
     *            Message key.
     * @return the corresponding message or empty string if no message for that
     *         key exists.
     */
    public String getMessageBg(String key) {
	String message = messagesBg.get(key);
	if (message == null) {
	    return "!MISSING VALUE FOR KEY: " + key;
	}
	return message;
    }

    public String getMessage(String localeCode, String messageKey) {
	if ("bg_BG".equalsIgnoreCase(localeCode)) {
	    return getMessageBg(messageKey);
	} else {
	    return getMessageEn(messageKey);
	}
    }
}
