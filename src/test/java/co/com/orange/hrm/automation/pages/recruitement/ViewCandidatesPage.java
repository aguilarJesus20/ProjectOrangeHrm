package co.com.orange.hrm.automation.pages.recruitement;

import co.com.orange.hrm.automation.models.VacancyModels;
import co.com.orange.hrm.automation.pages.BasePage;
import co.com.orange.hrm.automation.utils.RandomNum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;


public class ViewCandidatesPage extends BasePage {
    @FindBy(css = ".oxd-topbar-body-nav-tab-item")
    private List<WebElement> subMenuOptions;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addVacancyButton;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement vacancyName;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text-input')])[1]")
    private WebElement clickOnJobTitle;

    @FindBy(css = "[role='listbox']>div>span")
    private List<WebElement> genericLocator;

    @FindBy(css = "[placeholder='Type description here']")
    private WebElement txtDescription;

    @FindBy(css = "[placeholder='Type for hints...']")
    private WebElement txtHiringManager;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    private WebElement txtNumberPosition;

    @FindBy(css = ".oxd-loading-spinner")
    private WebElement loadingSpinner;

    @FindBy(css = "[type='submit']")
    private WebElement clickOnButtonSaveVacancy;

    @FindBy(xpath = "//*[contains(text(),'Successfully Saved')]")
    private WebElement successMessage;

    @FindBy(css = ".oxd-text.oxd-text--h6.orangehrm-main-title.orangehrm-attachment-header__title")
    private WebElement attach;


    public ViewCandidatesPage(WebDriver driver) {
        super(driver);
    }

    public void selectingSubMenuOptions(String opt) {
        for (WebElement subMenu : subMenuOptions) {
            if (subMenu.getText().contains(opt)) {
                subMenu.click();
                break;
            }
        }
    }

    public void clickingOnAddVacancy() {
        wait.until(ExpectedConditions.visibilityOf(addVacancyButton)).click();
    }

    public void fillOutAddVacancyForm(VacancyModels data) {
        wait.until(ExpectedConditions.visibilityOf(vacancyName)).sendKeys(data.getVacancyName().concat(String.valueOf(RandomNum.randomNumber())));
        selectingJobTitle(data.getJobTitle());
        wait.until(ExpectedConditions.visibilityOf(txtDescription)).sendKeys(data.getDescription());
        selectingHiringManager(data.getHiringManager());
        wait.until(ExpectedConditions.visibilityOf(txtNumberPosition)).sendKeys(data.getNumberPositions());

    }

    public void selectingHiringManager(String name) {
        wait.until(ExpectedConditions.visibilityOf(txtHiringManager)).sendKeys(name);
        genericMethod(name);
    }

    public void genericMethod(String option) {
        for (WebElement generic : genericLocator) {
            if (generic.getText().contains(option)) {
                generic.click();
                break;
            }
        }
    }

    public void clickOnJobTitle() {
        wait.until(ExpectedConditions.visibilityOf(clickOnJobTitle)).click();
    }

    public void selectingJobTitle(String nameRole) {
        clickOnJobTitle();
        genericMethod(nameRole);
    }

    public Boolean loadingSpinnerWait()  {
        clickOnButtonSaveVacancy.click();
        return wait.withMessage("attach").withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(attach)).isDisplayed();

    }

    public void clickingOnSaveVacancy() {
        wait.until(ExpectedConditions.visibilityOf(clickOnButtonSaveVacancy)).click();
    }


}
