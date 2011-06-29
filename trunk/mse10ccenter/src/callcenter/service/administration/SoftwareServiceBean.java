package callcenter.service.administration;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import callcenter.dto.products.SoftwareDTO;
import callcenter.entity.products.Software;
import callcenter.service.base.BaseServiceBean;

@LocalBean
@Stateless
public class SoftwareServiceBean extends BaseServiceBean<Software, SoftwareDTO> {

}
