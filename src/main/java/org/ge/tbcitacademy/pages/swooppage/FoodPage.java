package org.ge.tbcitacademy.pages.swooppage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.ge.tbcitacademy.data.Constants.Swoop_Constants.NOT_SOLD;

public class FoodPage extends MainPage {
    private final String voucherSelector = ".voucher-limit";

    public final ElementsCollection offers = $$(".special-offer");

    public final SelenideElement
            firstOffer = $("div.special-offer:nth-of-type(1)"),
            addToWishListButton = firstOffer.$(".deal-box-wishlist"),
            firstOfferVoucher = firstOffer.$(voucherSelector),
            offerNotSold = offers.filter(Condition.innerText(NOT_SOLD)).first(),
            offerNotSoldVoucher = offerNotSold.$(voucherSelector);
}

