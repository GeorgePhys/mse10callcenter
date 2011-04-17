package callcenter.dto.issue;

public class IssueSearchDTO extends IssueReportDTO {
	private Long id;

	private String titleIssue;

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
