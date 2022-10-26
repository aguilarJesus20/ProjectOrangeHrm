package co.com.orange.hrm.automation.pages.pim.addemployee;

import co.com.orange.hrm.automation.models.LoginDetailsFormModel;
import co.com.orange.hrm.automation.pages.BasePage;
import co.com.orange.hrm.automation.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CreateLoginDetailsSubPage extends BasePage {

    @FindBy(how = How.CSS, using = ".oxd-radio-input.oxd-radio-input--active.--label-right.oxd-radio-input")
    private List<WebElement> status;

    @FindBy(how = How.CSS, using = "[autocomplete='off'")
    private List<WebElement> txtData;


    @FindBy(how = How.CSS, using = ".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    private WebElement errorMessage;

    public CreateLoginDetailsSubPage(WebDriver driver) {
        super(driver);
    }

    public void userStatus(String opt) {
        wait.until(ExpectedConditions.elementToBeClickable(status.get(Utility.getStatus(opt)))).click();
    }

    public void fillingOutLogin(LoginDetailsFormModel login) {
        ArrayList<String> data = new ArrayList<>();
        data.add(login.getUserNameLogin());
        data.add(login.getPasswordLogin());
        data.add(login.getPasswordLogin());
        for (int i = 0; i < txtData.size(); i++) {
            txtData.get(i).sendKeys(data.get(i));
        }
    }

    public void passwordLoginDetails(String password) {
        txtData.get(1).sendKeys(password);
    }

    public void confirmPasswordDetails(String password) {
        txtData.get(2).sendKeys(password);
    }


    public void userNameLoginDetails(String userName) {
        txtData.get(0).sendKeys(userName);
    }

    public String errorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

}
