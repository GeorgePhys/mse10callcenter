package callcenter.entity.forum;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends BasePost {

    @ManyToOne
    private Post post;

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
