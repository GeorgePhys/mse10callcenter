/**
 * 
 */
package callcenter.entity.clients;

/**
 * Specifies the role of the user
 * 
 * @author Stepan Bahdikyan
 */
public enum Role {
    USER("User"), ADMIN("Admin"), CLIENT("Client"), EMPLOYEE("Employee");

    private final String label;

    private Role(String label) {
	this.label = label;
    }

    public String getLabel() {
	return this.label;
    }
}
