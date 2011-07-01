package callcenter.web.action.forum;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import callcenter.entity.clients.User;
import callcenter.entity.forum.Comment;
import callcenter.entity.forum.ForumThread;
import callcenter.entity.forum.Post;
import callcenter.service.forum.ForumServiceBean;

@SessionScoped
@ManagedBean(name = "forumAction")
public class ForumAction implements Serializable {

	private static final long serialVersionUID = -3216246448201755157L;

	@EJB
	private ForumServiceBean serviceBean;

	private ForumThread thread = new ForumThread();

	private Post post = new Post();

	public String createThread() {
		User user = (User) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");
		thread.setCreatedBy(user);
		post.setFromUser(user);
		thread.getPosts().add(post);
		thread.initializeBibirectional();
		thread = serviceBean.saveOrUpdate(thread);
		return "threadPage";
	}

	public void addPost() {
		User user = (User) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");
		Post newPost = new Post();
		newPost.setFromUser(user);
		newPost.setThread(getThread());
		getThread().getPosts().add(newPost);
	}

	public void addComment(Post commentedPost) {
		User user = (User) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");
		Comment newComment = new Comment();
		newComment.setFromUser(user);
		newComment.setPost(commentedPost);
		commentedPost.getComments().add(newComment);
	}

	public void saveThread() {
		setThread(serviceBean.saveOrUpdate(getThread()));
	}

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
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * @param post
	 *            the post to set
	 */
	public void setPost(Post post) {
		this.post = post;
	}
}
