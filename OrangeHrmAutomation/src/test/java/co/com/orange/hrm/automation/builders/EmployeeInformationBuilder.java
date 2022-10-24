package co.com.orange.hrm.automation.builders;

import co.com.orange.hrm.automation.models.EmployeeInformationModel;
import co.com.orange.hrm.automation.utils.UserDataEnum;

public class EmployeeInformationBuilder {
    private String firstName;
    private String middleName;
    private String lastName;


    public EmployeeInformationBuilder(String firstName) {
        this.firstName = firstName;
    }

    public static EmployeeInformationBuilder withFirstName(String firstName) {
        return new EmployeeInformationBuilder(firstName);
    }

    public EmployeeInformationBuilder andMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public EmployeeInformationBuilder andLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeInformationModel build() {
        return new EmployeeInformationModel(firstName, middleName, lastName);
    }


    public static EmployeeInformationModel getEmployeeData(String firstName,String middleName,String lastName) {
        return EmployeeInformationBuilder.withFirstName(firstName).andMiddleName(middleName).andLastName(lastName).build();
    }

    public static EmployeeInformationModel getEmployeeData() {
        return EmployeeInformationBuilder.withFirstName(UserDataEnum.EMPLOYEE_FIRST_NAME.getInfo()).andMiddleName(UserDataEnum.EMPLOYEE_MIDDLE_NAME.getInfo()).andLastName(UserDataEnum.EMPLOYEE_LAST_NAME.getInfo()).build();
    }

    public static EmployeeInformationModel getEmployeeFirstName(String firstName) {
        return EmployeeInformationBuilder.withFirstName(firstName).build();
    }

    public static EmployeeInformationModel getEmployeeMiddleName() {
        return EmployeeInformationBuilder.withFirstName(UserDataEnum.EMPLOYEE_MIDDLE_NAME.getInfo()).build();
    }

    public static EmployeeInformationModel getEmployeeLastName() {
        return EmployeeInformationBuilder.withFirstName(UserDataEnum.EMPLOYEE_LAST_NAME.getInfo()).build();
    }
}
