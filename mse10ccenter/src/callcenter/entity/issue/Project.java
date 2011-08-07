package callcenter.entity.issue;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import callcenter.service.project.ProjectServiceBean;

@Entity
@NamedQueries(value = { @NamedQuery(name = ProjectServiceBean.QUERY_ALL_PROJECT_NAMES_KEY, query = ProjectServiceBean.QUERY_ALL_PROJECT_NAMES) })
public class Project extends callcenter.entity.Entity {

	private String name;

	private String shortName;

	private String description;

	@OneToMany(mappedBy = "project")
	private Set<IssueDetail> issues;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName
	 *            the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	/**
	 * @return the issues
	 */
	public Set<IssueDetail> getIssues() {
		return issues;
	}

	/**
	 * @param issues
	 *            the issues to set
	 */
	public void setIssues(Set<IssueDetail> issues) {
		this.issues = issues;
	}

	@Override
	public void initializeBibirectional() {

	}
}
