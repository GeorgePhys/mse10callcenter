package callcenter.dto.products;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.products.Product;

@ManagedBean(name = "hardwareDto")
@ViewScoped
public class ProductDTO extends BaseDTO<Product> {

    private static final long serialVersionUID = 1L;

    private String productName;

    private String serialNumber;

    private String description;

    private String manufacturer;

    private Integer warranty;

    private Double weight;

    private byte[] picture;

    private Double price;

    /**
     * Get product name
     * 
     * @return name of the product
     */
    public String getProductName() {
	return productName;
    }

    /**
     * Set name of the product
     * 
     * @param productName
     *            name of the product
     */
    public void setProductName(String productName) {
	this.productName = productName;
    }

    /**
     * Get product serial number
     * 
     * @return serial number
     */
    public String getSerialNumber() {
	return serialNumber;
    }

    /**
     * Set product serial number
     * 
     * @param serialNumber
     *            serial number of the product
     */
    public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
    }

    /**
     * Get product description
     * 
     * @return product description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Set product description
     * 
     * @param description
     *            product description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Get product manufacturer
     * 
     * @return product manufacturer
     */
    public String getManufacturer() {
	return manufacturer;
    }

    /**
     * Set product manufacturer
     * 
     * @param manufacturer
     *            product manufacturer
     */
    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    /**
     * Get product warranty
     * 
     * @return product warranty
     */
    public Integer getWarranty() {
	return warranty;
    }

    /**
     * Set warranty
     * 
     * @param warranty
     *            product warranty
     */
    public void setWarranty(Integer warranty) {
	this.warranty = warranty;
    }

    /**
     * Get weight
     * 
     * @return product weight
     */
    public Double getWeight() {
	return weight;
    }

    /**
     * Set weight
     * 
     * @param weight
     *            product weight
     */
    public void setWeight(Double weight) {
	this.weight = weight;
    }

    /**
     * Get price
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

    public void initializeBibirectional() {
	// TODO Auto-generated method stub
    }

}
