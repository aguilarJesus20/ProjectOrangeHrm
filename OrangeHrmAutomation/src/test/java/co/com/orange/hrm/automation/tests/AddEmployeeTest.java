package co.com.orange.hrm.automation.tests;

import co.com.orange.hrm.automation.pages.AddEmployeePage;
import co.com.orange.hrm.automation.pages.HomePage;
import co.com.orange.hrm.automation.pages.IndexLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AddEmployeeTest {
    WebDriver driver;
    IndexLoginPage indexLoginPage;
    AddEmployeePage addEmployeePage;

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

    @Test(priority = 1)
    @Parameters({"user", "pass"})
    public void fillingOutEmployeeWithOutLoginDetails(String user, String pass) {
        indexLoginPage.login(user, pass);
        addEmployeePage = new AddEmployeePage(driver);
        addEmployeePage.fillingOutNewEmployeeForm();
        addEmployeePage.btnSave();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }


}


