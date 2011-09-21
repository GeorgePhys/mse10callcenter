package callcenter.service.administration;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import callcenter.dto.products.SoftwareDTO;
import callcenter.entity.products.Software;
import callcenter.service.base.BaseServiceBean;

@LocalBean
@Stateless
public class SoftwareServiceBean extends BaseServiceBean<Software, SoftwareDTO> {
    public static final String QUERY_LOAD_ALL_SOFTWARE_KEY = "QUERY_LOAD_ALL_SOFTWARE_KEY";
    public static final String QUERY_LOAD_ALL_SOFTWARE = "from software order by lastModifiedDate desc";

    @SuppressWarnings("unchecked")
    public List<Software> listAllProjectNames() {
	// Query query = getEntityManager().createNamedQuery(
	// QUERY_LOAD_ALL_SOFTWARE_KEY);
	// return query.getResultList();
	return getEntityManager().createQuery("from Software").getResultList();
    }

}
