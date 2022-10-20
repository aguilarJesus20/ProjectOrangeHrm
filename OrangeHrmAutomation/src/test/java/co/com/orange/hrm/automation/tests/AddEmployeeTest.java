package co.com.orange.hrm.automation.tests;

import co.com.orange.hrm.automation.pages.main.HomePage;
import co.com.orange.hrm.automation.pages.IndexLoginPage;
import co.com.orange.hrm.automation.pages.pim.addemployee.AddEmployeePage;
import co.com.orange.hrm.automation.pages.pim.addemployee.CreateLoginDetailsSubPage;
import co.com.orange.hrm.automation.utils.ErrorMessagesEnum;
import co.com.orange.hrm.automation.utils.Hook;
import co.com.orange.hrm.automation.utils.UserDataEnum;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddEmployeeTest extends Hook {

    IndexLoginPage indexLoginPage;
    AddEmployeePage addEmployeePage;
    CreateLoginDetailsSubPage createLoginDetailsSubPage;
    HomePage homePage;

    @BeforeClass
    public void loadingClasses() {
        homePage = new HomePage(driver);
        addEmployeePage = new AddEmployeePage(driver);
        createLoginDetailsSubPage = new CreateLoginDetailsSubPage(driver);
        indexLoginPage = new IndexLoginPage(driver);
        indexLoginPage.login(indexLoginPage.getUserInfo().get(0), indexLoginPage.getUserInfo().get(1));
    }

    @Test
    public void creatingAnEmployeeSuccessful() {
        homePage.addEmployeeOption();
        addEmployeePage.fillingOutNewEmployeeForm(UserDataEnum.EMPLOYEE_FIRST_NAME.getInfo(), UserDataEnum.EMPLOYEE_MIDDLE_NAME.getInfo(), UserDataEnum.EMPLOYEE_LAST_NAME.getInfo());
        addEmployeePage.btnSaveEmployee();
        Assert.assertTrue(addEmployeePage.successfulSaveEmployee().contains("Success"));
    }

    @Test
    public void creatingAnEmployeeWithLoginDetails() {
        homePage.addEmployeeOption();
        addEmployeePage.fillingOutNewEmployeeForm(UserDataEnum.EMPLOYEE_FIRST_NAME.getInfo(), UserDataEnum.EMPLOYEE_MIDDLE_NAME.getInfo(), UserDataEnum.EMPLOYEE_LAST_NAME.getInfo());
        addEmployeePage.clickOnCreateLoginDetails();
        createLoginDetailsSubPage.userStatus("Disable");
        createLoginDetailsSubPage.fillingOutLogin(UserDataEnum.LOGIN_DETAILS_USER_NAME.getLoginDetails(), UserDataEnum.LOGIN_DETAILS_PASSWORD.getInfo());
        addEmployeePage.btnSaveEmployee();
        Assert.assertTrue(addEmployeePage.successfulSaveEmployee().contains("Success"));
    }

    @Test
    public void passwordLessThanPermitted() {
        homePage.addEmployeeOption();
        addEmployeePage.clickOnCreateLoginDetails();
        createLoginDetailsSubPage.passwordLoginDetails("12");
        Assert.assertEquals(createLoginDetailsSubPage.errorMessage(), ErrorMessagesEnum.AT_LEAST_EIGHT_PASS.getObjMessage());
    }

    @Test
    public void userNameLessThanPermitted() {
        homePage.addEmployeeOption();
        addEmployeePage.clickOnCreateLoginDetails();
        createLoginDetailsSubPage.userNameLoginDetails("je");
        Assert.assertEquals(createLoginDetailsSubPage.errorMessage(), ErrorMessagesEnum.AT_LEAST_FIVE_USER.getObjMessage());
    }

    @Test
    public void userNameExceedCharacters() {
        homePage.addEmployeeOption();
        addEmployeePage.clickOnCreateLoginDetails();
        createLoginDetailsSubPage.userNameLoginDetails("OctubreOctubreOctubreOctubreOctubreOctubreOctubre");
        Assert.assertEquals(createLoginDetailsSubPage.errorMessage(), ErrorMessagesEnum.EXCEED_CHARACTERS.getObjMessage());
    }

    @Test
    public void writingAWeakPassword() {
        homePage.addEmployeeOption();
        addEmployeePage.clickOnCreateLoginDetails();
        createLoginDetailsSubPage.passwordLoginDetails("test2021");
        Assert.assertEquals(createLoginDetailsSubPage.errorMessage(), ErrorMessagesEnum.WEAK_PASSWORD.getObjMessage());
    }

    @Test
    public void userNameEmpty() {
        homePage.addEmployeeOption();
        addEmployeePage.clickOnCreateLoginDetails();
        createLoginDetailsSubPage.userNameLoginDetails("  ");
        Assert.assertEquals(createLoginDetailsSubPage.errorMessage(), ErrorMessagesEnum.REQUIRED.getObjMessage());
    }

    @Test
    public void passwordEmpty() {
        homePage.addEmployeeOption();
        addEmployeePage.clickOnCreateLoginDetails();
        createLoginDetailsSubPage.passwordLoginDetails("  ");
        Assert.assertEquals(createLoginDetailsSubPage.errorMessage(), ErrorMessagesEnum.REQUIRED.getObjMessage());
    }

    @Test
    public void confirmPasswordNotMatch() {
        homePage.addEmployeeOption();
        addEmployeePage.clickOnCreateLoginDetails();
        createLoginDetailsSubPage.passwordLoginDetails("Test2021@");
        createLoginDetailsSubPage.confirmPasswordDetails("test");
        Assert.assertEquals(createLoginDetailsSubPage.errorMessage(), ErrorMessagesEnum.PASSWORD_NOT_MATCH.getObjMessage());
    }


}


