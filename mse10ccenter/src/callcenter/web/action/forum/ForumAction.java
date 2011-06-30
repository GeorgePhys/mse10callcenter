package callcenter.web.action.forum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.entity.clients.User;
import callcenter.entity.forum.Comment;
import callcenter.entity.forum.Post;
import callcenter.entity.forum.Thread;

@SessionScoped
@ManagedBean(name = "forumAction")
public class ForumAction implements Serializable {

	private static final long serialVersionUID = -3216246448201755157L;

	private Thread current;

	public ForumAction() {
		current = new Thread();
		Post post = new Post();
		User user = new User();
		Comment comment = new Comment();
		post.setComments(new ArrayList<Comment>(Arrays.asList(comment)));
		post.setFromUser(user);
		current.setPosts(new ArrayList<Post>(Arrays.asList(post)));
		current.setTitle("test title");
		user.setFullName("Yasko");
		post.setText("ala bala");
		User other = new User();
		other.setFullName("Svilen");
		comment.setFromUser(other);
		comment.setText("bala ala");
	}

	public String addComment(Post post) {
		Comment comment = new Comment();
		User user = new User();
		user.setFullName("Pesho");
		comment.setFromUser(user);
		comment.setText("bazinga!!1");
		post.getComments().add(comment);
		return null;
	}

	/**
	 * @return the current
	 */
	public Thread getCurrent() {
		return current;
	}

	/**
	 * @param current
	 *            the current to set
	 */
	public void setCurrent(Thread current) {
		this.current = current;
	}

}
