package callcenter.web.common;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import callcenter.service.cache.MessagesCache;

@ManagedBean(eager = true, name = "messagesBean")
@ApplicationScoped
public class MessagesBean implements Serializable {
    private static final long serialVersionUID = 8716627158201310775L;

    @EJB
    private MessagesCache messagesCache;

    public String getMessage(String key) {
	String message = messagesCache
		.getMessage(FacesContext.getCurrentInstance().getViewRoot()
			.getLocale().toString(), key);
	return message == null ? "" : message;
    }
}
