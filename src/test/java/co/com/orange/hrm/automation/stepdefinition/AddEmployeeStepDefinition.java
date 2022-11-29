package co.com.orange.hrm.automation.stepdefinition;

import co.com.orange.hrm.automation.builders.EmployeeInformationBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static co.com.orange.hrm.automation.builders.EmployeeInformationBuilder.getEmployeeData;
import static co.com.orange.hrm.automation.builders.LoginDetailsFormBuilder.getInfo;

public class AddEmployeeStepDefinition extends TestBase {

    @Given("the user adds a new Employee")
    public void theUserAddsANewEmployee() {
        homePage.addEmployeeOption();
    }


    @When("he enters his personal information")
    public void heEntersHisPersonalInformation() {
        addEmployeePage.fillingOutNewEmployeeForm(getEmployeeData());
    }


    @When("he enters login details information with status {string}")
    public void heEntersLoginDetailsInformationWithStatus(String status) {
        addEmployeePage.clickOnCreateLoginDetails();
        loginDetailsSubPage.fillingOutLogin(getInfo(status));
    }


    @When("he enters his first name {string}")
    public void heEntersHisFirstName(String firstName) {
        addEmployeePage.writingFirstName(EmployeeInformationBuilder.withFirstName(firstName).build());
    }

    @When("he enters his {string} {string} {string} personal information")
    public void heEntersHisPersonalInformation(String firstName, String middleName, String lastName) {
        addEmployeePage.fillingOutNewEmployeeForm(getEmployeeData(firstName, middleName, lastName));
    }

    @When("he enters password {string} login details form")
    public void heEntersPasswordLoginDetailsForm(String password) {
        addEmployeePage.clickOnCreateLoginDetails();
        createLoginDetailsSubPage.passwordLoginDetails(password);
    }


    @When("the system saves his information")
    public void theSystemSavesHisInformation() {
        addEmployeePage.btnSaveEmployee();
    }


    @Then("He will see the message on page {string}")
    public void heWillSeeTheMessageOnPage(String message) {
       Assert.assertTrue(addEmployeePage.successfulSaveEmployee().contains(message));

    }

    @Then("he should see the message error {string}")
    public void heShouldSeeTheMessageError(String message) {
        Assert.assertTrue(addEmployeePage.errorMessage().contains(message));
    }

}
