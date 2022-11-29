package co.com.orange.hrm.automation.stepdefinition;

import co.com.orange.hrm.automation.utils.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static co.com.orange.hrm.automation.builders.IndexLoginBuilder.*;
import static co.com.orange.hrm.automation.stepdefinition.Hook.getUrl;

public class IndexLoginStepDefinition extends TestBase {

    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        getUrl(Utility.getUrl());
    }

    @When("he enters username and password correctly")
    public void heEntersUsernameAndPasswordCorrectly() {
        loginPage.login(withName(loginPage.getUserInfo().get(0)).andPassword(loginPage.getUserInfo().get(1)).buildLogin());
    }

    @When("he enters username {string} and password {string} incorrect")
    public void heEntersUsernameAndPasswordIncorrect(String userName, String password) {
        loginPage.login(withName(userName).andPassword(password).buildLogin());
    }


    @Then("He will see the main page")
    public void heWillSeeTheMainPage() {
        Assert.assertTrue(homePage.welcome());
    }


    @Then("He will see an error message {string}")
    public void heWillSeeAnErrorMessage(String message) {
        Assert.assertTrue(loginPage.loginWrong().contains(message));
    }
}
