package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenModel01;
import platform.Platform;

public class LoginWithPOMMod01 {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            MobileElement navigationLoginScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navigationLoginScreenBtn.click();

            LoginScreenModel01 loginScreen = new LoginScreenModel01(appiumDriver);
            loginScreen.userNameElem().sendKeys("teo@sth.com");
            loginScreen.passwordElem().sendKeys("12345678");
            loginScreen.loginBtnElem().click();
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
