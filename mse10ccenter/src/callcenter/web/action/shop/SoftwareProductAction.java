package callcenter.web.action.shop;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.products.Software;
import callcenter.service.administration.SoftwareServiceBean;
import callcenter.service.base.BaseServiceBean;
import callcenter.web.action.search.datamodel.JPADataModel;

@SessionScoped
@ManagedBean(name = "softwareProducts")
@SuppressWarnings("rawtypes")
public class SoftwareProductAction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private SoftwareServiceBean service;

	private List<Software> soft;

	private SoftwareDataModel dataModel;

	private static final class SoftwareDataModel extends JPADataModel<Software> {

		private SoftwareDataModel(BaseServiceBean service, BaseDTO dto) {
			super(service, dto, Software.class);
		}

		@Override
		protected Object getId(Software t) {
			return t.getId();
		}
	}

	public Object getDataModel() {
		return dataModel;
	}

	public void setDataModel(SoftwareDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public List<Software> getSoft() {
		soft = service.listAllProjectNames();
		return soft;
	}

	public void setSoft(List<Software> soft) {
		this.soft = soft;
	}
}
