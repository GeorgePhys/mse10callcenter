package callcenter.entity.products;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ManagedBean(name = "software")
@RequestScoped
public class Software extends callcenter.entity.Entity implements Product,
		Serializable {

	@Column(columnDefinition = "Varchar(80)")
	private String productName;

	@Column(columnDefinition = "Varchar(15)")
	private String serialNumber;

	@Column(columnDefinition = "Text")
	private String description;

	@Column(columnDefinition = "Varchar(10)")
	private String version;

	@Column(columnDefinition = "BLOB")
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public byte[] getPicture() {
		return picture;
	}

	@Override
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public void initializeBibirectional() {
		// TODO Auto-generated method stub

	}
}
