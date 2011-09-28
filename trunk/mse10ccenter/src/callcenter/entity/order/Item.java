package callcenter.entity.order;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import callcenter.entity.products.Product;

@Entity
public class Item extends callcenter.entity.Entity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @OneToOne
    private Product product;
    private int amount;
    private double price;
    @ManyToOne
    private Order order;

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

    public int getAmount() {
	return amount;
    }

    public void setAmount(int amount) {
	this.amount = amount;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public Order getOrder() {
	return order;
    }

    public void setOrder(Order order) {
	this.order = order;
    }

    @Override
    public void initializeBibirectional() {
	// TODO Auto-generated method stub

    }
}