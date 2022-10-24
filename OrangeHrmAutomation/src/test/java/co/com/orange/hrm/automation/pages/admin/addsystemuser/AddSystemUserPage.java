package co.com.orange.hrm.automation.pages.admin.addsystemuser;

import co.com.orange.hrm.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddSystemUserPage extends BasePage {

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary>i")
    private WebElement addSystemUser;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text oxd-select-text--active')])[1]")
    private WebElement clickOnUserRole;

    @FindBy(css = "[role='listbox']>div>span")
    private List<WebElement> userRoleList;

    public AddSystemUserPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddSystemButton() {
        wait.until(ExpectedConditions.visibilityOf(addSystemUser)).click();
    }

    public void clickingOnUserRolesList() {
        wait.until(ExpectedConditions.visibilityOf(clickOnUserRole)).click();
    }

    public void fillInSystemUserForm() {

    }
}
