package callcenter.web.action.shop;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.products.Software;
import callcenter.service.administration.SoftwareServiceBean;
import callcenter.service.base.BaseServiceBean;
import callcenter.web.action.BaseAction;
import callcenter.web.action.search.datamodel.JPADataModel;

@SessionScoped
@ManagedBean(name = "softwareProducts")
@SuppressWarnings("rawtypes")
public class SoftwareProductAction extends BaseAction implements Serializable {
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
	private Map<Long, Boolean> disable = new HashMap<Long, Boolean>();

	private static final class SoftwareDataModel extends JPADataModel<Software> {

		private SoftwareDataModel(BaseServiceBean service, BaseDTO dto) {
			super(service, dto, Software.class);
		}

		@Override
		protected Object getId(Software t) {
			return t.getId();
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String openSlectedProduct(Software s) {
		setTargetEntity(s);

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
	 * 
	 * @param software
	 * @return
	 */
	public double buy(Software software) {
		if (!this.disable.containsKey(software.getId())) {
			// increase number of products that are buying
			this.brItems++;
			this.amount = this.amount + software.getPrice();
			this.disable.put(software.getId(), Boolean.TRUE);
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

	public List<Software> getSpecific() {
		return specific;
	}

	public void setSpecific(List<Software> specific) {
		this.specific = specific;
	}

	public Map<Long, Boolean> getDisable() {
		return disable;
	}

	public void setDisable(Map<Long, Boolean> disable) {
		this.disable = disable;
	}

}
