package co.com.orange.hrm.automation.utils;

public enum SystemUserEnum {

    USER_ROLE_ADMIN("Admin"), USER_ROLE_ESS("ESS"), EMPLOYEE_NAME("Jordan"), STATUS_ENABLED("Enable"), STATUS_DISABLED("Disabled"), SYSTEM_USER_NAME("JA20"), SYSTEM_PASSWORD("Test2022@"), SYSTEM_CONFIRM_PASS("Test2022@");

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
