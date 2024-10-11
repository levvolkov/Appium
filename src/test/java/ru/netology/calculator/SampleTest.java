package ru.netology.calculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    enum Platform {Android, IOS}

    Platform platform = Platform.Android; // Используется структура Android если нужно именяем под IOS: Platform platform = Platform.IOS;

    private AppiumDriver driver;
    private MobileObjects mobileObjects;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // Базовые настройки
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        if (platform == Platform.Android) {
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("appium:deviceName", "Some name");
            desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
            desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            driver = new AndroidDriver(getUrl(), desiredCapabilities);
        } else if (platform == Platform.IOS) {
            desiredCapabilities.setCapability("platformName", "IOS");
            desiredCapabilities.setCapability("appium:deviceName", "iPhone 11");
            desiredCapabilities.setCapability("appium:bundleId", "com.Shubhum-iosdev.Calculator-UI");
            desiredCapabilities.setCapability("appium:automationName", "XCUITest");
            driver = new IOSDriver(getUrl(), desiredCapabilities);
        }
        mobileObjects = new MobileObjects(driver);
    }

    @Test
    public void sampleTest() {
        mobileObjects.btn2.isDisplayed();
        mobileObjects.btn2.click();

        mobileObjects.btnPlus.isDisplayed();
        mobileObjects.btnPlus.click();

        mobileObjects.btn2.isDisplayed();
        mobileObjects.btn2.click();

        mobileObjects.btnRavno.isDisplayed();
        mobileObjects.btnRavno.click();

        mobileObjects.result.isDisplayed();
        Assertions.assertEquals("4", mobileObjects.result.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
