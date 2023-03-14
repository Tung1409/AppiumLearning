package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomePageScreen {

    private static final By appPurposeTextSel = MobileBy.AndroidUIAutomator(
            "new UiSelector().textContains(\"Demo app for\")");
    private static final By supportTextSel = MobileBy.AndroidUIAutomator(
            "new UiSelector().textContains(\"Support\")");
    private final AppiumDriver<MobileElement> appiumDriver;

    public HomePageScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public String getAppPurposeTex(){
        return appiumDriver.findElement(appPurposeTextSel).getText().trim();
    }

    public String getSupportText(){
        return appiumDriver.findElement(supportTextSel).getText().trim();
    }
}
