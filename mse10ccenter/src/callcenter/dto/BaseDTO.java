package callcenter.dto;

import java.util.List;

public class BaseDTO<X> {
	private List<X> result;

	public List<X> getResult() {
		return result;
	}

	public void setResult(List<X> result) {
		this.result = result;
	}

}
