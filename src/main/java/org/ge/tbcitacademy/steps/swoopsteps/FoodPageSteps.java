package org.ge.tbcitacademy.steps.swoopsteps;

import org.ge.tbcitacademy.helper.HelperFunction;
import org.ge.tbcitacademy.pages.swooppage.FoodPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;

import static org.ge.tbcitacademy.data.Constants.Swoop_Constants.OFFER_SOLD;
import static org.ge.tbcitacademy.data.Constants.Swoop_Constants.VOUCHERS_NOT_SOLD;

public class FoodPageSteps {
    FoodPage foodPage = new FoodPage();

    @Step("Add to Wish List")
    public void addToWishList() {
        foodPage.addToWishListButton.click();
    }

    @Step("Check if Vouchers are Not Fully Sold")
    public FoodPageSteps checkVouchersNotSold(SoftAssert softAssert) {
        System.out.println("Hello world");
        String soldVoucherPercentage = foodPage.firstOfferVoucher.getAttribute("data-width");
        double parsedVoucherPercentage = HelperFunction.parseToDouble(soldVoucherPercentage);
        softAssert.assertTrue(parsedVoucherPercentage < 100.0, VOUCHERS_NOT_SOLD);
        return this;
    }

    @Step("Click on First Offer")
    public void clickToFirstOffer() {
        foodPage.firstOffer.click();
    }

    @Step("Validate Offer is Not Sold")
    public void validateNotSoldOffer() {
        String notSoldVoucherPercentage = foodPage.offerNotSoldVoucher.getAttribute("data-width");
        double parsedVoucherPercentage = HelperFunction.parseToDouble(notSoldVoucherPercentage);
        Assert.assertEquals(parsedVoucherPercentage, 0.00, OFFER_SOLD);
    }
}
