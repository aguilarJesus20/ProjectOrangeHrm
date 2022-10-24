package co.com.orange.hrm.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddSystemUserStepDefinitions extends TestBase {

    @Given("the user is on the {string} menu option")
    public void theUserIsOnTheAdminMenuOption(String option) {
        menuPage.selectingMenuItems(option);
        systemUserPage.clickAddSystemButton();
    }

    @When("he fill in the system user form")
    public void heFillInTheSystemUserForm() {
        systemUserPage.clickingOnUserRolesList();

    }

    @Then("he should see the success message on the page")
    public void heShouldSeeTheSuccessMessageOnThePage() {

    }
}
