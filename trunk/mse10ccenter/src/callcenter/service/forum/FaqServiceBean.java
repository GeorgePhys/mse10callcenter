package callcenter.service.forum;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import callcenter.dto.BaseDTO;
import callcenter.entity.forum.FAQEntry;
import callcenter.service.base.BaseServiceBean;

@LocalBean
@Stateless
public class FaqServiceBean extends
		BaseServiceBean<FAQEntry, BaseDTO<FAQEntry>> {

	public static final String QUERY_LOAD_ALL_ENTRIES_KEY = "QUERY_LOAD_ALL_ENTRIES_KEY";
	public static final String QUERY_LOAD_ALL_ENTRIES = "from FAQEntry order by lastModifiedDate desc";

	@Override
	public List<FAQEntry> search(BaseDTO<FAQEntry> args, boolean countOnly) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	public List<FAQEntry> loadAll() {
		return getEntityManager().createNamedQuery(QUERY_LOAD_ALL_ENTRIES_KEY)
				.getResultList();
	}
}
