package callcenter.entity.forum;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.OneToMany;

import callcenter.entity.Entity;

@javax.persistence.Entity
@RequestScoped
@ManagedBean(name = "thread")
public class Thread extends Entity {

	private String title;

	@OneToMany(mappedBy = "thread")
	private List<Post> posts;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * @param posts
	 *            the posts to set
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public void initializeBibirectional() {
	}
}
