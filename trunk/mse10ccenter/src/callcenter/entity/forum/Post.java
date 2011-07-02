package callcenter.entity.forum;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Post extends BasePost {

	@ManyToOne
	private ForumThread thread;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("id")
	private List<Comment> comments = new ArrayList<Comment>();

	/**
	 * @return the thread
	 */
	public ForumThread getThread() {
		return thread;
	}

	/**
	 * @param thread
	 *            the thread to set
	 */
	public void setThread(ForumThread thread) {
		this.thread = thread;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public void initializeBibirectional() {
		super.initializeBibirectional();
		for (Comment comment : comments) {
			comment.setPost(this);
			comment.initializeBibirectional();
		}
	}
}
