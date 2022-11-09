package co.com.orange.hrm.automation.exceptions;

public class NotFoundElement extends AssertionError {
    public NotFoundElement(String errorMessage){
        super(errorMessage);
    }
}
