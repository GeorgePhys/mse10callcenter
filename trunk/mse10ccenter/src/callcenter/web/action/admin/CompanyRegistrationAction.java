package callcenter.web.action.admin;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.entity.clients.Company;
import callcenter.service.administration.CompanyServiceBean;

@ViewScoped
@ManagedBean(name = "companyRegistrationAction")
public class CompanyRegistrationAction implements Serializable {

	private static final long serialVersionUID = -4532970582110020222L;

	@EJB
	private CompanyServiceBean companyServiceBean;

	public String register(Company company) {
		companyServiceBean.saveOrUpdate(company);
		return null;
	}
}
