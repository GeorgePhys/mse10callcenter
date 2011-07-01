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
		return getEntityManager().merge(entity);
	}

	public void refresh(E e) {
		getEntityManager().refresh(e);
	}

	public E find(Class<E> clazz, Object id) {
		return getEntityManager().find(clazz, id);
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public List<E> search(T args, boolean countOnly) {
		return null;
	}

}
