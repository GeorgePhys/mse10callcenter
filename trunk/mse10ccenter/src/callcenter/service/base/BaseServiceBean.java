package callcenter.service.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import callcenter.dto.BaseDTO;

@Stateless
public abstract class BaseServiceBean<E, T extends BaseDTO<E>> implements
		BaseService<E, T> {

	@PersistenceContext(unitName = "ccenter")
	protected EntityManager entityManager;

	@Override
	public E saveOrUpdate(E entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public E find(Class<E> clazz, Long id) {
		return getEntityManager().find(clazz, id);
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
