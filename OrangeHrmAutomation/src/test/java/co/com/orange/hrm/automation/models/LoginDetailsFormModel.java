package co.com.orange.hrm.automation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDetailsFormModel {
    private String userNameLogin;
    private String status;
    private String passwordLogin;
    private String confirmPasswordLogin;
}
