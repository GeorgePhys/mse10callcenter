package callcenter.entity.privileges;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ManagedBean(name = "privilege")
@RequestScoped
public class Privilege extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Varchar(10)")
	private String code;

	@Column(columnDefinition = "Varchar(100)")
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
