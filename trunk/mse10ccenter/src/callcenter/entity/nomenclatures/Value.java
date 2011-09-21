package callcenter.entity.nomenclatures;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@ManagedBean(name = "value")
@RequestScoped
public class Value extends callcenter.entity.Entity implements Serializable {

    @Column(columnDefinition = "Varchar(10)")
    private String valueCode;

    @Column(columnDefinition = "Varchar(100)")
    private String valueBg;

    @Column(columnDefinition = "Varchar(100)")
    private String valueEn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Holder holder;

    /**
     * @return the valueCode
     */
    public String getValueCode() {
	return valueCode;
    }

    /**
     * @param valueCode
     *            the valueCode to set
     */
    public void setValueCode(String valueCode) {
	this.valueCode = valueCode;
    }

    /**
     * @return the valueBg
     */
    public String getValueBg() {
	return valueBg;
    }

    /**
     * @param valueBg
     *            the valueBg to set
     */
    public void setValueBg(String valueBg) {
	this.valueBg = valueBg;
    }

    /**
     * @return the valueEn
     */
    public String getValueEn() {
	return valueEn;
    }

    /**
     * @param valueEn
     *            the valueEn to set
     */
    public void setValueEn(String valueEn) {
	this.valueEn = valueEn;
    }

    /**
     * @return the holder
     */
    public Holder getHolder() {
	return holder;
    }

    /**
     * @param holder
     *            the holder to set
     */
    public void setHolder(Holder holder) {
	this.holder = holder;
    }

    @Override
    public void initializeBibirectional() {
    }

}
