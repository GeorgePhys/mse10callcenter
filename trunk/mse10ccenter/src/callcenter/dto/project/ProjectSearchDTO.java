package callcenter.dto.project;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.issue.Project;

@ManagedBean(name = "projectDto")
@ViewScoped
public class ProjectSearchDTO extends BaseDTO<Project> {

    private String projectName;

    private String projectShortName;

    private String description;

    public String getProjectName() {
	return projectName;
    }

    public void setProjectName(String projectName) {
	this.projectName = projectName;
    }

    /**
     * @return the projectShortName
     */
    public String getProjectShortName() {
	return projectShortName;
    }

    /**
     * @param projectShortName
     *            the projectShortName to set
     */
    public void setProjectShortName(String projectShortName) {
	this.projectShortName = projectShortName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

}
