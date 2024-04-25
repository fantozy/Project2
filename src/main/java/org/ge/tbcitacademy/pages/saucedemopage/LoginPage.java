package org.ge.tbcitacademy.pages.saucedemopage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    public final SelenideElement
            loginInput = $("#user-name"),
            passwordInput = $("#password"),
            loginButton = $("#login-button"),
            errorMessage = $("h3[data-test='error']"),
            errorButton = $(".error-button");
    public final ElementsCollection errorIcons = $$(".error_icon");
}
