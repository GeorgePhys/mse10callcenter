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

    private static final long serialVersionUID = 1L;

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

    @Column(columnDefinition = "Varchar(100)")
    private String reporter;

    @Column(columnDefinition = "Varchar(100)")
    private String assignee;

    @Column(columnDefinition = "Varchar(100)")
    private String user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnded;

    @Column(columnDefinition = "Varchar(400)")
    private String desctription;

    @ManyToOne
    private Project project;

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
     *            issue title
     */
    public void setTitleIssue(String titleIssue) {
	this.titleIssue = titleIssue;
    }

    /**
     * Get type
     * 
     * @return issue type
     */
    public String getType() {
	return type;
    }

    /**
     * Set type
     * 
     * @param type
     *            issue type
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * Get priority
     * 
     * @return issue priority
     */
    public String getPriority() {
	return priority;
    }

    /**
     * Set priority
     * 
     * @param priority
     *            issue priority
     */
    public void setPriority(String priority) {
	this.priority = priority;
    }

    /**
     * Get status
     * 
     * @return issue status
     */
    public String getStatus() {
	return status;
    }

    /**
     * Set status
     * 
     * @param status
     *            issue status
     */
    public void setStatus(String status) {
	this.status = status;
    }

    /**
     * Get resolution
     * 
     * @return issue resolution
     */
    public String getResolution() {
	return resolution;
    }

    /**
     * Set resolution
     * 
     * @param resolution
     *            issue resolution
     */
    public void setResolution(String resolution) {
	this.resolution = resolution;
    }

    /**
     * Get reporter
     * 
     * @return issue reported person
     */
    public String getReporter() {
	return reporter;
    }

    /**
     * Set reporter
     * 
     * @param reporter
     *            reported person
     */
    public void setReporter(String reporter) {
	this.reporter = reporter;
    }

    /**
     * Get assignee
     * 
     * @return assigned person
     */
    public String getAssignee() {
	return assignee;
    }

    /**
     * Set assignee
     * 
     * @param assignee
     *            assigned person
     */
    public void setAssignee(String assignee) {
	this.assignee = assignee;
    }

    public String getUser() {
	return user;
    }

    public void setUser(String user) {
	this.user = user;
    }

    /**
     * Get date created
     * 
     * @return issue date created
     */
    public Date getDateCreated() {
	return dateCreated;
    }

    /**
     * Set date created
     * 
     * @param dateCreated
     *            issue date created
     */
    public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
    }

    /**
     * Get date end
     * 
     * @return issue date ended
     */
    public Date getDateEnded() {
	return dateEnded;
    }

    /**
     * Set date end
     * 
     * @param dateEnded
     *            issue date ended
     */
    public void setDateEnded(Date dateEnded) {
	this.dateEnded = dateEnded;
    }

    /**
     * Get description
     * 
     * @return issue description
     */
    public String getDesctription() {
	return desctription;
    }

    /**
     * Set description
     * 
     * @param desctription
     *            issue description
     */
    public void setDesctription(String desctription) {
	this.desctription = desctription;
    }

    /**
     * Get issue project
     * 
     * @return the project
     */
    public Project getProject() {
	return project;
    }

    /**
     * Set issue project
     * 
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
