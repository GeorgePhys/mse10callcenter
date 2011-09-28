package callcenter.entity.products;

import javax.persistence.Column;

import callcenter.entity.Entity;

public class Product extends Entity {

    public enum ProductType {
	SOFTWARE, HARDWARE;
    }

    private ProductType type;

    @Column(columnDefinition = "Varchar(80)")
    private String productName;

    @Column(columnDefinition = "Varchar(15)")
    private String serialNumber;

    @Column(columnDefinition = "Text")
    private String description;

    @Column(columnDefinition = "Varchar(50)")
    private String manufacturer;

    @Column(columnDefinition = "Integer")
    private Integer warranty;

    @Column(columnDefinition = "Double")
    private Double weight;

    @Column(columnDefinition = "BLOB")
    private byte[] picture;

    @Column
    private Double price;

    @Column(columnDefinition = "Varchar(10)")
    private String version;

    /**
     * @return the type
     */
    public ProductType getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(ProductType type) {
	this.type = type;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
	return productName;
    }

    /**
     * @param productName
     *            the productName to set
     */
    public void setProductName(String productName) {
	this.productName = productName;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
	return serialNumber;
    }

    /**
     * @param serialNumber
     *            the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
	return manufacturer;
    }

    /**
     * @param manufacturer
     *            the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    /**
     * @return the warranty
     */
    public Integer getWarranty() {
	return warranty;
    }

    /**
     * @param warranty
     *            the warranty to set
     */
    public void setWarranty(Integer warranty) {
	this.warranty = warranty;
    }

    /**
     * @return the weight
     */
    public Double getWeight() {
	return weight;
    }

    /**
     * @param weight
     *            the weight to set
     */
    public void setWeight(Double weight) {
	this.weight = weight;
    }

    /**
     * @return the picture
     */
    public byte[] getPicture() {
	return picture;
    }

    /**
     * @param picture
     *            the picture to set
     */
    public void setPicture(byte[] picture) {
	this.picture = picture;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
	return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(Double price) {
	this.price = price;
    }

    /**
     * @return the version
     */
    public String getVersion() {
	return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(String version) {
	this.version = version;
    }

    @Override
    public void initializeBibirectional() {
    }

}
