package co.com.orange.hrm.automation.pages;

import co.com.orange.hrm.automation.models.IndexLoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class IndexLoginPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'orangehrm-demo-credentials')]/child::p")
    private List<WebElement> txtUserData;

    @FindBy(name = "username")
    private WebElement txtUserName;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//div/p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement invalidCredentials;

    public IndexLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(IndexLoginModel login) {
        wait.until(ExpectedConditions.visibilityOf(txtUserName)).sendKeys(login.getUserName());
        wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(login.getPassword());
    }

    public void clickingSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }

    public ArrayList<String> getUserInfo() {
        ArrayList<String> data = new ArrayList<>();
        for (WebElement userData : txtUserData) {
            data.add(userData.getText().substring(userData.getText().indexOf(":") + 1).strip());
        }
        return data;
    }

    public String loginWrong() {
        return wait.until(ExpectedConditions.elementToBeClickable(invalidCredentials)).getText();
    }


}
