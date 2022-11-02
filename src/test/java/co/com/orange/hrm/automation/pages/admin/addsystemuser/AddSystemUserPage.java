package co.com.orange.hrm.automation.pages.admin.addsystemuser;

import co.com.orange.hrm.automation.models.AddSystemUserModel;
import co.com.orange.hrm.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddSystemUserPage extends BasePage {

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary>i")
    private WebElement addSystemUser;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text-input')])[1]")
    private WebElement clickOnUserRole;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text-input')])[2]")
    private WebElement clickOnStatus;
    @FindBy(css = "[role='listbox']>div>span")
    private List<WebElement> genericLocator;

    @FindBy(css = "[placeholder='Type for hints...']")
    private WebElement txtEmployeeName;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input oxd-input')])[2]")
    private WebElement txtUserName;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input oxd-input')])[3]")
    private WebElement txtPassword;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input oxd-input')])[4]")
    private WebElement txtConfirmPass;

    @FindBy(css = "[type='submit']")
    private WebElement btnAddSystemUser;


    @FindBy(css = ".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    private WebElement messageError;


    public AddSystemUserPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddSystemButton() {
        wait.until(ExpectedConditions.visibilityOf(addSystemUser)).click();
    }

    public void clickingOnUserRolesList() {
        wait.until(ExpectedConditions.visibilityOf(clickOnUserRole)).click();
    }

    public void genericMethod(String option) {
        for (WebElement generic : genericLocator) {
            if (generic.getText().contains(option)) {
                generic.click();
                break;
            }
        }
    }

    public void selectingUserRole(String nameRole) {
        clickingOnUserRolesList();
        genericMethod(nameRole);
    }

    public void selectingEmployeeName(String name) {
        wait.until(ExpectedConditions.visibilityOf(txtEmployeeName)).sendKeys(name);
        genericMethod(name);
    }

    public void selectingStatusEmployee(String status) {
        wait.until(ExpectedConditions.visibilityOf(clickOnStatus)).click();
        genericMethod(status);
    }

    public void writingUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOf(txtUserName)).sendKeys(userName);
    }

    public void writingPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(messageError).andThen(messageError ->
                wait.until(ExpectedConditions.invisibilityOf(messageError))));
        wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(password);

    }


    public void writingConfirmPass(String confirmPass) {
        wait.until(ExpectedConditions.visibilityOf(txtConfirmPass)).sendKeys(confirmPass);
    }

    public void clickingOnSave() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAddSystemUser)).click();
    }


    public void
    fillInSystemUserForm(AddSystemUserModel systemUser){
        selectingUserRole(systemUser.getUserRole());
        selectingEmployeeName(systemUser.getEmployeeName());
        selectingStatusEmployee(systemUser.getStatus());
        writingUserName(systemUser.getUserName());
        writingPassword(systemUser.getPassword());
        writingConfirmPass(systemUser.getConfirmPass());
        clickingOnSave();
    }
}
