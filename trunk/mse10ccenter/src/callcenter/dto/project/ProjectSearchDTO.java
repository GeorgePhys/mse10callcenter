package callcenter.dto.project;

import callcenter.dto.BaseDTO;
import callcenter.entity.issue.IssueDetail;
import callcenter.entity.issue.Project;

public class ProjectSearchDTO extends BaseDTO<Project>{
	
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	

}
