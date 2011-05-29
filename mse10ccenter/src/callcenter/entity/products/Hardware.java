package callcenter.entity.products;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@ManagedBean(name = "hardware")
@RequestScoped
public class Hardware extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Varchar(80)")
	private String productName;

	@Column(columnDefinition = "Varchar(15)")
	private String serialNumber;

	@Column(columnDefinition = "Varchar(250)")
	private String description;

	@Column(columnDefinition = "Varchar(50)")
	private String manufacturer;

	@Column
	private Integer warranty;

	@Column
	private Double weight;

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

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Lob
	@Column(length=100000)
	private byte[] picture;

	@Column
	private Double price;

}
