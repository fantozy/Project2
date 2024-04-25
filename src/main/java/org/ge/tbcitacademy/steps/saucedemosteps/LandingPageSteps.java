package org.ge.tbcitacademy.steps.saucedemosteps;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.ge.tbcitacademy.pages.saucedemopage.LandingPage;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.ge.tbcitacademy.data.Constants.SauceDemo_Constants.*;


public class LandingPageSteps {
    LandingPage landingPage = new LandingPage();

    @Step("Validate that all images loaded")
    public LandingPageSteps validateImages(SoftAssert softAssert) {
        for (SelenideElement image : landingPage.images) {
            softAssert.assertTrue(image.isImage());
            softAssert.assertTrue(image.exists(), NOT_EXIST);
            softAssert.assertTrue(image.isDisplayed(), NOT_DISPLAYED);
        }
        return this;
    }

    @Step("Open burger menu")
    public LandingPageSteps openBurgerMenu() {
        landingPage.burgerButton.click(ClickOptions.usingJavaScript());
        return this;
    }

    @Step("Logout")
    public LandingPageSteps logout() {
        landingPage.logoutButton.click(ClickOptions.usingJavaScript());
        return this;
    }

    @Step("Validate that all images unique")
    public void validateImagesUnique(SoftAssert softAssert) {
        Map<String, Integer> imageSrcCountMap = new HashMap<>();

        for (SelenideElement image : landingPage.images) {
            String src = image.getAttribute("src");
            imageSrcCountMap.put(src, imageSrcCountMap.getOrDefault(src, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : imageSrcCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                softAssert.fail("Image with src '" + entry.getKey() + "' is not unique. " + entry.getValue() + " Images duplicated ");
            }
        }
    }
}
