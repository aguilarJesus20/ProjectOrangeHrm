package co.com.orange.hrm.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(how = How.CSS,using = ".oxd-userdropdown-name")
    private WebElement messageTxt;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String welcome(){
        return messageTxt.getText();
    }
}
