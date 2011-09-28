package callcenter.web.action.admin;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.entity.products.Product;
import callcenter.service.administration.ProductServiceBean;
import callcenter.web.action.BaseAction;

@SessionScoped
@ManagedBean(name = "productRegistrationAction")
public class ProductRegistrationAction extends BaseAction<Product> {

	@EJB
	private ProductServiceBean service;

	public String init() {
		setTargetEntity(new Product());
		setReadonly(false);
		return "createProduct";
	}

	public String register() {
		Product product = service.saveOrUpdate(getTargetEntity());
		setTargetEntity(product);
		setReadonly(true);
		return null;
	}
}
