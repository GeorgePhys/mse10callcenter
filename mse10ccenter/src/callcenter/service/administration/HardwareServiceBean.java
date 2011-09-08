package callcenter.service.administration;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import callcenter.dto.products.HardwareDTO;
import callcenter.entity.products.Hardware;
import callcenter.service.base.BaseServiceBean;

@LocalBean
@Stateless
public class HardwareServiceBean extends BaseServiceBean<Hardware, HardwareDTO> {
	public static final String QUERY_LOAD_ALL_HARDWARE_KEY = "QUERY_LOAD_ALL_HARDWARE_KEY";
	public static final String QUERY_LOAD_ALL_HARDWARE = "from hardware order by lastModifiedDate desc";

	@SuppressWarnings("unchecked")
	public List<Hardware> listAllProjectNames() {
		// Query query = getEntityManager().createNamedQuery(
		// QUERY_LOAD_ALL_SOFTWARE_KEY);
		// return query.getResultList();
		return getEntityManager().createQuery("from Hardware").getResultList();
	}

}