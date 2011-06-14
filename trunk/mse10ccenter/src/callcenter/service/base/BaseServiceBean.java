package callcenter.service.base;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import callcenter.dto.BaseDTO;

@Stateless
public class BaseServiceBean<E, T extends BaseDTO<E>> implements
		BaseService<E, T> {

	@PersistenceContext(unitName = "ccenter")
	protected EntityManager entityManager;

	@Override
	public E saveOrUpdate(E entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public E find(Class<E> clazz, Object id) {
		return getEntityManager().find(clazz, id);
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public List<E> search(T args, boolean countOnly) {
		return null;
	}

}
