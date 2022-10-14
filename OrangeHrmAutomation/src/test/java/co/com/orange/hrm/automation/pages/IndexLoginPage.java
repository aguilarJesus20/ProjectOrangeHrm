package co.com.orange.hrm.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexLoginPage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    @FindBy(how = How.NAME,using = "username")
    private WebElement userName;

    @FindBy(how = How.NAME,using = "password")
    private WebElement password;

    @FindBy(how=How.XPATH,using = "//button[@type='submit']")
    private WebElement btnLogin;
    @FindBy(how=How.XPATH,using = "//div/p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement invalidCredentials;

    public IndexLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login(String user,String pass){
        userName.sendKeys(user);
        password.sendKeys(pass);
        btnLogin.click();
    }
    public String loginWrong(){
      //  driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  driverWait.until(ExpectedConditions.visibilityOf(invalidCredentials));
        return invalidCredentials.getText();
    }


}
