package org.ge.tbcitacademy.data.config;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Configuration.*;


import java.util.HashMap;
import java.util.Map;


public class TestConfiguration {
    public SoftAssert softAssert;
    @BeforeClass(alwaysRun = true)
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> passManagerSettings = new HashMap<>();
        options.addArguments("start-maximized");
        passManagerSettings.put("credentials_enable_service", false);
        passManagerSettings.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", passManagerSettings);
        browserCapabilities = options;
        browserSize = null;
        timeout=5000;
    }

    @BeforeMethod(alwaysRun = true)
    public void createSoftAssert() {
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        Selenide.closeWebDriver();
    }
}
