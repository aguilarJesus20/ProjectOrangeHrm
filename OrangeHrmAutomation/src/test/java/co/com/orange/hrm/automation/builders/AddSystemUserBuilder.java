package co.com.orange.hrm.automation.builders;

import co.com.orange.hrm.automation.models.AddSystemUserModel;
import co.com.orange.hrm.automation.utils.SystemUserEnum;

public class AddSystemUserBuilder {
    private String userRole;
    private String employeeName;
    private String status;
    private String userName;
    private String password;
    private String confirmPass;


    public AddSystemUserBuilder(String userRole) {
        this.userRole = userRole;
    }

    public static AddSystemUserBuilder withUserRole(String userRole) {
        return new AddSystemUserBuilder(userRole);

    }

    public AddSystemUserBuilder andWithEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public AddSystemUserBuilder andWithUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public AddSystemUserBuilder andWithPassword(String password) {
        this.password = password;
        return this;
    }


    public AddSystemUserBuilder andWithStatus(String status) {
        this.status = status;
        return this;
    }


    public AddSystemUserBuilder andWithConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
        return this;
    }

    public AddSystemUserModel build() {
        return new AddSystemUserModel(userRole, employeeName, status, userName, password, confirmPass);
    }

    public static AddSystemUserModel getInfoSystemUser(String userRole, String status) {
        return AddSystemUserBuilder.withUserRole(userRole)
                .andWithEmployeeName(SystemUserEnum.EMPLOYEE_NAME.getInfo())
                .andWithStatus(status)
                .andWithUserName(SystemUserEnum.SYSTEM_USER_NAME.getUserName())
                .andWithPassword(SystemUserEnum.SYSTEM_PASSWORD.getInfo())
                .andWithConfirmPass(SystemUserEnum.SYSTEM_CONFIRM_PASS.getInfo()).build();
    }
}
