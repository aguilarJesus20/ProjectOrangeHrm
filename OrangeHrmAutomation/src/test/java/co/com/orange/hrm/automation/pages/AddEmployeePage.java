package co.com.orange.hrm.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {
    HomePage homePage;
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

    public AddEmployeePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        homePage = new HomePage(driver);
    }

    public void fillingOutNewEmployeeForm(){
        homePage.btnAddEmployee();
        txtFirstName.sendKeys("Jesus");
        txtMiddleName.sendKeys("Augusto");
        txtLastName.sendKeys("Aguilar");
        employeeId.sendKeys("26321");

    }

    public void btnSave(){
        btnSave.click();
    }




}
