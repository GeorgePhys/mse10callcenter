package callcenter.web.action.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.products.Product;
import callcenter.service.administration.ProductServiceBean;
import callcenter.service.base.BaseServiceBean;
import callcenter.web.action.BaseAction;
import callcenter.web.action.search.datamodel.JPADataModel;

@SessionScoped
@ManagedBean(name = "softwareProducts")
@SuppressWarnings("rawtypes")
public class SoftwareProductAction extends BaseAction implements Serializable {

    @EJB
    private ProductServiceBean service;

    private List<Product> productItems = new ArrayList<Product>();
    private List<Product> soft;

    private SoftwareDataModel dataModel;
    private int brItems = 0;
    private double amount = 0.0;
    private Map<String, Boolean> disable = new HashMap<String, Boolean>();

    private static final class SoftwareDataModel extends JPADataModel<Product> {

	private SoftwareDataModel(BaseServiceBean service, BaseDTO dto) {
	    super(service, dto, Product.class);
	}

	@Override
	protected Object getId(Product t) {
	    return t.getId();
	}
    }

    /**
     * 
     * @param s
     * @return
     */
    @SuppressWarnings("unchecked")
    public String openSlectedProduct(Product s) {
	setTargetEntity(s);

	return "reviewSoftwareProduct";
    }

    public Object getDataModel() {
	return dataModel;
    }

    public void setDataModel(SoftwareDataModel dataModel) {
	this.dataModel = dataModel;
    }

    public List<Product> getSoft() {
	soft = service.getAllSoftware();
	return soft;
    }

    /**
     * TEMP
     * 
     * @return key for walk index - > products
     */
    public String allSoftware() {
	this.soft = service.getAllSoftware();
	return "AllSoftware";
    }

    public void setSoft(List<Product> soft) {
	this.soft = soft;
    }

    /**
     * 
     * @param software
     * @return
     */
    public double buy(Product software) {
	if (!this.disable.containsKey(software.getProductName())) {
	    // increase number of products that are buying
	    addProductItems(software);
	    this.brItems++;
	    this.amount = this.amount + software.getPrice();
	    this.disable.put(software.getProductName(), Boolean.TRUE);
	}
	return this.amount;
    }

    public String cartStatus() {
	return "ShappingCart";
    }

    public String checkProductType(Product product) {
	if (product.getType().name() == "SOFTWARE") {
	    return "Software";
	}
	return "Hardware";
    }

    public double buyHardware(Product hardware) {
	if (!this.disable.containsKey(hardware.getProductName())) {
	    // increase number of products that are buying
	    addProductItems(hardware);
	    this.brItems++;
	    this.amount = this.amount + hardware.getPrice();
	    this.disable.put(hardware.getProductName(), Boolean.TRUE);
	}
	return this.amount;
    }

    public void clearChart() {
	this.amount = 0.0;
	this.brItems = 0;
	this.disable.clear();
    }

    public int getBrItems() {
	return brItems;
    }

    public void setBrItems(int brItems) {
	this.brItems = brItems;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    public Map<String, Boolean> getDisable() {
	return disable;
    }

    public void setDisable(Map<String, Boolean> disable) {
	this.disable = disable;
    }

    public List<Product> getProductItems() {
	return productItems;
    }

    public void addProductItems(Product productItems) {
	this.productItems.add(productItems);
    }

}
