package callcenter.dto.issue;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.issue.IssueDetail;

@ManagedBean(name = "issueReportDto")
@ViewScoped
public class IssueReportDTO extends BaseDTO<IssueDetail> {
	private String titleIssue;

	private String desctription;

	private Date dateCreate;

	private Date dateEnded;

	private String createdBy;

	private String type;

	private String assignedTo;

	private String status;

	private String resolution;

	private String priority;

	public String getTitleIssue() {
		return titleIssue;
	}

	public void setTitleIssue(String titleIssue) {
		this.titleIssue = titleIssue;
	}

	public String getDesctription() {
		return desctription;
	}

	public void setDesctription(String desctription) {
		this.desctription = desctription;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createitBy) {
		this.createdBy = createitBy;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getDateEnded() {
		return dateEnded;
	}

	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
