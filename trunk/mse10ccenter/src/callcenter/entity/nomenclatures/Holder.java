package callcenter.entity.nomenclatures;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@ManagedBean(name = "holder")
@RequestScoped
public class Holder extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Integer")
	private Integer code;

	@Column(columnDefinition = "Varchar(100)")
	private String description;

	@OneToMany
	private List<Value> values;
}
