package callcenter.entity.forum;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import callcenter.entity.Entity;
import callcenter.entity.clients.User;

@javax.persistence.Entity
public class ForumThread extends Entity {

    private String title;

    private String text;

    @OrderBy("id")
    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<Post>();

    @OneToOne
    private User createdBy;

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
	for (Post post : posts) {
	    post.setThread(this);
	    post.initializeBibirectional();
	}
    }

    /**
     * @return the createdBy
     */
    public User getCreatedBy() {
	return createdBy;
    }

    /**
     * @param createdBy
     *            the createdBy to set
     */
    public void setCreatedBy(User createdBy) {
	this.createdBy = createdBy;
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
}
