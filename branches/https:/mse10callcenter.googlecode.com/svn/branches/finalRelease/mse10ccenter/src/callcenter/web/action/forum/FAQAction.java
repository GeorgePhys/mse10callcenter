package callcenter.web.action.forum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.entity.forum.FAQEntry;
import callcenter.service.forum.FaqServiceBean;

@SessionScoped
@ManagedBean(name = "faqAction")
public class FAQAction implements Serializable {

    private List<FAQEntry> entries;

    @EJB
    private FaqServiceBean serviceBean;

    public String loadAndNavigateToFAQ() {
	List<FAQEntry> all = serviceBean.loadAll();
	entries = new ArrayList<FAQEntry>(all);
	return "faqPage";
    }

    public void addNew() {
	entries.add(0, new FAQEntry());
    }

    public void save() {
	List<FAQEntry> refreshed = new ArrayList<FAQEntry>();
	for (FAQEntry faqEntry : getEntries()) {
	    if (faqEntry.getId() == null) {
		FAQEntry saveOrUpdate = serviceBean.saveOrUpdate(faqEntry);
		refreshed.add(saveOrUpdate);
	    } else {
		refreshed.add(faqEntry);
	    }
	}
	entries.clear();
	entries.addAll(refreshed);
    }

    /**
     * @return the entries
     */
    public List<FAQEntry> getEntries() {
	return entries;
    }

    /**
     * @param entries
     *            the entries to set
     */
    public void setEntries(List<FAQEntry> entries) {
	this.entries = entries;
    }
}
