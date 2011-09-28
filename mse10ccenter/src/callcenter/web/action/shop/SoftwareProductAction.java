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
    private Map<Long, Integer> amountProducts = new HashMap<Long, Integer>();
    private int numProducts;
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
	if (this.amountProducts.containsKey(software.getId())) {
	    int t = this.amountProducts.get(software.getId());
	    this.amountProducts.put(software.getId(), t + 1);
	} else {
	    addProductItems(software);
	    this.amountProducts.put(software.getId(), 1);
	}
	this.brItems++;

	this.amount = this.amount + software.getPrice();

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

    public int checkProductNum(Product p) {

	if (this.amountProducts.containsKey(p.getId())) {
	    this.numProducts = this.amountProducts.get(p.getId());
	} else {
	    this.numProducts = 0;
	}
	return this.numProducts;
    }

    public double buyHardware(Product hardware) {

	if (this.amountProducts.containsKey(hardware.getId())) {
	    int t = this.amountProducts.get(hardware.getId());
	    this.amountProducts.put(hardware.getId(), t + 1);
	} else {
	    addProductItems(hardware);
	    this.amountProducts.put(hardware.getId(), 1);
	}

	this.brItems++;

	this.amount = this.amount + hardware.getPrice();

	return this.amount;
    }

    public void removeProduct(Product product) {
	this.amount -= product.getPrice();
	this.brItems -= 1;
	if (this.amountProducts.containsKey(product.getId())) {
	    if (this.amountProducts.get(product.getId()) > 1) {
		int t = this.amountProducts.get(product.getId());
		this.amountProducts.put(product.getId(), t - 1);

	    } else {
		this.productItems.remove(product);
		this.amountProducts.remove(product.getId());
	    }
	}

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

    public Map<Long, Integer> getAmountProducts() {
	return amountProducts;
    }

    public void addAmountProducts(Long id, int amount) {
	this.amountProducts.put(id, amount);
    }

    public int getNumProducts() {
	return numProducts;
    }

    public void setNumProducts(int numProducts) {
	this.numProducts = numProducts;
    }

    public double sumPrice(Product p) {
	double value = 0.0;
	value = this.amountProducts.get(p.getId()) * p.getPrice();
	return value;
    }

}
