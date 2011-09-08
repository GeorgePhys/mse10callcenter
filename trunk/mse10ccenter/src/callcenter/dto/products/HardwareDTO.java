package callcenter.dto.products;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.products.Hardware;

@ManagedBean(name = "hardwareDto")
@ViewScoped
public class HardwareDTO extends BaseDTO<Hardware> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productName;

	private String serialNumber;

	private String description;

	private String manufacturer;

	private Integer warranty;

	private Double weight;

	private byte[] picture;

	private Double price;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getWarranty() {
		return warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public void initializeBibirectional() {
		// TODO Auto-generated method stub

	}

}
