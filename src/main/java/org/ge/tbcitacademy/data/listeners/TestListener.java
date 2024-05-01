package org.ge.tbcitacademy.data.listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.screenshot;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try (InputStream is = Files.newInputStream(Path.of(Objects.requireNonNull(screenshot(OutputType.FILE)).getAbsolutePath()))){
            Allure.addAttachment("Screenshot on Failure", is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}