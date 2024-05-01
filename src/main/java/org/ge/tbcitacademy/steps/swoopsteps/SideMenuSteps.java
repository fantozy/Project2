package org.ge.tbcitacademy.steps.swoopsteps;

import com.codeborne.selenide.SelenideElement;
import org.ge.tbcitacademy.pages.swooppage.SideMenu;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.empty;

public class SideMenuSteps {
    SideMenu sideMenuPage = new SideMenu();

    @Step("Set min price range: {minPrice}")
    public SideMenuSteps setMinPriceRange(String minPrice) {
        sideMenuPage.minPriceInput.sendKeys(minPrice);
        return this;
    }
    @Step("Set max price range: {maxPrice} ")
    public SideMenuSteps setMaxPriceRange(String maxPrice) {
        sideMenuPage.maxPriceInput.sendKeys(maxPrice);
        return this;
    }
    public SideMenuSteps clickFilterButton() {
        sideMenuPage.submitButton.click();
        return this;
    }
    @Step("Scroll to Location Menu")
    public SideMenuSteps scrollToLocationMenu() {
        sideMenuPage.locationMenu.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        return this;
    }

    @Step("Click to Location Button")
    public SideMenuSteps clickToLocationButton() {
        sideMenuPage.locationMenu.click();
        return this;
    }

    @Step("Choose Location")
    public SideMenuSteps chooseLocation() {
        sideMenuPage.location.click();
        return this;
    }

    @Step("Select Payment Method")
    public SideMenuSteps selectPaymentMethod() {
        sideMenuPage.paymentMethodButton.click();
        return this;
    }

    @Step("Remove Filter")
    public SideMenuSteps removeFilter() {
        sideMenuPage.trashButton.click();
        return this;
    }

    @Step("Validate Location is Default")
    public SideMenuSteps validateLocationIsDefault(SoftAssert softAssert) {
        for (SelenideElement li : sideMenuPage.locations) {
            softAssert.assertFalse(li.getCssValue("class").contains("selected"));
        }
        return this;
    }

    @Step("Validate Price Range is Default")
    public SideMenuSteps validatePriceRangeIsDefault() {
        sideMenuPage.minPriceInput.shouldBe(empty);
        sideMenuPage.maxPriceInput.shouldBe(empty);
        return this;
    }

    @Step("Validate Payment Method is Default")
    public void validatePaymentMethodIsDefault(SoftAssert softAssert) {
        softAssert.assertTrue(sideMenuPage.defaultPaymentMethodButton.isEnabled());
    }
}
