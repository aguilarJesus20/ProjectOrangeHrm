package co.com.orange.hrm.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainMenuPage extends BasePage{
    WebDriverWait wait;
    @FindBy(how = How.CSS, using = ".oxd-main-menu>li")
    private List<WebElement> menuOptions;

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }


    public void selectingMenuItems(String opt) {
        for (WebElement item : menuOptions) {
            if (item.getText().equals(opt)) {
                item.click();
                break;
            }
        }
    }
}
