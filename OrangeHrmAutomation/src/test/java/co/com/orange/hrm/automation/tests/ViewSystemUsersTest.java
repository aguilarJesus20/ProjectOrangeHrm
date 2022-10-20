package co.com.orange.hrm.automation.tests;

import co.com.orange.hrm.automation.pages.IndexLoginPage;
import co.com.orange.hrm.automation.pages.admin.adduser.SaveSystemUser;
import co.com.orange.hrm.automation.pages.main.HomePage;
import co.com.orange.hrm.automation.pages.main.MainMenuPage;
import co.com.orange.hrm.automation.utils.Hook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewSystemUsersTest extends Hook {
    MainMenuPage mainMenuPage;
    IndexLoginPage indexLoginPage;
    SaveSystemUser saveSystemUser;
    HomePage homePage;
    @BeforeClass
    public void loadingClasses() {
        indexLoginPage = new IndexLoginPage(driver);
        homePage = new HomePage(driver);
        indexLoginPage.login(indexLoginPage.getUserInfo().get(0), indexLoginPage.getUserInfo().get(1));
        mainMenuPage = new MainMenuPage(driver);
        saveSystemUser = new SaveSystemUser(driver);
    }

    @Test
    public void creatingANewUserAdmin(){
        mainMenuPage.menuItems("Admin");
        homePage.addSystemUser();
        saveSystemUser.selectingUserRole("Admin");

    }
}
