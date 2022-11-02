package co.com.orange.hrm.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/create-vacancy.feature"}, glue = {"co.com.orange.hrm.automation.stepdefinitions"}, snippets = CucumberOptions.SnippetType.CAMELCASE, plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"})
public class CreateVacancyRunners extends AbstractTestNGCucumberTests {
}
