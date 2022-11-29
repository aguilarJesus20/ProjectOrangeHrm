package co.com.orange.hrm.automation.stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchSystemUsersStepDefinition extends TestBase {

    @When("he write his information {string}")
    public void heWriteHisInformation(String name) {
        viewSystemUsersPage.writingUserName(name);
        viewSystemUsersPage.clickingOnBtnSearch();
    }

    @Then("he should see his personal information {string}")
    public void heShouldSeeHisPersonalInformation(String name) {
        Assert.assertTrue(viewSystemUsersPage.getEmployeeName());
    }

    @When("he select his userRole {string} and {string}")
    public void heSelectHisUserRoleAnd(String userRole, String userName) {
        viewSystemUsersPage.writingUserName(userName);
        systemUserPage.selectingUserRole(userRole);
        viewSystemUsersPage.clickingOnBtnSearch();

    }

    @When("he select his status information {string} and {string}")
    public void heSelectHisStatusInformationAnd(String status, String userName) {
        viewSystemUsersPage.writingUserName(userName);
        systemUserPage.selectingStatusEmployee(status);
        viewSystemUsersPage.clickingOnBtnSearch();
    }


}
