package org.ge.tbcitacademy.pages.swooppage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.ge.tbcitacademy.data.Constants.Swoop_Constants.*;

public class SideMenu {
    public final SelenideElement sidebar = $("#sidebar-container");
    public final ElementsCollection locations = sidebar.findAll(".ms-drop.bottom li");
    public final SelenideElement
            minPriceInput = sidebar.find("#minprice"),
            maxPriceInput = sidebar.find("#maxprice"),
            submitButton = sidebar.find(".submit-button"),
            locationMenu = sidebar.find(".icon-caret"),
            location = locations.filterBy(text(CITY)).first(),
            defaultPaymentMethodButton = sidebar.findAll(".location-label").filter(text(DEFAULT_PAYMENT_METHOD)).first(),
            paymentMethodButton = sidebar.findAll(".location-label").filterBy(text(PAYMENT_METHOD)).first(),
            trashButton = sidebar.find(".fa-trash");
}