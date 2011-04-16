package callcenter.entity.issue.dto;

import java.util.Date;
import java.util.List;

import callcenter.entity.issue.IssueDetail;

public class IssueReportDTO extends BaseDTO<IssueDetail> {
	private Date dateCreate;

	private Date dateEnded;

	private String createdBy;

	private String assignedTo;

	private String status;

	private List<String> resolution;

	private String priority;

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

	public List<String> getResolution() {
		return resolution;
	}

	public void setResolution(List<String> resolution) {
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
}
