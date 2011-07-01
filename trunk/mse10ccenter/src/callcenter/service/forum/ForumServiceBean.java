package callcenter.service.forum;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import callcenter.dto.forum.ThreadDTO;
import callcenter.entity.forum.ForumThread;
import callcenter.service.base.BaseServiceBean;

@LocalBean
@Stateless
public class ForumServiceBean extends
		BaseServiceBean<callcenter.entity.forum.ForumThread, ThreadDTO> {

	@Override
	public List<ForumThread> search(ThreadDTO args, boolean countOnly) {
		return super.search(args, countOnly);
	}
}
