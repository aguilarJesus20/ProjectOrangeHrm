package co.com.orange.hrm.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class IndexLoginPage {
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'orangehrm-demo-credentials')]/child::p")
    private List<WebElement> txtUserData;


    @FindBy(how = How.NAME, using = "username")
    private WebElement userName;

    @FindBy(how = How.NAME, using = "password")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement btnLogin;
    @FindBy(how = How.XPATH, using = "//div/p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement invalidCredentials;


    public IndexLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();

    }

    public String loginWrong() {
        //  driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //  driverWait.until(ExpectedConditions.visibilityOf(invalidCredentials));
        return invalidCredentials.getText();
    }

    public ArrayList<String> getUserInfo() {

        ArrayList<String> data = new ArrayList<>();
        for (WebElement userData : txtUserData) {
            data.add(userData.getText().substring(userData.getText().indexOf(":") + 1).strip());
        }
        return data;
    }


}
