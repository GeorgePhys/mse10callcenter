package callcenter.entity.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import callcenter.entity.clients.User;

@Entity
public class UserOrder extends callcenter.entity.Entity implements Serializable {

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<Item>();

    @Override
    public void initializeBibirectional() {
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
