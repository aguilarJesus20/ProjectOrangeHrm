package co.com.orange.hrm.automation.tests;

import co.com.orange.hrm.automation.pages.HomePage;
import co.com.orange.hrm.automation.pages.IndexLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IndexLoginTest {
    WebDriver driver;
    WebDriverWait driverWait;
    IndexLoginPage indexLoginPage;
    HomePage homePage;

    @BeforeMethod
    @Parameters({"url"})
    public void setUp(String url) {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities dcap = new DesiredCapabilities();
        dcap.setCapability("pageLoadStrategy", "normal");
        ChromeOptions opt = new ChromeOptions();
        opt.merge(dcap);
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(url);
        indexLoginPage = new IndexLoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test(priority = 0)
    @Parameters({"user", "pass"})
    public void validatingLoginCorrectly(String user, String pass) {
        SoftAssert softAssert = new SoftAssert();
        indexLoginPage.login(user, pass);
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.welcome());
        //softAssert.assertTrue(homePage.welcome().contains("Paul Collings"));

    }

    @Test(priority = 1)
    public void validatingInvalidCredentials() {
        indexLoginPage.login("user", "pass");
        Assert.assertTrue(indexLoginPage.loginWrong().contains("Invalid credentials"));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }


}
