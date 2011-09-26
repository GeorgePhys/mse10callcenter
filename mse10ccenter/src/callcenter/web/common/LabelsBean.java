package callcenter.web.common;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import callcenter.service.cache.LabelsCache;

@ManagedBean(name = "labelsBean")
@ApplicationScoped
public class LabelsBean implements Serializable {
    private static final long serialVersionUID = 2548947507498923998L;

    @EJB
    private LabelsCache labelsCache;

    public String getLabel(String key) {
	String label = labelsCache.getLabel(FacesContext.getCurrentInstance()
		.getViewRoot().getLocale().toString(), key);
	return label == null ? "" : label;
    }
}
