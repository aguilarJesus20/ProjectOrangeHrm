package co.com.orange.hrm.automation.utils;

public enum ErrorsEnum {
    NOT_EQUALS("THE ELEMENTS ARE NOT EQUALS - CHECK IT");
    private String errorEnum;

    ErrorsEnum(String errorEnum) {
        this.errorEnum = errorEnum;
    }

    public String getErrorMessage() {
        return this.errorEnum;
    }

}
