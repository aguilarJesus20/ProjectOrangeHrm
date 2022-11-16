package co.com.orange.hrm.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/search_employee.feature"}
        , glue = {"co.com.orange.hrm.automation.stepdefinition"}
        , snippets = CucumberOptions.SnippetType.CAMELCASE, publish = true)
public class SearchEmployeeRunners extends AbstractTestNGCucumberTests {
}
