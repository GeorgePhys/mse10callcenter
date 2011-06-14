package callcenter.web.action.search.datamodel;

import java.util.List;

import javax.faces.context.FacesContext;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;

import callcenter.dto.BaseDTO;
import callcenter.service.base.BaseService;

@SuppressWarnings("rawtypes")
public abstract class JPADataModel<T> extends ExtendedDataModel<T> {

	private BaseService service;

	private BaseDTO dto;

	private Object rowKey;

	private Class<T> entityClass;

	public JPADataModel(BaseService service, BaseDTO dto, Class<T> entityClass) {
		this.service = service;
		this.entityClass = entityClass;
		this.dto = dto;
	}

	@Override
	public void setRowKey(Object key) {
		rowKey = key;
	}

	@Override
	public Object getRowKey() {
		return rowKey;
	}

	@Override
	public void walk(FacesContext context, DataVisitor visitor, Range range,
			Object argument) {
		SequenceRange sequenceRange = (SequenceRange) range;
		dto.setFirstResult(sequenceRange.getFirstRow());
		dto.setMaxResults(sequenceRange.getRows());

		List<T> data = service.search(dto, false);
		for (T t : data) {
			visitor.process(context, getId(t), argument);
		}
	}

	@Override
	public boolean isRowAvailable() {
		return rowKey != null;
	}

	@Override
	public int getRowCount() {
		return dto.getTotalNumberOfRows();
	}

	@Override
	public T getRowData() {
		return (T) service.find(entityClass, rowKey);
	}

	@Override
	public int getRowIndex() {
		return -1;
	}

	@Override
	public void setRowIndex(int rowIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getWrappedData() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setWrappedData(Object data) {
		throw new UnsupportedOperationException();
	}

	// TODO - implement using metadata
	protected abstract Object getId(T t);
}