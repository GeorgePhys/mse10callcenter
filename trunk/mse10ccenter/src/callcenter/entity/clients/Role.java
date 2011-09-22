/**
 * 
 */
package callcenter.entity.clients;

/**
 * Specifies the type of the user
 * 
 * @author Stepan Bahdikyan
 */
public enum Role {
	USER("User"), ADMIN("Admin"), CLIENT("Client");

	private final String label;

	private Role(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
