package callcenter.entity.forum;

import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import callcenter.entity.Entity;
import callcenter.service.forum.FaqServiceBean;

@javax.persistence.Entity
@NamedQueries(value = { @NamedQuery(name = FaqServiceBean.QUERY_LOAD_ALL_ENTRIES_KEY, query = FaqServiceBean.QUERY_LOAD_ALL_ENTRIES) })
public class FAQEntry extends Entity {

	@Column(columnDefinition = "Varchar(255)")
	private String question;

	@Column(columnDefinition = "Varchar(255)")
	private String answer;

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public void initializeBibirectional() {
	}

}
