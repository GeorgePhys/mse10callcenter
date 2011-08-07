package callcenter.dto.issue;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "issueSearch")
@ViewScoped
public class IssueSearchDTO extends IssueReportDTO {
	private Long id;

	private String titleIssue;

	private String project;

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getTitleIssue() {
		return titleIssue;
	}

	public void setTitleIssue(String titleIssue) {
		this.titleIssue = titleIssue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
