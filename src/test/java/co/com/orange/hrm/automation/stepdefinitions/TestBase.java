package co.com.orange.hrm.automation.stepdefinitions;

import co.com.orange.hrm.automation.pages.HomePage;
import co.com.orange.hrm.automation.pages.IndexLoginPage;
import co.com.orange.hrm.automation.pages.MainMenuPage;
import co.com.orange.hrm.automation.pages.admin.ViewSystemUsersPage;
import co.com.orange.hrm.automation.pages.admin.addsystemuser.AddSystemUserPage;
import co.com.orange.hrm.automation.pages.pim.addemployee.AddEmployeePage;
import co.com.orange.hrm.automation.pages.pim.addemployee.CreateLoginDetailsSubPage;
import co.com.orange.hrm.automation.pages.pim.addemployee.SearchEmployeePage;
import co.com.orange.hrm.automation.pages.recruitement.ViewCandidatesPage;
import org.openqa.selenium.WebDriver;

import static co.com.orange.hrm.automation.stepdefinitions.Hook.getDriver;

public class TestBase {
    public WebDriver driver = getDriver();


    public HomePage homePage = new HomePage(driver);
    public AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
    public CreateLoginDetailsSubPage loginDetailsSubPage = new CreateLoginDetailsSubPage(driver);
    public CreateLoginDetailsSubPage createLoginDetailsSubPage = new CreateLoginDetailsSubPage(driver);

    public IndexLoginPage loginPage = new IndexLoginPage(driver);


    public SearchEmployeePage searchEmployeePage = new SearchEmployeePage(driver);

    public MainMenuPage menuPage = new MainMenuPage(driver);

    public AddSystemUserPage systemUserPage = new AddSystemUserPage(driver);

    public ViewSystemUsersPage viewSystemUsersPage = new ViewSystemUsersPage(driver);

    public ViewCandidatesPage viewCandidatesPage = new ViewCandidatesPage(driver);



}
