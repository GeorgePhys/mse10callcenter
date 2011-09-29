package callcenter.web.action;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "topMenuSelectionAction")
@SessionScoped
public class TopMenuSelectionAction implements Serializable {

    private int selected;

    public boolean isSameArea(int linkArea) {
	return linkArea == selected;
    }

    public void changeSelected(int newSelection) {
	setSelected(newSelection);
    }

    /**
     * @return the selected
     */
    public int getSelected() {
	return selected;
    }

    /**
     * @param selected
     *            the selected to set
     */
    public void setSelected(int selected) {
	this.selected = selected;
    }
}
