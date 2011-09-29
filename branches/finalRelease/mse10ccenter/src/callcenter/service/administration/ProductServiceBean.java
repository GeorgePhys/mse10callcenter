package callcenter.service.administration;

import java.util.List;

import javax.ejb.Stateless;

import callcenter.dto.products.ProductDTO;
import callcenter.entity.products.Product;
import callcenter.service.base.BaseServiceBean;

@Stateless
public class ProductServiceBean extends BaseServiceBean<Product, ProductDTO> {

    public static final String QUERY_ALL_SOFTWARE_KEY = "QUERY_ALL_SOFTWARE_KEY";
    public static final String QUERY_ALL_SOFTWARE = "from Product p where type = 0";

    public static final String QUERY_ALL_HARDWARE_KEY = "QUERY_ALL_HARDWARE_KEY";
    public static final String QUERY_ALL_HARDWARE = "from Product p where type = 1";

    @SuppressWarnings("unchecked")
    public List<Product> getAllSoftware() {
	return getEntityManager().createNamedQuery(
		ProductServiceBean.QUERY_ALL_SOFTWARE_KEY).getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Product> getAllHardware() {
	return getEntityManager().createNamedQuery(
		ProductServiceBean.QUERY_ALL_HARDWARE_KEY).getResultList();
    }
}
