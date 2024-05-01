package org.ge.tbcitacademy.steps.facebooksteps;

import io.qameta.allure.Step;
import org.ge.tbcitacademy.pages.facebookpage.SharePage;

import static com.codeborne.selenide.Condition.text;
import static org.ge.tbcitacademy.data.Constants.Facebook_Constants.FACEBOOK;

public class SharePageSteps {
    SharePage sharePage = new SharePage();
    @Step("Validate that opened window is facebook")
    public void validateSharePageContainsFacebook() {
        sharePage.logo.shouldHave(text(FACEBOOK));
    }
}
