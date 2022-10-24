package co.com.orange.hrm.automation.stepdefinitions;

import co.com.orange.hrm.automation.builders.IndexLoginBuilder;
import co.com.orange.hrm.automation.utils.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static co.com.orange.hrm.automation.stepdefinitions.Hook.getUrl;

public class IndexLoginStepDefinitions extends TestBase {

    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        getUrl(Utility.getUrl());
    }

    @When("he enters username and password correctly")
    public void heEntersUsernameAndPasswordCorrectly() {
        loginModel = IndexLoginBuilder.withName(loginPage.getUserInfo().get(0)).andPassword(loginPage.getUserInfo().get(1)).build();
        loginPage.login(loginModel);
    }

    @When("click Sign-in")
    public void clickSignIn() {
        loginPage.clickingSignIn();
    }

    @When("he enters username {string} and password {string} incorrect")
    public void heEntersUsernameAndPasswordIncorrect(String userName, String password) {
        loginModel = IndexLoginBuilder.withName(userName).andPassword(password).build();
        loginPage.login(loginModel);
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
