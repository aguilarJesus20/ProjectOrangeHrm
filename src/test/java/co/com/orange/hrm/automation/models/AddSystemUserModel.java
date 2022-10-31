package co.com.orange.hrm.automation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddSystemUserModel {
    private String userRole;
    private String employeeName;
    private String status;
    private String userName;
    private String password;
    private String confirmPass;
}
