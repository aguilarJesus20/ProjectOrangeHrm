package co.com.orange.hrm.automation.pages.admin.adduser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SaveSystemUser {
    @FindBy(how = How.CSS, using = ".oxd-select-text-input")
    private WebElement btnUserRole;


    //*[contains(text(),'Admin')]/parent::div
    @FindBy(how = How.CSS, using = ".oxd-select-option")
    private List<WebElement> listRoles;
    private WebDriverWait wait;

    public SaveSystemUser(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickingUserRole() {
        wait.until(ExpectedConditions.visibilityOf(btnUserRole)).click();

    }

    public void selectingUserRole(String userRole) {
        for (WebElement role : listRoles) {
            if (role.getText().contains(userRole)) {
                role.click();
                break;
            }
        }
//        wait.until(ExpectedConditions.visibilityOf(select)).click();

        //wait.until(ExpectedConditions.visibilityOf(select)).click();
    }
}
