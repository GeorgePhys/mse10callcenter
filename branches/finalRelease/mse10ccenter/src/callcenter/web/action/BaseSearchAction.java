package callcenter.web.action;

import javax.faces.bean.ManagedProperty;

import callcenter.dto.BaseDTO;
import callcenter.entity.Entity;
import callcenter.service.base.BaseServiceBean;
import callcenter.web.action.search.datamodel.JPADataModel;

public abstract class BaseSearchAction<E extends Entity, T extends BaseDTO<E>> {

    private JPADataModel<E> dataModel;

    @ManagedProperty("#{baseAction}")
    private BaseAction baseAction;

    public abstract String previewSearchResult(E result);

    public void search(T args) {
	getService().search(args, true);
	setDataModel(new JPADataModel<E>(getService(), args, getEntityClass()));
    }

    public abstract <S extends BaseServiceBean<E, T>> S getService();

    public abstract Class<E> getEntityClass();

    public JPADataModel<E> getDataModel() {
	return dataModel;
    }

    public void setDataModel(JPADataModel<E> dataModel) {
	this.dataModel = dataModel;
    }

    /**
     * @return the baseAction
     */
    public BaseAction getBaseAction() {
	return baseAction;
    }

    /**
     * @param baseAction
     *            the baseAction to set
     */
    public void setBaseAction(BaseAction baseAction) {
	this.baseAction = baseAction;
    }
}
