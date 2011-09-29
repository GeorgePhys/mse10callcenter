package callcenter.service.forum;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@LocalBean
@Stateful
public class ForumServiceBean {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public <E> E save(E e) {
	return getEntityManager().merge(e);
    }

    public <E> E find(Class<E> clazz, Object id) {
	return getEntityManager().find(clazz, id);
    }

    protected EntityManager getEntityManager() {
	return entityManager;
    }
}
