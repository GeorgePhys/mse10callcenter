package callcenter.dto.products;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.products.Software;

@ManagedBean(name = "softwareDto")
@ViewScoped
public class SoftwareDTO extends BaseDTO<Software> {

    private String productName;

    private String serialNumber;

    private String description;

    private String version;

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
