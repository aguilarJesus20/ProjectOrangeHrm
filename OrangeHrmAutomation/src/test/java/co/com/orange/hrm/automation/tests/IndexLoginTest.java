package co.com.orange.hrm.automation.tests;

import co.com.orange.hrm.automation.pages.HomePage;
import co.com.orange.hrm.automation.pages.IndexLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IndexLoginTest {
    WebDriver driver;
    IndexLoginPage indexLoginPage;
    HomePage homePage;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        indexLoginPage = new IndexLoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void validatingLoginCorrectly(){
        indexLoginPage.login("Admin","admin123");
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.welcome().contains("Paul Collings"));
    }

    @AfterTest
    public void endBrowser(){
        driver.quit();
    }
}
