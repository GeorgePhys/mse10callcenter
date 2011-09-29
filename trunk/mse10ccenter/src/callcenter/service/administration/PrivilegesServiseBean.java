/**
 * 
 */
package callcenter.service.administration;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import callcenter.entity.privileges.Privilege;

/**
 * @author bassextremist
 * 
 */
@Stateful
public class PrivilegesServiseBean {

    public static final String QUERY_PRIVILEGES_BY_AREA_KEY = "QUERY_PRIVILEGES_BY_AREA_KEY";
    public static final String QUERY_PRIVILEGES_BY_AREA = "from Privilege p where p.entityArea = :area";

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    // @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public <E> E save(E e) {
	return getEntityManager().merge(e);
    }

    public <E> E find(Class<E> clazz, Object id) {
	return getEntityManager().find(clazz, id);
    }

    public <K> K load(Class<K> clazz, Object id) {
	return getEntityManager().find(clazz, id);
    }

    protected EntityManager getEntityManager() {
	return entityManager;
    }

    public List<Privilege> getPrivilegesByArea(String entityArea) {
	Query query = getEntityManager().createNamedQuery(
		QUERY_PRIVILEGES_BY_AREA_KEY);
	query.setParameter("area", entityArea);
	return query.getResultList();
    }
}