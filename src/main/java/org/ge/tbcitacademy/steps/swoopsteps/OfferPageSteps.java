package org.ge.tbcitacademy.steps.swoopsteps;

import org.ge.tbcitacademy.pages.swooppage.OfferPage;

import static com.codeborne.selenide.Selenide.switchTo;

import io.qameta.allure.Step;

public class OfferPageSteps {
    OfferPage offersPage = new OfferPage();

    @Step("Click on Share Button")
    public OfferPageSteps clickToShare() {
        offersPage.shareButton.click();
        return this;
    }

    @Step("Switch to another browser Window")
    public void switchWindow() {
        switchTo().window(1);
    }
}
