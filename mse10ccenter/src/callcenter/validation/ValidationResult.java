package callcenter.validation;

import java.util.HashMap;
import java.util.Map;

public class ValidationResult {

    private Map<String, String> errors;
    private Map<String, String> warning;
    private Map<String, String> information;

    public ValidationResult() {
	this.errors = new HashMap<String, String>();
	this.warning = new HashMap<String, String>();
	this.information = new HashMap<String, String>();
    }

    public Map<String, String> getErrors() {
	return errors;
    }

    public void setErrors(Map<String, String> errors) {
	this.errors = errors;
    }

    public Map<String, String> getWarning() {
	return warning;
    }

    public void setWarning(Map<String, String> warning) {
	this.warning = warning;
    }

    public Map<String, String> getInformation() {
	return information;
    }

    public void setInformation(Map<String, String> information) {
	this.information = information;
    }
}
