package co.com.orange.hrm.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static co.com.orange.hrm.automation.builders.AddSystemUserBuilder.getInfoSystemUser;

public class AddSystemUserStepDefinitions extends TestBase {

    @Given("the user is on the {string} menu option")
    public void theUserIsOnTheAdminMenuOption(String option) {
        menuPage.selectingMenuItems(option);
    }


    @Given("he click on Add System user button")
    public void heClickOnAddSystemUserButton() {
        systemUserPage.clickAddSystemButton();
    }

    @When("he fill in the system user form with {string} and status {string}")
    public void heFillInTheSystemUserFormWithAndStatus(String userRole, String status) {
        systemUserPage.fillInSystemUserForm(getInfoSystemUser(userRole, status));
    }

}
