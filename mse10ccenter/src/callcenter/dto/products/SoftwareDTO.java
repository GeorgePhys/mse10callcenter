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

    /**
     * Get product name
     * 
     * @return product name
     */
    public String getProductName() {
	return productName;
    }

    /**
     * Set product name
     * 
     * @param productName
     *            name of the product
     */
    public void setProductName(String productName) {
	this.productName = productName;
    }

    /**
     * Get serial number
     * 
     * @return product serial number
     */
    public String getSerialNumber() {
	return serialNumber;
    }

    /**
     * Set serial number
     * 
     * @param serialNumber
     *            product serial number
     */
    public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
    }

    /**
     * Get description
     * 
     * @return product description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Set description
     * 
     * @param description
     *            product description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Get version
     * 
     * @return product version
     */
    public String getVersion() {
	return version;
    }

    /**
     * Set version
     * 
     * @param version
     *            product version
     */
    public void setVersion(String version) {
	this.version = version;
    }

    /**
     * Get picture
     * 
     * @return product picture
     */
    public byte[] getPicture() {
	return picture;
    }

    /**
     * Set picture
     * 
     * @param picture
     *            product picture
     */
    public void setPicture(byte[] picture) {
	this.picture = picture;
    }

    /**
     * Get product price
     * 
     * @return product price
     */
    public Double getPrice() {
	return price;
    }

    /**
     * Set price
     * 
     * @param price
     *            product price
     */
    public void setPrice(Double price) {
	this.price = price;
    }

}
