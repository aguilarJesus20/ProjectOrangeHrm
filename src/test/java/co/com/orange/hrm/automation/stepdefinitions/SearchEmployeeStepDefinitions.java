package co.com.orange.hrm.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchEmployeeStepDefinitions extends TestBase {

    @Given("the user types his employee id {string}")
    public void theUserTypesHisEmployeeId(String employeeId) {
        searchEmployeePage.searchByEmployeeId(employeeId);
    }

    @When("the user search his information in the system")
    public void theUserSearchHisInformationInTheSystem() {
        searchEmployeePage.clickingSearchButton();
    }


    @Given("the user select job title {string}")
    public void theUserSelectJobTitle(String jobName) {
        searchEmployeePage.clickOnJobTitle();
        searchEmployeePage.selectingOption(jobName);
    }

    @Given("the user types his name {string}")
    public void theUserTypesHisName(String name) {
        searchEmployeePage.typingEmployeeName(name);
        searchEmployeePage.selectingOption(name);
    }


    @Then("the user will see the basic employee information about {string}")
    public void theUserWillSeeTheBasicEmployeeInformationAbout(String employeeName) {
        Assert.assertTrue(searchEmployeePage.getEmployeeName().contains(employeeName));
    }


}
