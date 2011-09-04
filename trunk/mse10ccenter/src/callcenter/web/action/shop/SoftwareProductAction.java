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
	private int buyedItems = 0;
	private double amount = 0.0;
	private boolean chartClier;

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

	// public String clearChart() {
	// this.amount = 0;
	// this.buyedItems = 0;
	// this.chartClier = true;
	// return "cleared";
	// }
	//
	// public boolean disable() {
	// if (this.chartClier == true) {
	// return true;
	// }
	// return false;
	// }

	/**
	 * Buy a product
	 * 
	 * @param software
	 *            product for buying
	 * @return price of the product
	 */
	public double buy(Software software) {
		// increase number of products that are buying
		this.buyedItems++;
		this.amount = this.amount + software.getPrice();
		return this.amount;
	}

	public void setSoft(List<Software> soft) {
		this.soft = soft;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getBuyedItems() {
		return buyedItems;
	}

	public void setBuyedItems(int buyedItems) {
		this.buyedItems = buyedItems;
	}

	public boolean isChartClier() {
		return chartClier;
	}

	public void setChartClier(boolean chartClier) {
		this.chartClier = chartClier;
	}
}
