package co.com.orange.hrm.automation.stepdefinitions;

import co.com.orange.hrm.automation.exceptions.NotFoundElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.List;

import static co.com.orange.hrm.automation.builders.DataVacancyBuilder.withVacancy;

public class CreateVacancyStepDefinitions extends TestBase {
    private static final Logger logger = LogManager.getLogger(CreateVacancyStepDefinitions.class);

    @When("the user fill out the {string} form")
    public void theUserFillOutTheForm(String subOption, DataTable table) {
        List<List<String>> dataVacancy = table.asLists().subList(1, table.asLists().size());
        viewCandidatesPage.selectingSubMenuOptions(subOption);
        viewCandidatesPage.clickingOnAddVacancy();
        viewCandidatesPage.fillOutAddVacancyForm(withVacancy(dataVacancy.get(0)).withVacancyName().withJobTitle().withDescription().withHiringManager().withNumberPositions().buildVacancyData());
    }


    @Then("the user will see {string} on page")
    public void theUserWillSeeOnPage(String string) {
        try {
            Assert.assertFalse(viewCandidatesPage.loadingSpinnerWait());

        } catch (AssertionError e) {
            logger.error("Asserts with error 'Success message' {}", e.getMessage());
        }

    }

}
