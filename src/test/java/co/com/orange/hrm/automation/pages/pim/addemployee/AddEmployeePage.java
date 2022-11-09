package co.com.orange.hrm.automation.pages.pim.addemployee;

import co.com.orange.hrm.automation.models.EmployeeInformationModel;
import co.com.orange.hrm.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployeePage extends BasePage {
    @FindBy(name = "firstName")
    private WebElement txtFirstName;

    @FindBy(name = "middleName")
    private WebElement txtMiddleName;

    @FindBy(name = "lastName")
    private WebElement txtLastName;

    @FindBy(css = ".oxd-input.oxd-input--active")
    private WebElement employeeId;

    @FindBy(css = ".oxd-switch-input.oxd-switch-input--active.--label-right")
    private WebElement createLoginDetails;

    @FindBy(css = "[type='submit']")
    private WebElement btnSave;


    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text")
    private WebElement successfulSaveEmployee;


    @FindBy(css = ".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    private WebElement errorMessage;

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }


    public void fillingOutNewEmployeeForm(EmployeeInformationModel employeeModel) {
        txtFirstName.sendKeys(employeeModel.getFirstName());
        txtMiddleName.sendKeys(employeeModel.getMiddleName());
        txtLastName.sendKeys(employeeModel.getLastName());
    }

    public void writingFirstName(EmployeeInformationModel employeeModel) {
        txtFirstName.sendKeys(employeeModel.getFirstName());
    }

    public void writingMiddleName(EmployeeInformationModel employeeModel) {
        txtMiddleName.sendKeys(employeeModel.getMiddleName());
    }

    public void writingLastName(EmployeeInformationModel employeeModel) {
        txtLastName.sendKeys(employeeModel.getLastName());
    }

    public void btnSaveEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSave)).click();
    }

    public void clickOnCreateLoginDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(createLoginDetails)).click();
    }

    public String successfulSaveEmployee() {
        return wait.until(ExpectedConditions.visibilityOf(successfulSaveEmployee).andThen(text -> text.getText()));

    }

    public String errorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }


}
