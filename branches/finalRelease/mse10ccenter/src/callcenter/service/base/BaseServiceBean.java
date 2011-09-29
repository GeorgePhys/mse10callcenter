package callcenter.service.base;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import callcenter.dto.BaseDTO;

@Stateless
public class BaseServiceBean<E, T extends BaseDTO<E>> {

    @PersistenceContext(unitName = "ccenter")
    protected EntityManager entityManager;

    public E saveOrUpdate(E entity) {
	return save(entity);
    }

    public <C> C save(C c) {
	return getEntityManager().merge(c);
    }

    public void refresh(E e) {
	getEntityManager().refresh(e);
    }

    public E find(Class<E> clazz, Object id) {
	return getEntityManager().find(clazz, id);
    }

    public EntityManager getEntityManager() {
	return entityManager;
    }

    public List<E> search(T args, boolean countOnly) {
	return null;
    }

}
