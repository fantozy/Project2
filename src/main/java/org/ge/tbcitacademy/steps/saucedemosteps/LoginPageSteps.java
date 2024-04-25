package org.ge.tbcitacademy.steps.saucedemosteps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.ge.tbcitacademy.pages.saucedemopage.LoginPage;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.*;
import static org.ge.tbcitacademy.data.Constants.SauceDemo_Constants.ERROR_MESSAGE;
import static org.ge.tbcitacademy.data.Constants.SauceDemo_Constants.NOT_DISPLAYED;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();

    @Step("Fill username input")
    public LoginPageSteps inputUsername(String username) {
        loginPage.loginInput.sendKeys(username);
        return this;
    }
    @Step("Fill password input")
    public LoginPageSteps inputPassword(String password) {
        loginPage.passwordInput.sendKeys(password);
        return this;
    }
    @Step("Login")
    public LoginPageSteps clickLoginButton() {
        loginPage.loginButton.click();
        return this;
    }
    @Step("Validate that error message appear")
    public LoginPageSteps validateErrorMessageAppear() {
        loginPage.errorMessage.shouldHave(text(ERROR_MESSAGE));
        return this;
    }
    @Step("Validate that red error icon appear")
    public LoginPageSteps validateInputRedIconsAppear(SoftAssert softAssert) {
        for (SelenideElement errorIcon : loginPage.errorIcons ) {
            softAssert.assertTrue(errorIcon.isDisplayed(), NOT_DISPLAYED);
        }
        return this;
    }
    @Step("Validate that form red error icons appear")
    public void validateFormErrorRedButtonAppear() {
        loginPage.errorButton.shouldBe(visible);
    }
    @Step("Validate that username input is empty")
    public LoginPageSteps validateUsernameInputIsEmpty() {
        loginPage.loginInput.shouldBe(empty);
        return this;
    }
    @Step("Validate that password input is empty")
    public void validatePasswordInputIsEmpty() {
        loginPage.passwordInput.shouldBe(empty);
    }
}
