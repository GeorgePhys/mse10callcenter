package callcenter.web.action;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import callcenter.entity.Entity;
import callcenter.entity.clients.User;

@SessionScoped
@ManagedBean(name = "baseAction")
public class BaseAction<E extends Entity> implements Serializable {

    private static final long serialVersionUID = 8997153037439218558L;

    private E targetEntity;

    private boolean readonly;

    /**
     * @return the readonly
     */
    public boolean isReadonly() {
	return readonly;
    }

    /**
     * @param readonly
     *            the readonly to set
     */
    public void setReadonly(boolean readonly) {
	this.readonly = readonly;
    }

    /**
     * @return the targetEntity
     */
    public E getTargetEntity() {
	return targetEntity;
    }

    /**
     * @param targetEntity
     *            the targetEntity to set
     */
    public void setTargetEntity(E targetEntity) {
	this.targetEntity = targetEntity;
    }

    public boolean getLoggedIn() {
	return getUser() != null;
    }

    public User getUser() {
	return (User) FacesContext.getCurrentInstance().getExternalContext()
		.getSessionMap().get("user");
    }

    public void setUser(User user) {
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
		.put("user", user);
    }
}
