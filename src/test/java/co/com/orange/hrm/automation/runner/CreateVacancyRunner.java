package co.com.orange.hrm.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/create_vacancy.feature"}, glue = {"co.com.orange.hrm.automation.stepdefinition"}, snippets = CucumberOptions.SnippetType.CAMELCASE, plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"})
public class CreateVacancyRunner extends AbstractTestNGCucumberTests {
}
