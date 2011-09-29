/**
 * 
 */
package callcenter.service.administration;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import callcenter.dto.privilege.PrivilegeDTO;
import callcenter.entity.privileges.Privilege;
import callcenter.service.base.BaseServiceBean;

/**
 * @author bassextremist
 * 
 */
@Stateless
public class PrivilegesServiseBean extends
	BaseServiceBean<Privilege, PrivilegeDTO> {

    public static final String QUERY_PRIVILEGES_BY_AREA_KEY = "QUERY_PRIVILEGES_BY_AREA_KEY";
    public static final String QUERY_PRIVILEGES_BY_AREA = "from Privilege p where p.entityArea = :area";

    public List<Privilege> getPrivilegesByArea(String entityArea) {
	Query query = getEntityManager().createNamedQuery(
		QUERY_PRIVILEGES_BY_AREA_KEY);
	query.setParameter("area", entityArea);
	return query.getResultList();
    }
}
