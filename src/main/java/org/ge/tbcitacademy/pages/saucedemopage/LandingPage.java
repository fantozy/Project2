package org.ge.tbcitacademy.pages.saucedemopage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LandingPage {
    public final ElementsCollection images = $$("img.inventory_item_img");
    public final SelenideElement
            burgerButton = $("#react-burger-menu-btn"),
            logoutButton = $("#logout_sidebar_link");
}
