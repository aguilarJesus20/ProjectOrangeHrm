package co.com.orange.hrm.automation.tests;


import co.com.orange.hrm.automation.pages.main.HomePage;
import co.com.orange.hrm.automation.pages.IndexLoginPage;
import co.com.orange.hrm.automation.utils.Hook;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IndexLoginTest extends Hook {

    IndexLoginPage indexLoginPage;
    HomePage homePage;

    @BeforeClass
    public void loadingClasses() {
        homePage = new HomePage(driver);
        indexLoginPage = new IndexLoginPage(driver);
    }

    @Test
    public void validatingLoginCorrectly() {
        indexLoginPage.login(indexLoginPage.getUserInfo().get(0), indexLoginPage.getUserInfo().get(1));
        Assert.assertTrue(homePage.welcome());
    }

    @Test
    public void validatingInvalidCredentials() {
        indexLoginPage.login("user", "pass");
        Assert.assertTrue(indexLoginPage.loginWrong().contains("Invalid credentials"));
    }

}
