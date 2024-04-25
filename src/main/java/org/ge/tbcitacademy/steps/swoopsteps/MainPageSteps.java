package org.ge.tbcitacademy.steps.swoopsteps;

import org.ge.tbcitacademy.pages.swooppage.MainPage;

import io.qameta.allure.Step;

public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @Step("Go to Restaurant Section")
    public void goToRestSection() {
        mainPage.restSection.click();
    }

    @Step("Open Categories Menu")
    public MainPageSteps openCategoriesMenu() {
        System.out.println("Helouuuu rogor daisvenet aba moyevit");
        mainPage.categoriesButton.click();
        return this;
    }

    @Step("Hover on Food Category")
    public MainPageSteps hoverOnCategory() {
        mainPage.foodCategory.hover();
        return this;
    }

    @Step("Select Subcategory")
    public void selectSubCategory() {
        mainPage.subCategory.click();
    }
}
