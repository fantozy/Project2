package org.ge.tbcitacademy.steps.tnetsteps;

import io.qameta.allure.Step;
import org.ge.tbcitacademy.pages.tnetpage.LoginPage;

import static com.codeborne.selenide.Condition.visible;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();

    @Step("Validate that login page is appear")
    public void validateLoginPageIsAppear() {
        loginPage.loginForm.shouldBe(visible);
    }
}
