package tests;


import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    public String email = "test33333@test.com";
    public String password = "FdJnx@SXP7uSspJ";

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() {
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration("Ahmed", "Madyan",
                email, password, password);
    }

    @Test(dependsOnMethods = "UserCanRegisterSuccessfully")
    public void RegisteredUserCanLogout() {
        homePage = new HomePage(driver);
        homePage.userLogout();
    }

    @Test(dependsOnMethods = "RegisteredUserCanLogout")
    public void RegisteredUserCanLogin() {
        loginPage = new LoginPage(driver);
        homePage.openLoginPage();
        loginPage.login(email, password);
    }
}
