package callcenter.entity.nomenclatures;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Holder extends callcenter.entity.Entity implements Serializable {

    @Column(columnDefinition = "Integer")
    private Integer code;

    @Column(columnDefinition = "Varchar(100)")
    private String descriptionBg;

    @Column(columnDefinition = "Varchar(100)")
    private String descriptionEn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "holder")
    private List<Value> values;

    /**
     * @return the code
     */
    public Integer getCode() {
	return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(Integer code) {
	this.code = code;
    }

    /**
     * @return the descriptionBg
     */
    public String getDescriptionBg() {
	return descriptionBg;
    }

    /**
     * @param descriptionBg
     *            the descriptionBg to set
     */
    public void setDescriptionBg(String descriptionBg) {
	this.descriptionBg = descriptionBg;
    }

    /**
     * @return the descriptionEn
     */
    public String getDescriptionEn() {
	return descriptionEn;
    }

    /**
     * @param descriptionEn
     *            the descriptionEn to set
     */
    public void setDescriptionEn(String descriptionEn) {
	this.descriptionEn = descriptionEn;
    }

    /**
     * @return the values
     */
    public List<Value> getValues() {
	return values;
    }

    /**
     * @param values
     *            the values to set
     */
    public void setValues(List<Value> values) {
	this.values = values;
    }

    @Override
    public void initializeBibirectional() {
    }

}
