package callcenter.web.action.admin;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import callcenter.entity.products.Product;
import callcenter.entity.products.Product.ProductType;
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

	private List<String> allTypes = Arrays.asList("Software", "Hardware");
	private String selectedType;

	public List<String> getAllTypes() {
		return allTypes;
	}

	public String getSelectedType() {
		return selectedType;
	}

	public void setSelectedType(String selectedType) {
		this.selectedType = selectedType;
	}

	public void typeCodeChanged(ValueChangeEvent e) {
		String newValue = e.getNewValue().toString();
		if ("Software".equals(newValue)) {
			getTargetEntity().setType(ProductType.SOFTWARE);
		} else {
			getTargetEntity().setType(ProductType.HARDWARE);
		}
	}

	public boolean isHardwareSelected() {
		return "Hardware".equals(getSelectedType());
	}
}
