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
 * Cache for all labels from the database.
 * 
 * @author yasko
 * 
 */
@Startup
@Singleton
public class LabelsCache {

    public static final String QUERY_LOAD_ALL_LABELS_EN_KEY = "QUERY_LOAD_ALL_LABELS_EN_KEY";
    public static final String QUERY_LOAD_ALL_LABELS_EN = "select v.valueCode, v.valueEn from Value v inner join v.holder h where h.code = 1001";

    public static final String QUERY_LOAD_ALL_LABELS_BG_KEY = "QUERY_LOAD_ALL_LABELS_BG_KEY";
    public static final String QUERY_LOAD_ALL_LABELS_BG = "select v.valueCode, v.valueBg from Value v inner join v.holder h where h.code = 1001";

    @PersistenceContext
    private EntityManager entityManager;

    private Map<String, String> labelsEn = Collections
	    .unmodifiableMap(new HashMap<String, String>());
    private Map<String, String> labelsBg = Collections
	    .unmodifiableMap(new HashMap<String, String>());

    /**
     * Initializes the cache right after the bean has been instantiated.
     */
    @PostConstruct
    public void init() {
	Query labelsEnQuery = entityManager
		.createNamedQuery(QUERY_LOAD_ALL_LABELS_EN_KEY);
	@SuppressWarnings("unchecked")
	List<Object[]> labelsEnResult = labelsEnQuery.getResultList();
	for (Object[] objects : labelsEnResult) {
	    labelsEn.put((String) objects[0], (String) objects[1]);
	}

	Query labelsBgQuery = entityManager
		.createNamedQuery(QUERY_LOAD_ALL_LABELS_BG_KEY);
	@SuppressWarnings("unchecked")
	List<Object[]> labelsBgResult = labelsBgQuery.getResultList();
	for (Object[] objects : labelsBgResult) {
	    labelsBg.put((String) objects[0], (String) objects[1]);
	}
    }

    /**
     * Retrieves the English version of a label from the cache by the specified
     * key.
     * 
     * @param key
     *            Labels key.
     * @return the corresponding label or empty string if no label for that key
     *         exists.
     */
    public String getLabelsEn(String key) {
	String labels = labelsEn.get(key);
	if (labels == null) {
	    return "";
	}
	return labels;
    }

    /**
     * Retrieves the Bulgarian version of a label from the cache by the
     * specified key.
     * 
     * @param key
     *            Label key.
     * @return the corresponding label or empty string if no label for that key
     *         exists.
     */
    public String getLabelBg(String key) {
	String label = labelsBg.get(key);
	if (label == null) {
	    return "";
	}
	return label;
    }
}
