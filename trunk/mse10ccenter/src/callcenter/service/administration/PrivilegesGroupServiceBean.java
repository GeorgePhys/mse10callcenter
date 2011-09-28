/**
 * 
 */
package callcenter.service.administration;

import java.util.List;

import javax.persistence.Query;

import callcenter.dto.privilege.PrivilegesGroupDTO;
import callcenter.entity.privileges.PrivilegesGroup;
import callcenter.service.base.BaseServiceBean;

/**
 * @author bassextremist
 * 
 */
public class PrivilegesGroupServiceBean extends
	BaseServiceBean<PrivilegesGroup, PrivilegesGroupDTO> {

    public static final String QUERY_PRIVILEGES_GROUP_BY_NAME_KEY = "QUERY_PRIVILEGES_GROUP_BY_NAME_KEY";
    public static final String QUERY_PRIVILEGES_GROUP_BY_NAME = "from PrivilegesGroup pg where pg.name = :name";

    public List<PrivilegesGroup> getPrivilegesGroupByName(String name) {
	Query query = getEntityManager().createNamedQuery(
		QUERY_PRIVILEGES_GROUP_BY_NAME_KEY);
	query.setParameter("name", name);
	return query.getResultList();
    }

}
