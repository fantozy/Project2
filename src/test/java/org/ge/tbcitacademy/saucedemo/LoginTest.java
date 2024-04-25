package org.ge.tbcitacademy.saucedemo;

import io.qameta.allure.*;
import org.ge.tbcitacademy.data.Database.DatabaseSteps;
import org.ge.tbcitacademy.data.UserModel;
import org.ge.tbcitacademy.data.config.TestConfiguration;
import org.ge.tbcitacademy.data.listeners.TestListener;
import org.ge.tbcitacademy.steps.saucedemosteps.LandingPageSteps;
import org.ge.tbcitacademy.steps.saucedemosteps.LoginPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.ge.tbcitacademy.data.Constants.SauceDemo_Constants.*;

@Test(groups = {"SauceDemoLogin"})
@Listeners({TestListener.class})
@Epic("SauceDemo Login")
public class LoginTest extends TestConfiguration {
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    LandingPageSteps landingPageSteps = new LandingPageSteps();
    DatabaseSteps databaseSteps = new DatabaseSteps();

    @BeforeMethod
    public void setup() {
        open(SAUCEDEMO_URL);
    }


    @Test
    @Description("Verify successful login with valid credentials.")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Login Feature")
    @Story("As a user, I want to login successfully to access the application.")
    public void successfulLoginTest() {
        UserModel user = databaseSteps.selectUser(STANDARD_USER);
        loginPageSteps
                .inputUsername(user.getUsername())
                .inputPassword(user.getPassword())
                .clickLoginButton();
        landingPageSteps.validateImages(softAssert);
        softAssert.assertAll();
    }

    @Test
    @Description("Verify login attempt with a banned user.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Login Feature")
    @Story("As a user, I want to be informed if my account is banned when attempting to log in.")
    public void bannedUserLoginTest() {
        UserModel user = databaseSteps.selectUser(LOCKED_OUT_USER);
        loginPageSteps
                .inputUsername(user.getUsername())
                .inputPassword(user.getPassword())
                .clickLoginButton()
                .validateErrorMessageAppear()
                .validateInputRedIconsAppear(softAssert)
                .validateFormErrorRedButtonAppear();
        softAssert.assertAll();
    }

    @Test
    @Description("Validate loaded images")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Loaded images")
    @Story("As a logged-in user, I want to be able to see valid images for each product.")
    public void problematicLoginTest() {
        UserModel user = databaseSteps.selectUser(PROBLEM_USER);
        loginPageSteps
                .inputUsername(user.getUsername())
                .inputPassword(user.getPassword())
                .clickLoginButton();
        landingPageSteps
                .validateImages(softAssert)
                .validateImagesUnique(softAssert);
        softAssert.assertAll();
    }
    @Test
    @Description("Verify logout functionality.")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Logout Feature")
    @Story("As a logged-in user, I want to be able to logout from the application.")
    public void logoutTest() {
        UserModel user = databaseSteps.selectUser(STANDARD_USER);
        loginPageSteps
                .inputUsername(user.getUsername())
                .inputPassword(user.getPassword())
                .clickLoginButton();
        landingPageSteps
                .openBurgerMenu()
                .logout();
        loginPageSteps
                .validateUsernameInputIsEmpty()
                .validatePasswordInputIsEmpty();
        System.out.println("Hello world");
    }
}
