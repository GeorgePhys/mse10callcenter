package callcenter.entity.nomenclatures;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ManagedBean(name = "value")
@RequestScoped
public class Value extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Varchar(100)")
	private String value;
}
