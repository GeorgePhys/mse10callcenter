package callcenter.service.base;

import callcenter.dto.issue.BaseDTO;

public interface BaseService<E, T extends BaseDTO<E>> {

	E saveOrUpdate(E entity);

	E find(Class<E> clazz, Long id);

	void search(T args);
}
