package callcenter.web.action.search;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.dto.BaseDTO;
import callcenter.dto.issue.IssueSearchDTO;
import callcenter.entity.issue.IssueDetail;
import callcenter.service.administration.IssueServiceBean;
import callcenter.service.base.BaseServiceBean;
import callcenter.web.action.search.datamodel.JPADataModel;

@SessionScoped
@ManagedBean(name = "issueSearchAction")
@SuppressWarnings("rawtypes")
public class IssueSearchAction implements Serializable {

	@EJB
	private IssueServiceBean service;

	private IssueDataModel dataModel;

	private static final class IssueDataModel extends JPADataModel<IssueDetail> {

		private IssueDataModel(BaseServiceBean service, BaseDTO dto) {
			super(service, dto, IssueDetail.class);
		}

		@Override
		protected Object getId(IssueDetail t) {
			return t.getId();
		}
	}

	public String search(IssueSearchDTO dto) {
		service.search(dto, true);
		setDataModel(new IssueDataModel(service, dto));
		return null;
	}

	public Object getDataModel() {
		return dataModel;
	}

	public void setDataModel(IssueDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void clearSearch() {
		this.dataModel = null;
	}
}