package callcenter.entity.products;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Software extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Varchar(80)")
	private String productName;

	@Column(columnDefinition = "Varchar(15)")
	private String serialNumber;

	@Column(columnDefinition = "Varchar(250)")
	private String description;

	@Column(columnDefinition = "Varchar(10)")
	private String version;

	@Column(columnDefinition = "Blob")
	private byte[] picture;

	@Column
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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
}
