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

    /**
     * Get issue title
     * 
     * @return issue title
     */
    public String getTitleIssue() {
	return titleIssue;
    }

    /**
     * Set issue title
     * 
     * @param titleIssue
     *            title of the issue
     */
    public void setTitleIssue(String titleIssue) {
	this.titleIssue = titleIssue;
    }

    /**
     * Get issue description
     * 
     * @return issue description
     */
    public String getDesctription() {
	return desctription;
    }

    /**
     * Set issue description
     * 
     * @param desctription
     *            issue description
     */
    public void setDesctription(String desctription) {
	this.desctription = desctription;
    }

    /**
     * Get date of issue create
     * 
     * @return issue create date
     */
    public Date getDateCreate() {
	return dateCreate;
    }

    /**
     * Set issue date of create
     * 
     * @param dateCreate
     *            date of issue created
     */
    public void setDateCreate(Date dateCreate) {
	this.dateCreate = dateCreate;
    }

    /**
     * Get created by
     * 
     * @return person name that create the issue
     */
    public String getCreatedBy() {
	return createdBy;
    }

    /**
     * Set create by
     * 
     * @param createitBy
     */
    public void setCreatedBy(String createitBy) {
	this.createdBy = createitBy;
    }

    /**
     * Get assigned to
     * 
     * @return assigned to
     */
    public String getAssignedTo() {
	return assignedTo;
    }

    /**
     * Set assigned to
     * 
     * @param assignedTo
     *            person assigned to specific issue
     */
    public void setAssignedTo(String assignedTo) {
	this.assignedTo = assignedTo;
    }

    /**
     * Get issue status
     * 
     * @return issue status
     */
    public String getStatus() {
	return status;
    }

    /**
     * Set issue status
     * 
     * @param status
     *            issue status
     */
    public void setStatus(String status) {
	this.status = status;
    }

    /**
     * Get issue resolution
     * 
     * @return issue resolution
     */
    public String getResolution() {
	return resolution;
    }

    /**
     * Set issue resolution
     * 
     * @param resolution
     *            issue resolution
     */
    public void setResolution(String resolution) {
	this.resolution = resolution;
    }

    /**
     * Get issue priority
     * 
     * @return issue priority
     */
    public String getPriority() {
	return priority;
    }

    /**
     * Set issue priority
     * 
     * @param priority
     *            issue priority
     */
    public void setPriority(String priority) {
	this.priority = priority;
    }

    /**
     * Get end date of issue
     * 
     * @return end date of issue
     */
    public Date getDateEnded() {
	return dateEnded;
    }

    /**
     * Set end date of issue
     * 
     * @param dateEnded
     *            end date
     */
    public void setDateEnded(Date dateEnded) {
	this.dateEnded = dateEnded;
    }

    /**
     * Get type of issue
     * 
     * @return type
     */
    public String getType() {
	return type;
    }

    /**
     * Set type of the issue
     * 
     * @param type
     *            issue type
     */
    public void setType(String type) {
	this.type = type;
    }
}
