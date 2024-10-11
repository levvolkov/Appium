package ru.netology.calculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    @iOSXCUITFindBy(xpath = "XCUIElement...")
    public MobileElement btn2;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    @iOSXCUITFindBy(xpath = "XCUIElement...")
    public MobileElement btnPlus;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    @iOSXCUITFindBy(xpath = "XCUIElement...")
    public MobileElement btnRavno;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    @iOSXCUITFindBy(xpath = "XCUIElement...")
    public MobileElement result;

    private AppiumDriver driver;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}
