package co.com.orange.hrm.automation.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static co.com.orange.hrm.automation.builders.AddSystemUserBuilder.getInfoSystemUser;

public class AddSystemUserStepDefinition extends TestBase {

    @Given("the user is on the {string} menu option")
    public void theUserIsOnTheAdminMenuOption(String option) {
        menuPage.selectingMenuItems(option);
    }


    @When("he fill in the system user form with {string} and status {string}")
    public void heFillInTheSystemUserFormWithAndStatus(String userRole, String status) {
        systemUserPage.clickAddSystemButton();
        systemUserPage.fillInSystemUserForm(getInfoSystemUser(userRole, status));
    }

}
