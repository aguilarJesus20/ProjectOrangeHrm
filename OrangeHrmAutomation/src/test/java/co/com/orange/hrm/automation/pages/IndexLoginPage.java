package co.com.orange.hrm.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IndexLoginPage {
    private WebDriver driver;

    @FindBy(how = How.NAME,using = "username")
    private WebElement userName;

    @FindBy(how = How.NAME,using = "password")
    private WebElement password;

    @FindBy(how=How.XPATH,using = "//button[@type='submit']")
    private WebElement btnLogin;



    public IndexLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login(String user,String pass){
        userName.sendKeys(user);
        password.sendKeys(pass);
        btnLogin.click();
    }



}
