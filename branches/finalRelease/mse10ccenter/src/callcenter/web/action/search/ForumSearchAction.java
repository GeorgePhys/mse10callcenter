package callcenter.web.action.search;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import callcenter.dto.forum.ThreadDTO;
import callcenter.entity.forum.ForumThread;
import callcenter.service.forum.ForumThreadService;
import callcenter.web.action.BaseSearchAction;
import callcenter.web.action.forum.ThreadAction;

@ManagedBean(name = "forumSearchAction")
@SessionScoped
public class ForumSearchAction extends BaseSearchAction<ForumThread, ThreadDTO> {

    @EJB
    private ForumThreadService threadService;

    @ManagedProperty(value = "#{threadAction}")
    private ThreadAction threadAction;

    public String startSearch() {
	setDataModel(null);
	return "startNewThreadSearch";
    }

    @Override
    public String previewSearchResult(ForumThread result) {
	return threadAction.preview(result);
    }

    @Override
    public ForumThreadService getService() {
	return threadService;
    }

    @Override
    public Class<ForumThread> getEntityClass() {
	return ForumThread.class;
    }

    /**
     * @return the threadAction
     */
    public ThreadAction getThreadAction() {
	return threadAction;
    }

    /**
     * @param threadAction
     *            the threadAction to set
     */
    public void setThreadAction(ThreadAction threadAction) {
	this.threadAction = threadAction;
    }
}
