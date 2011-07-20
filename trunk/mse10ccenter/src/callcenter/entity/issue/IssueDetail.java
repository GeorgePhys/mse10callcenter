package callcenter.entity.issue;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class IssueDetail extends callcenter.entity.Entity implements
		Serializable {

	@Column(columnDefinition = "Varchar(100)")
	private String titleIssue;

	@Column(columnDefinition = "Varchar(20)")
	private String type;

	@Column(columnDefinition = "Varchar(20)")
	private String priority;

	@Column(columnDefinition = "Varchar(20)")
	private String status;

	@Column(columnDefinition = "Varchar(20)")
	private String resolution;

	@Column(columnDefinition = "Varchar(20)")
	private String reporter;

	@Column(columnDefinition = "Varchar(20)")
	private String assignee;

	@Column(columnDefinition = "Varchar(100)")
	private String user;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEnded;

	@Column(columnDefinition = "Varchar(300)")
	private String desctription;

	@ManyToOne
	private Project project;

	public String getTitleIssue() {
		return titleIssue;
	}

	public void setTitleIssue(String titleIssue) {
		this.titleIssue = titleIssue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateEnded() {
		return dateEnded;
	}

	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}

	public String getDesctription() {
		return desctription;
	}

	public void setDesctription(String desctription) {
		this.desctription = desctription;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public void initializeBibirectional() {
		// TODO Auto-generated method stub

	}

}
