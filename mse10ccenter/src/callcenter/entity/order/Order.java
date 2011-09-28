package callcenter.entity.order;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import callcenter.entity.clients.User;

@Entity
public class Order extends callcenter.entity.Entity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order")
    private List<Item> items;

    @Override
    public void initializeBibirectional() {
	// TODO Auto-generated method stub

    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public List<Item> getItems() {
	return items;
    }

    public void setItems(List<Item> items) {
	this.items = items;
    }

}
