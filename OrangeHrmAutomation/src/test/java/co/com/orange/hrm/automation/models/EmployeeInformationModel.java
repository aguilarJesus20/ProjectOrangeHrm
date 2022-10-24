package co.com.orange.hrm.automation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeInformationModel {
    private String firstName;
    private String middleName;
    private String lastName;
}
