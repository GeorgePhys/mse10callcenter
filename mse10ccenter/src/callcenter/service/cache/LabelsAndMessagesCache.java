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

@Startup
@Singleton
public class LabelsAndMessagesCache {

    public static final String QUERY_LOAD_ALL_MESSAGES_EN_KEY = "QUERY_LOAD_ALL_MESSAGES_EN_KEY";
    public static final String QUERY_LOAD_ALL_MESSAGES_EN = "select v.valueCode, v.valueEn from Value v inner join v.holder h where h.code = 1000";

    public static final String QUERY_LOAD_ALL_MESSAGES_BG_KEY = "QUERY_LOAD_ALL_MESSAGES_BG_KEY";
    public static final String QUERY_LOAD_ALL_MESSAGES_BG = "select v.valueCode, v.valueBg from Value v inner join v.holder h where h.code = 1000";

    @PersistenceContext
    private EntityManager entityManager;

    private Map<String, String> messagesEn = Collections
	    .unmodifiableMap(new HashMap<String, String>());
    private Map<String, String> messagesBg = Collections
	    .unmodifiableMap(new HashMap<String, String>());

    @PostConstruct
    public void init() {
	Query messagesEnQuery = entityManager
		.createNamedQuery(QUERY_LOAD_ALL_MESSAGES_EN_KEY);
	@SuppressWarnings("unchecked")
	List<Object[]> messagesEnResult = messagesEnQuery.getResultList();
	for (Object[] objects : messagesEnResult) {
	    messagesEn.put((String) objects[0], (String) objects[1]);
	}

	Query messagesBgQuery = entityManager
		.createNamedQuery(QUERY_LOAD_ALL_MESSAGES_BG_KEY);
	@SuppressWarnings("unchecked")
	List<Object[]> messagesBgResult = messagesBgQuery.getResultList();
	for (Object[] objects : messagesBgResult) {
	    messagesBg.put((String) objects[0], (String) objects[1]);
	}
    }
}
