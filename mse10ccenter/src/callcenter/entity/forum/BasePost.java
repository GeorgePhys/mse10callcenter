package callcenter.entity.forum;

import javax.persistence.MappedSuperclass;

import callcenter.entity.clients.User;

@MappedSuperclass
public class BasePost extends callcenter.entity.Entity {

	private User fromUser;

	private String text;

	/**
	 * @return the fromUser
	 */
	public User getFromUser() {
		return fromUser;
	}

	/**
	 * @param fromUser
	 *            the fromUser to set
	 */
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void initializeBibirectional() {
	}

}
