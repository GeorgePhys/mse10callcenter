package callcenter.entity.privileges;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Privilege extends callcenter.entity.Entity implements Serializable {

	@Column(columnDefinition = "Integer(10)")
	private Integer code;

	@Column(columnDefinition = "Varchar(250)")
	private String description;

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
}
