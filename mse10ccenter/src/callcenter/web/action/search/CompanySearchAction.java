package callcenter.web.action.search;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.BaseDTO;
import callcenter.dto.company.CompanySearchDTO;
import callcenter.entity.clients.Company;
import callcenter.service.administration.CompanyServiceBean;
import callcenter.service.base.BaseServiceBean;
import callcenter.web.action.search.datamodel.JPADataModel;

@SessionScoped
@ManagedBean(name = "companySearchAction")
@SuppressWarnings("rawtypes")
public class CompanySearchAction implements Serializable {

	private static final long serialVersionUID = -3589498718510276193L;

	@EJB
	private CompanyServiceBean service;

	private CompanyDataModel dataModel;

	private static final class CompanyDataModel extends JPADataModel<Company> {

		private CompanyDataModel(BaseServiceBean service, BaseDTO dto) {
			super(service, dto, Company.class);
		}

		@Override
		protected Object getId(Company t) {
			return t.getId();
		}
	}

	public String search(CompanySearchDTO dto) {
		service.search(dto, true);
		setDataModel(new CompanyDataModel(service, dto));
		return null;
	}

	public Object getDataModel() {
		return dataModel;
	}

	public void setDataModel(CompanyDataModel dataModel) {
		this.dataModel = dataModel;
	}
}
