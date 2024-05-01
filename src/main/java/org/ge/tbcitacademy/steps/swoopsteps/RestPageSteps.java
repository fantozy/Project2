package org.ge.tbcitacademy.steps.swoopsteps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.ge.tbcitacademy.helper.HelperFunction;
import org.ge.tbcitacademy.pages.swooppage.RestPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import io.qameta.allure.Step;

import static org.ge.tbcitacademy.data.Constants.Swoop_Constants.PRICE_OUT_OF_RANGE;

public class RestPageSteps {
    RestPage restPage = new RestPage();

    @Step("Wait Until Changes")
    public RestPageSteps waitUntilChanges() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(10));
        wait.until(driver -> !driver.getCurrentUrl().equals(currentUrl));
        return this;
    }

    @Step("Check Price in Range")
    public void checkPriceInRange(String minPrice, String maxPrice, SoftAssert softAssert) {
        for (SelenideElement offerPrice : restPage.offersPrice) {
            double price = HelperFunction.parseToDouble(offerPrice.text());
            double minRangePrice = HelperFunction.parseToDouble(minPrice);
            double maxRangePrice = HelperFunction.parseToDouble(maxPrice);
            String message = String.format(PRICE_OUT_OF_RANGE, minRangePrice, maxRangePrice, price);
            softAssert.assertTrue(price >= minRangePrice && price <= maxRangePrice, message);
        }
    }
}
