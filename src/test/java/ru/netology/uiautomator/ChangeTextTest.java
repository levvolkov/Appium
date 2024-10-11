package ru.netology.uiautomator;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ChangeTextTest {

    private AndroidDriver driver;
    private Locators locators;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private final String textToSet = "Netology";
    private final String emptyString = " ";

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "myAndroid");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), desiredCapabilities);

        locators = new Locators(driver);
    }

    @Test
    public void EmptyInput() {
        locators.userInput.sendKeys(textToSet);
        locators.buttonChange.click();
        locators.textToBeChanged.isDisplayed();
        locators.userInput.sendKeys(emptyString);
        locators.buttonChange.click();
        locators.textToBeChanged.isDisplayed();
        Assertions.assertEquals(textToSet, locators.textToBeChanged.getText());
    }

    @Test
    public void NewActivity() {
        locators.userInput.sendKeys(textToSet);
        locators.buttonActivity.click();
        locators.text.isDisplayed();
        Assertions.assertEquals(textToSet, locators.text.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

