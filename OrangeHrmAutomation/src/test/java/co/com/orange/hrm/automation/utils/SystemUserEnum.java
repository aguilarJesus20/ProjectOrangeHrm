package co.com.orange.hrm.automation.utils;

public enum SystemUserEnum {

    EMPLOYEE_NAME("Jordan"), SYSTEM_USER_NAME("JA20"), SYSTEM_PASSWORD("Test2022@"), SYSTEM_CONFIRM_PASS("Test2022@");


    private String data;

    SystemUserEnum(String data) {
        this.data = data;
    }

    public String getInfo() {
        return this.data;
    }

    public String getUserName() {
        return this.data.concat(String.valueOf(RandomNum.randomNumber()));
    }
}
