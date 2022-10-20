package co.com.orange.hrm.automation.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainMenuPage {
    WebDriverWait wait;
    @FindBy(how = How.CSS, using = ".oxd-main-menu>li")
    private List<WebElement> menuOptions;


    public MainMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void menuItems(String opt) {
        for (WebElement item : menuOptions) {
            if (item.getText().equals(opt)) {
                item.click();
                break;
            }
        }
    }
}
