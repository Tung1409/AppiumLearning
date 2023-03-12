package api_learning;

import driver.AppPackages;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import platform.Platform;

import java.time.Duration;

public class HandleMultipleApps {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            MobileElement navigationLoginScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navigationLoginScreenBtn.click();

            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            emailInputElem.sendKeys("teo@sth.com");
            passwordInputElem.sendKeys("12345678");
            loginBtnElem.click();

            // Put the app under test to background in a certain time | simulate pressing home button > relaunch
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            appiumDriver.activateApp(AppPackages.SETTING);

            By wifiLabelSel = MobileBy.xpath("//*[@text='Network & internet']");
            appiumDriver.findElement(wifiLabelSel).click();

            By wifiStatusSel = MobileBy.AccessibilityId("Wi‑Fi");
            MobileElement wifiStatusElem = appiumDriver.findElement(wifiStatusSel);
            Boolean isWifiOn = Boolean.parseBoolean(wifiStatusElem.getAttribute("checked"));

            if (isWifiOn){
                wifiStatusElem.click();
            }

            appiumDriver.activateApp(AppPackages.WEBDRIVER_IO);
            appiumDriver.findElement(MobileBy.id("android:id/button1")).click();

            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
