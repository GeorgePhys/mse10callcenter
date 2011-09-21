package callcenter.web.action.shop;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.products.Hardware;
import callcenter.service.administration.HardwareServiceBean;
import callcenter.service.base.BaseServiceBean;
import callcenter.web.action.BaseAction;
import callcenter.web.action.search.datamodel.JPADataModel;

@SessionScoped
@ManagedBean(name = "hardwareProducts")
@SuppressWarnings("rawtypes")
public class HardwareProductAction extends BaseAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private HardwareServiceBean service;

    private List<Hardware> hardware;
    private HardwareDataModel dataModel;

    private Map<Long, Boolean> disable = new HashMap<Long, Boolean>();

    private static final class HardwareDataModel extends JPADataModel<Hardware> {

	private HardwareDataModel(BaseServiceBean service, BaseDTO dto) {
	    super(service, dto, Hardware.class);
	}

	@Override
	protected Object getId(Hardware t) {
	    return t.getId();
	}
    }

    /**
     * 
     * @param s
     * @return
     */
    @SuppressWarnings("unchecked")
    public String openSlectedProduct(Hardware s) {
	setTargetEntity(s);

	return "reviewHardwareProduct";
    }

    public String allSoftware() {
	this.hardware = service.listAllProjectNames();
	return "AllSoftware";
    }

    /**
     * 
     * @param s
     * @return
     */
    @SuppressWarnings("unchecked")
    public String openSlectedHardware(Hardware s) {
	setTargetEntity(s);

	return "reviewHardwareProduct";
    }

    public Object getDataModel() {
	return dataModel;
    }

    public void setDataModel(HardwareDataModel dataModel) {
	this.dataModel = dataModel;
    }

    public Map<Long, Boolean> getDisable() {
	return disable;
    }

    public void setDisable(Map<Long, Boolean> disable) {
	this.disable = disable;
    }

    public List<Hardware> getHardware() {
	hardware = service.listAllProjectNames();
	return hardware;
    }

    public void setHardware(List<Hardware> hardware) {
	this.hardware = hardware;
    }

}
