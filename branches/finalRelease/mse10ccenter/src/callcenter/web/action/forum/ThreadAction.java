package callcenter.web.action.forum;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.entity.forum.ForumThread;
import callcenter.entity.forum.Post;
import callcenter.service.forum.ForumServiceBean;
import callcenter.web.action.BaseAction;

@ManagedBean(name = "threadAction")
@SessionScoped
public class ThreadAction extends BaseAction<ForumThread> {
    private static final long serialVersionUID = 8981722129655621928L;

    @EJB
    private ForumServiceBean forumServiceBean;

    private boolean isCreate;
    private Post post;

    public String init() {
	setTargetEntity(new ForumThread());
	isCreate = true;
	setReadonly(false);
	setPost(null);
	return "forumThreadPreview";
    }

    public String preview(ForumThread forumThread) {
	setTargetEntity(forumThread);
	isCreate = false;
	setReadonly(false);
	setPost(null);
	return "forumThreadPreview";
    }

    public void saveThread() {
	if (isCreate) {
	    getTargetEntity().setCreatedBy(getUser());
	    isCreate = false;
	}
	ForumThread thread = forumServiceBean.save(getTargetEntity());
	setTargetEntity(thread);
	setReadonly(true);
    }

    public void savePost() {
	getTargetEntity().getPosts().add(getPost());
	getPost().setThread(getTargetEntity());
	setPost(null);
	saveThread();
    }

    public void addNewPost() {
	Post post = new Post();
	post.setFromUser(getUser());
	setPost(post);
    }

    public void cancelAddPost() {
	setPost(null);
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

    /**
     * @return the isCreate
     */
    public boolean isCreate() {
	return isCreate;
    }

    /**
     * @param isCreate
     *            the isCreate to set
     */
    public void setCreate(boolean isCreate) {
	this.isCreate = isCreate;
    }
}
