package co.com.orange.hrm.automation.utils;

public enum SystemUserEnum {

    EMPLOYEE_NAME("Jordan"), SYSTEM_USER_NAME("JAD2022"), SYSTEM_PASSWORD("Test2022@");

    private String data;

    private SystemUserEnum(String data) {
        this.data = data;
    }

    public String getInfo() {
        return this.data;
    }

    public String getUserName() {
        return this.data.concat(String.valueOf(RandomNum.randomNumber()));
    }
}
