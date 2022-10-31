package co.com.orange.hrm.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/add-system-user.feature"}
        , glue = {"co.com.orange.hrm.automation.stepdefinitions"}
        , snippets = CucumberOptions.SnippetType.CAMELCASE, publish = true)
public class AddSystemUserRunners extends AbstractTestNGCucumberTests {
}
