package co.com.orange.hrm.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(how = How.XPATH,using = "//img[contains(@alt,'banner')]")
    private WebElement welcomeLogo;

    @FindBy(how = How.XPATH,using = "//*[contains(text(),'Add Employee')]")
    private WebElement btnAddEmployee;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Boolean welcome(){
        return welcomeLogo.isEnabled();
    }

    public void btnAddEmployee(){
        btnAddEmployee.click();
    }
}
