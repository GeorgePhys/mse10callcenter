package callcenter.dto.user;

import java.io.Serializable;

public class UserRegistrationKey implements Serializable {

    private static final long serialVersionUID = 3725890395597081873L;

    private String uuid;

    private Long id;

    public UserRegistrationKey(String uuid, Long id) {
	super();
	this.uuid = uuid;
	this.id = id;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
	return uuid;
    }

    /**
     * @param uuid
     *            the uuid to set
     */
    public void setUuid(String uuid) {
	this.uuid = uuid;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

}
