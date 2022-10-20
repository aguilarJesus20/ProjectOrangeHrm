package co.com.orange.hrm.automation.utils;

public enum ErrorMessagesEnum {
    REQUIRED("Required"), AT_LEAST_FIVE_USER("Should be least 5 characters"), AT_LEAST_EIGHT_PASS("Should have at least 8 characters"), PASSWORD_NOT_MATCH("Passwords do not match"), WEAK_PASSWORD("Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password"), EXCEED_CHARACTERS("Should not exceed 40 characters");
    private String objMessage;

    private ErrorMessagesEnum(String message) {
        this.objMessage = message;

    }

    public String getObjMessage() {
        return this.objMessage;
    }
}
