package callcenter.web.common;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import callcenter.service.cache.MessagesCache;

@ManagedBean(eager = true, name = "messagesBean")
@ApplicationScoped
public class MessagesBean {

    @EJB
    private MessagesCache messagesCache;

    public String getMessage(String key) {
	String message = messagesCache
		.getMessage(FacesContext.getCurrentInstance().getViewRoot()
			.getLocale().toString(), key);
	return message == null ? "" : message;
    }
}
