package org.ge.tbcitacademy.pages.swooppage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public final SelenideElement cinemaSection = $("div.Menus a[href='events']"),
            restSection = $("div.Menus a[href='/category/24/dasveneba']"),
            categoriesButton = $(".NewCategories.newcat"),
            foodCategory = $x("(//a[normalize-space(text())='კვება'])[1]"),
            subCategory = $x("//a[normalize-space(text())='კაფე, ბარი']");
}
