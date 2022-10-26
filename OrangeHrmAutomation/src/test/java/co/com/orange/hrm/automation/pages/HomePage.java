package co.com.orange.hrm.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//img[contains(@alt,'banner')]")
    private WebElement welcomeLogo;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Add Employee')]")
    private WebElement btnAddEmployee;

    @FindBy(how = How.CSS, using = ".oxd-button.oxd-button--medium.oxd-button--secondary:first-child")
    private WebElement btnAddSystemUser;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Boolean welcome() {
        return welcomeLogo.isEnabled();
    }

    public void addEmployeeOption() {
        wait.until(ExpectedConditions.visibilityOf(btnAddEmployee)).click();
    }

    public void addSystemUser() {
        wait.until(ExpectedConditions.visibilityOf(btnAddSystemUser)).click();
    }


}
