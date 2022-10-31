package co.com.orange.hrm.automation.pages.admin;

import co.com.orange.hrm.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ViewSystemUsersPage extends BasePage {
    @FindBy(css = ".oxd-input-group.oxd-input-field-bottom-space>div>.oxd-input.oxd-input--active")
    private WebElement txtUserName;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text oxd-select-text')])[1]")
    private WebElement btnUserRole;

    @FindBy(css = "[role='listbox']>div>span")
    private List<WebElement> genericLocator;

    @FindBy(css = "[type='submit']")
    private WebElement btnSearch;

    @FindBy(xpath = "(//div[@class='oxd-table-row oxd-table-row--with-border'])[last()]")
    private WebElement getEmployeeNameTable;

    @FindBy(css = ".oxd-loading-spinner")
    private WebElement loadingSpinner;


    public ViewSystemUsersPage(WebDriver driver) {
        super(driver);
    }

    public void writingUserName(String name) {
        wait.until(ExpectedConditions.visibilityOf(txtUserName)).sendKeys(name);

    }

    public void clickingOnBtnSearch() {
        wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
    }

    public void loadingSpinnerWait() {
        loadingSpinner.isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));


    }

    public Boolean getEmployeeName() {
        loadingSpinnerWait();
        return wait.until(ExpectedConditions.visibilityOf(getEmployeeNameTable)).isDisplayed();
    }


}
