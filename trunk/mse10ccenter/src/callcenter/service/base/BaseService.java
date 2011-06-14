package callcenter.service.base;

import java.util.List;

import callcenter.dto.BaseDTO;

public interface BaseService<E, T extends BaseDTO<E>> {

	E saveOrUpdate(E entity);

	E find(Class<E> clazz, Object id);

	List<E> search(T args, boolean countOnly);

}
