package co.com.orange.hrm.automation.utils;

public enum UserDataEnum {
    EMPLOYEE_FIRST_NAME("Carlos"), EMPLOYEE_MIDDLE_NAME("Alejandro"), EMPLOYEE_LAST_NAME("Lopez"),
    EMPLOYEE_EXCEED_CHARACTERS("OctubreOctubreOctubreOctubreOctubre"),

    LOGIN_DETAILS_USER_NAME("test"), LOGIN_DETAILS_PASSWORD("Test2022@");

    private String data;

    private UserDataEnum(String data) {
        this.data = data;
    }

    public String getInfo() {
        return this.data;
    }

    public String getLoginDetails(){
        return this.data.concat(String.valueOf(RandomNum.randomNumber()));
    }
}

