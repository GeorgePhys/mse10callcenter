package callcenter.dto;

public class BaseDTO<X> {

    private Integer totalNumberOfRows;

    private Integer firstResult;

    private Integer maxResults;

    /**
     * @return the firstResult
     */
    public Integer getFirstResult() {
	return firstResult;
    }

    /**
     * @param firstResult
     *            the firstResult to set
     */
    public void setFirstResult(Integer firstResult) {
	this.firstResult = firstResult;
    }

    /**
     * @return the maxResults
     */
    public Integer getMaxResults() {
	return maxResults;
    }

    /**
     * @param maxResults
     *            the maxResults to set
     */
    public void setMaxResults(Integer maxResults) {
	this.maxResults = maxResults;
    }

    /**
     * @return the totalNumberOfRows
     */
    public Integer getTotalNumberOfRows() {
	return totalNumberOfRows;
    }

    /**
     * @param totalNumberOfRows
     *            the totalNumberOfRows to set
     */
    public void setTotalNumberOfRows(Integer totalNumberOfRows) {
	this.totalNumberOfRows = totalNumberOfRows;
    }
}
