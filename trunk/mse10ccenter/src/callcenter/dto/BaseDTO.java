package callcenter.dto;

import java.util.List;

public class BaseDTO<X> {

	private int totalResultsNumber;

	private int page;

	private List<X> result;

	public List<X> getResult() {
		return result;
	}

	public void setResult(List<X> result) {
		this.result = result;
	}

	public int getTotalResultsNumber() {
		return totalResultsNumber;
	}

	public void setTotalResultsNumber(int totalResultsNumber) {
		this.totalResultsNumber = totalResultsNumber;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
