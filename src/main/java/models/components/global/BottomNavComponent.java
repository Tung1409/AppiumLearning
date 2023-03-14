package models.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BottomNavComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By webViewIconSel = MobileBy.AccessibilityId("Webview");
    private final static By loginIconSel = MobileBy.AccessibilityId("Login");
    private final static By formIconSel = MobileBy.AccessibilityId("Forms");
    private final static By swipeIconSel = MobileBy.AccessibilityId("Swipe");

    public BottomNavComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickOnWebviewIcon(){
        appiumDriver.findElement(webViewIconSel).click();WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(
                "new UiSelector().textContains(\"Next-gen browser\")")));
    }

    public void clickOnLoginIcon(){
        appiumDriver.findElement(loginIconSel).click();
    }

    public void clickOnFormIcon(){
        appiumDriver.findElement(formIconSel).click();
    }

    public void clickOnSwipeIcon(){
        appiumDriver.findElement(swipeIconSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(
                "new UiSelector().textContains(\"Swipe horizontal\")")));
    }

}
