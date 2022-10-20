package co.com.orange.hrm.automation.pages.pim.addemployee;

import co.com.orange.hrm.automation.pages.main.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage {
    HomePage homePage;

    WebDriverWait wait ;
    @FindBy(how= How.NAME,using = "firstName")
    private WebElement txtFirstName;

    @FindBy(how= How.NAME,using = "middleName")
    private WebElement txtMiddleName;

    @FindBy(how= How.NAME,using = "lastName")
    private WebElement txtLastName;

    @FindBy(how= How.CSS,using = ".oxd-input.oxd-input--active")
    private WebElement employeeId;

    @FindBy(how = How.CSS,using = ".oxd-switch-input.oxd-switch-input--active.--label-right")
    private WebElement createLoginDetails;

    @FindBy(how = How.CSS,using = "[type='submit']")
    private WebElement btnSave;


    @FindBy(how = How.CSS,using = ".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text")
    private WebElement successfulSaveEmployee;



    public AddEmployeePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void fillingOutNewEmployeeForm(String name,String middleName,String lastName){
        txtFirstName.sendKeys(name);
        txtMiddleName.sendKeys(middleName);
        txtLastName.sendKeys(lastName);
    }

    public void btnSaveEmployee(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSave)).click();
    }

    public void clickOnCreateLoginDetails(){
       wait.until(ExpectedConditions.elementToBeClickable(createLoginDetails)).click();
    }


    public String successfulSaveEmployee(){
        wait.until(ExpectedConditions.visibilityOf(successfulSaveEmployee));
        return successfulSaveEmployee.getText();
    }






}
