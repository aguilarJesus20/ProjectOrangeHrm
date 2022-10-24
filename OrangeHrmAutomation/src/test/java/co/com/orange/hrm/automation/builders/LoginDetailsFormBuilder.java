package co.com.orange.hrm.automation.builders;

import co.com.orange.hrm.automation.models.IndexLoginModel;
import co.com.orange.hrm.automation.models.LoginDetailsFormModel;
import co.com.orange.hrm.automation.utils.UserDataEnum;

public class LoginDetailsFormBuilder {
    private String userNameLogin;
    private String status;
    private String passwordLogin;
    private String confirmPasswordLogin;

    public LoginDetailsFormBuilder(String userNameLogin) {
        this.userNameLogin = userNameLogin;
    }

    public static LoginDetailsFormBuilder withUserNameLogin(String userNameLogin) {
        return new LoginDetailsFormBuilder(userNameLogin);
    }

    public LoginDetailsFormBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public LoginDetailsFormBuilder withPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
        return this;
    }

    public LoginDetailsFormBuilder withReconfirmPasswordLogin(String confirmPasswordLogin) {
        this.confirmPasswordLogin = confirmPasswordLogin;
        return this;
    }

    public LoginDetailsFormModel build() {
        return new LoginDetailsFormModel(userNameLogin, status, passwordLogin, confirmPasswordLogin);
    }
}
