package org.ge.tbcitacademy.swoop;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ge.tbcitacademy.data.config.TestConfiguration;
import org.ge.tbcitacademy.data.listeners.TestListener;
import org.ge.tbcitacademy.data.priceDataProvider;
import org.ge.tbcitacademy.steps.tnetsteps.LoginPageSteps;
import org.ge.tbcitacademy.steps.facebooksteps.SharePageSteps;
import org.ge.tbcitacademy.steps.swoopsteps.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.ge.tbcitacademy.data.Constants.Swoop_Constants.*;

@Test(groups = {"SwoopRegression"})
@Listeners({TestListener.class})
@Epic("Swoop offers management")
public class OffersTest extends TestConfiguration {

    RestPageSteps restPageSteps = new RestPageSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    FoodPageSteps foodPageSteps = new FoodPageSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    OfferPageSteps offerPageSteps = new OfferPageSteps();
    SharePageSteps sharePageSteps = new SharePageSteps();
    SideMenuSteps sideMenuSteps = new SideMenuSteps();

    @BeforeMethod
    public void setup() {
        open(SWOOP_URL);
    }

    @Test(dataProvider = "priceData", dataProviderClass = priceDataProvider.class)
    @Description("Verify that the prices of offers are within the specified range")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Price Filtering")
    @Story("User filters offers by price range")
    public void rangeTest(String minPrice, String maxPrice) {
        mainPageSteps.goToRestSection();
        sideMenuSteps
                .setMinPriceRange(minPrice)
                .setMaxPriceRange(maxPrice)
                .clickFilterButton();
        restPageSteps
                .waitUntilChanges()
                .checkPriceInRange(minPrice, maxPrice, softAssert);
        softAssert.assertAll();
    }


    @Test
    @Description("Verify that a user can add a favorite offer")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Favorite Offers")
    @Story("User adds an offer to favorites")
    public void favouriteOfferTest() {
        mainPageSteps
                .openCategoriesMenu()
                .hoverOnCategory()
                .selectSubCategory();
        foodPageSteps
                .checkVouchersNotSold(softAssert)
                .addToWishList();
        loginPageSteps.validateLoginPageIsAppear();
        softAssert.assertAll();
    }

    @Test
    @Description("Verify that a user can share an offer")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Offer Sharing")
    @Story("User shares an offer on social media")
    public void shareOfferTest() {
        mainPageSteps
                .openCategoriesMenu()
                .hoverOnCategory()
                .selectSubCategory();
        foodPageSteps.clickToFirstOffer();
        offerPageSteps
                .clickToShare()
                .switchWindow();
        sharePageSteps.validateSharePageContainsFacebook();
    }

    @Test
    @Description("Verify that there are no offers sold")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Offer Availability")
    @Story("User checks for unsold offers")
    public void noOffersSoldTest() {
        mainPageSteps
                .openCategoriesMenu()
                .hoverOnCategory()
                .selectSubCategory();
        foodPageSteps.validateNotSoldOffer();
    }



    @Test
    @Description("Verify that the filter settings are reset")
    @Severity(SeverityLevel.MINOR)
    @Feature("Filter Management")
    @Story("User clears applied filters")
    public void clearFilterTest() {
        mainPageSteps
                .openCategoriesMenu()
                .hoverOnCategory()
                .selectSubCategory();
        sideMenuSteps
                .scrollToLocationMenu()
                .clickToLocationButton()
                .chooseLocation()
                .clickToLocationButton()
                .selectPaymentMethod()
                .setMinPriceRange(MIN_PRICE_RANGE)
                .setMaxPriceRange(MAX_PRICE_RANGE)
                .clickFilterButton()
                .removeFilter()
                .scrollToLocationMenu()
                .validateLocationIsDefault(softAssert)
                .validatePriceRangeIsDefault()
                .validatePaymentMethodIsDefault(softAssert);
        softAssert.assertAll();
        System.out.println("Helouuuu rogor daisvenet aba moyevit");
    }
}
