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

    /**
     * Represent hardware data model
     */
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
     * Transfer current product object
     * 
     * @param s
     *            instance of type hardware
     * @return navigation text
     */
    @SuppressWarnings("unchecked")
    public String openSlectedProduct(Hardware s) {
	setTargetEntity(s);
	return "reviewHardwareProduct";
    }

    /**
     * Generate list of all software products
     * 
     * @return list
     */
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

    /**
     * Get data model
     * 
     * @return hardware data model
     */
    public Object getDataModel() {
	return dataModel;
    }

    /**
     * Set data model
     * 
     * @param dataModel
     *            hardware data model
     */
    public void setDataModel(HardwareDataModel dataModel) {
	this.dataModel = dataModel;
    }

    /**
     * Get buttons disable status
     * 
     * @return map of button history
     */
    public Map<Long, Boolean> getDisable() {
	return disable;
    }

    /**
     * Set buttons disable status
     * 
     * @param disable
     *            map of buttons status
     */
    public void setDisable(Map<Long, Boolean> disable) {
	this.disable = disable;
    }

    /**
     * Get list of hardwares
     * 
     * @return list of hardwares
     */
    public List<Hardware> getHardware() {
	hardware = service.listAllProjectNames();
	return hardware;
    }

    /**
     * Set hardware
     * 
     * @param hardware
     *            list of hardwares
     */
    public void setHardware(List<Hardware> hardware) {
	this.hardware = hardware;
    }

}
