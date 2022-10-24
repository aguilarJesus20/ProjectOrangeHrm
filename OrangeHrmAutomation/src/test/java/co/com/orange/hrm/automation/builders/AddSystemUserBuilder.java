package co.com.orange.hrm.automation.builders;

import co.com.orange.hrm.automation.models.AddSystemUserModel;

public class AddSystemUserBuilder {
    private String employeeName;
    private String userName;
    private String password;
    private String confirmPass;

    public AddSystemUserBuilder(String employeeName) {
        this.employeeName = employeeName;
    }

    public static AddSystemUserBuilder withEmployeeName(String employeeName) {
        return new AddSystemUserBuilder(employeeName);
    }

    public AddSystemUserBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public AddSystemUserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public AddSystemUserBuilder withConfirmPassword(String confirmPass) {
        this.confirmPass = confirmPass;
        return this;
    }

    public AddSystemUserModel build() {
        return new AddSystemUserModel(employeeName, userName, password, confirmPass);
    }
}
