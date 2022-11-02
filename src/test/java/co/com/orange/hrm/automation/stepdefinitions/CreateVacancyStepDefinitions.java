package co.com.orange.hrm.automation.stepdefinitions;

import co.com.orange.hrm.automation.models.VacancyDataTable;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CreateVacancyStepDefinitions extends TestBase {
    @When("the user fill out the {string} form")
    public void theUserFillOutTheForm(String subOption, List<Map<String, String>> data) {
        viewCandidatesPage.selectingSubMenuOptions(subOption);
        viewCandidatesPage.clickingOnAddVacancy();
        viewCandidatesPage.fillOutAddVacancyForm(new VacancyDataTable(data));
        viewCandidatesPage.clickingOnSaveVacancy();
       // viewCandidatesPage.loadingSpinnerWait();
    }
}
