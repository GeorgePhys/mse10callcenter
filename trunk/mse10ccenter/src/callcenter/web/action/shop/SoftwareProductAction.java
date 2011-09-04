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
	private List<Software> specific;
	private SoftwareDataModel dataModel;
	private int brItems = 0;
	private double amount = 0.0;

	private static final class SoftwareDataModel extends JPADataModel<Software> {

		private SoftwareDataModel(BaseServiceBean service, BaseDTO dto) {
			super(service, dto, Software.class);
		}

		@Override
		protected Object getId(Software t) {
			return t.getId();
		}
	}

	public String openSlectedProduct(Software s) {
		this.specific = service.findByName(s.getProductName());
		return "reviewSoftwareProduct";
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

	/**
	 * TEMP
	 * 
	 * @return key for walk index - > products
	 */
	public String allSoftware() {
		return "AllSoftware";
	}

	public void setSoft(List<Software> soft) {
		this.soft = soft;
	}

	/**
	 * Buy a product
	 * 
	 * @param software
	 *            product for buying
	 * @return price of the product
	 */
	public double buy(Software software) {
		// increase number of products that are buying
		this.brItems++;
		this.amount = this.amount + software.getPrice();
		return this.amount;
	}

	public void clearChart() {
		this.amount = 0.0;
		this.brItems = 0;
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

	public List<Software> getSpecific() {
		return specific;
	}

	public void setSpecific(List<Software> specific) {
		this.specific = specific;
	}

}
