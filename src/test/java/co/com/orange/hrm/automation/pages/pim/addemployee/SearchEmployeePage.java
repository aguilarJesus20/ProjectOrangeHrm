package co.com.orange.hrm.automation.pages.pim.addemployee;

import co.com.orange.hrm.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchEmployeePage extends BasePage {

    @FindBy(css = "[data-v-2fe357a6]>input")
    private WebElement lblEmployeeId;

    @FindBy(css = "[type='submit']")
    private WebElement searchButton;

    @FindBy(css = "div[class='oxd-table-card'] div:nth-child(3) div:nth-child(1)")
    private WebElement txtEmployeeName;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text oxd-select-text--active')])[3]")
    private WebElement lblJobTitle;

    @FindBy(css = "[role='listbox']>div>span")
    private List<WebElement> selectJob;


    @FindBy(xpath = "(//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[1]")
    private WebElement lblEmployeeName;

    public SearchEmployeePage(WebDriver driver) {
        super(driver);
    }

    public void searchByEmployeeId(String employeeId) {
        wait.until(ExpectedConditions.visibilityOf(lblEmployeeId)).sendKeys(employeeId);
    }

    public void clickingSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public String getEmployeeName() {
        return wait.until(ExpectedConditions.visibilityOf(txtEmployeeName).andThen(employee -> employee.getText()));

    }

    public void clickOnJobTitle() {
        wait.until(ExpectedConditions.visibilityOf(lblJobTitle)).click();
    }

    public void typingEmployeeName(String name) {
        wait.until(ExpectedConditions.visibilityOf(lblEmployeeName)).sendKeys(name);
    }

    public void selectingOption(String option) {
        for (WebElement job : selectJob) {
            if (job.getText().contains(option)) {
                job.click();
                break;
            }
        }

    }

}
