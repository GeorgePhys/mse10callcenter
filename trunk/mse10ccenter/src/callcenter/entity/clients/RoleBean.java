/**
 * 
 */
package callcenter.entity.clients;

import javax.faces.bean.ManagedBean;

/**
 * @author bassextremist
 * 
 */
@ManagedBean(name = "role")
public class RoleBean {

	public String[] getRoles() {
		String[] roles = new String[Role.values().length];
		int i = 0;
		for (Role role : Role.values()) {
			roles[i++] = new String(role.getLabel());
		}
		return roles;
	}

}
