package co.com.orange.hrm.automation.stepdefinition;


import co.com.orange.hrm.automation.exceptions.AssertionErrorCustomize;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.List;

import static co.com.orange.hrm.automation.builders.DataVacancyBuilder.withVacancy;

public class CreateVacancyStepDefinition extends TestBase {
    private static final Logger logger = LogManager.getLogger(CreateVacancyStepDefinition.class);

    @When("the user fill out the {string} form")
    public void theUserFillOutTheForm(String subOption, DataTable table) {
        List<List<String>> dataVacancy = table.asLists().subList(1, table.asLists().size());
        viewCandidatesPage.selectingSubMenuOptions(subOption);
        viewCandidatesPage.clickingOnAddVacancy();
        viewCandidatesPage.fillOutAddVacancyForm(withVacancy(dataVacancy.get(0)).withVacancyName().withJobTitle().withDescription().withHiringManager().withNumberPositions().buildVacancyData());
    }


    @Then("the user will see {string} on page")
    public void theUserWillSeeOnPage(String string) {


    }

    @Then("the user will see {string} word on page")
    public void theUserWillSeeWordOnPage(String message) throws AssertionErrorCustomize {
        try {
            Assert.assertTrue((viewCandidatesPage.validatingText().contains(message)));
        } catch (AssertionError e) {
            throw new AssertionErrorCustomize(e).errorMessage();
        }
    }

}
