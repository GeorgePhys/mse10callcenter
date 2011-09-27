package callcenter.web.action.shop;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.entity.products.Hardware;
import callcenter.entity.products.Software;

@SessionScoped
@ManagedBean(name = "shoppingCart")
public class ShoppingCartAction {
    private List<Software> softwareItems;
    private List<Hardware> hardwareItems;

    public List<Software> getSoftwareItems() {
	return softwareItems;
    }

    public void setSoftwareItems(Software softwareItems) {
	this.softwareItems.add(softwareItems);
    }

    public List<Hardware> getHardwareItems() {
	return hardwareItems;
    }

    public void setHardwareItems(Hardware hardwareItems) {
	this.hardwareItems.add(hardwareItems);
    }

    public String cartStatus() {
	return "ShappingCart";
    }

}
