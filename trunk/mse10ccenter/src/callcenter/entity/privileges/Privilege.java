package callcenter.entity.privileges;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import callcenter.service.administration.PrivilegesServiseBean;

@Entity
@NamedQueries(value = { @NamedQuery(name = PrivilegesServiseBean.QUERY_PRIVILEGES_BY_AREA_KEY, query = PrivilegesServiseBean.QUERY_PRIVILEGES_BY_AREA) })
public class Privilege extends callcenter.entity.Entity implements Serializable {

    @Column(columnDefinition = "Integer(10)")
    private Integer code;

    @Column(columnDefinition = "Varchar(250)")
    private String description;

    @Column(columnDefinition = "Varchar(250)")
    private String descriptionBg;

    @Column(columnDefinition = "Varchar(20)")
    private String entityArea; // issue, project, forum

    public Integer getCode() {
	return code;
    }

    public void setCode(Integer code) {
	this.code = code;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public void initializeBibirectional() {
	// TODO Auto-generated method stub

    }

    /**
     * @return the entityArea
     */
    public String getEntityArea() {
	return entityArea;
    }

    /**
     * @param entityArea
     *            the entityArea to set
     */
    public void setEntityArea(String entityArea) {
	this.entityArea = entityArea;
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
}
