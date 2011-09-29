package callcenter.dto.issue;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "issueSearch")
@ViewScoped
public class IssueSearchDTO extends IssueReportDTO {
    private Long id;

    private String titleIssue;

    private String project;

    /**
     * Get project that issue is assigned to
     * 
     * @return issue project
     */
    public String getProject() {
	return project;
    }

    /**
     * Set project that issue is assigned to
     * 
     * @param project
     *            issue project
     */
    public void setProject(String project) {
	this.project = project;
    }

    @Override
    public String getTitleIssue() {
	return titleIssue;
    }

    @Override
    public void setTitleIssue(String titleIssue) {
	this.titleIssue = titleIssue;
    }

    /**
     * Get id
     * 
     * @return issue id
     */
    public Long getId() {
	return id;
    }

    /**
     * Set id
     * 
     * @param id
     *            issue id
     */
    public void setId(Long id) {
	this.id = id;
    }

}
