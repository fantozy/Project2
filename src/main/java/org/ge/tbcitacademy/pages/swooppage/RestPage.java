package org.ge.tbcitacademy.pages.swooppage;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class RestPage extends MainPage {
    public final ElementsCollection offersPrice = $$("div.special-offer .outs-and-shorts .deal-voucher-price").filterBy(visible);
}
