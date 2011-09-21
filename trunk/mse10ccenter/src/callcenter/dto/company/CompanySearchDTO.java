package callcenter.dto.company;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import callcenter.dto.BaseDTO;
import callcenter.entity.clients.Company;
import callcenter.util.ObjectUtil;

@ManagedBean(name = "companyDto")
@ViewScoped
public class CompanySearchDTO extends BaseDTO<Company> {

    private String name;

    private String bulstat;

    private String country;

    private String city;

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
     * @return the bulstat
     */
    public String getBulstat() {
	return bulstat;
    }

    /**
     * @param bulstat
     *            the bulstat to set
     */
    public void setBulstat(String bulstat) {
	this.bulstat = bulstat;
    }

    /**
     * @return the country
     */
    public String getCountry() {
	return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(String country) {
	this.country = country;
    }

    /**
     * @return the city
     */
    public String getCity() {
	return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
	this.city = city;
    }

    public boolean hasAddressCriteria() {
	return ObjectUtil.isValid(getCity())
		|| ObjectUtil.isValid(getCountry());
    }
}