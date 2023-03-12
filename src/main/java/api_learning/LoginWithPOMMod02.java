package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenModel02;
import platform.Platform;

public class LoginWithPOMMod02 {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            MobileElement navigationLoginScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navigationLoginScreenBtn.click();

            LoginScreenModel02 loginScreen = new LoginScreenModel02(appiumDriver);
            loginScreen.inputUserNameElem("teo@sth.com");
            loginScreen.inputPasswordElem("12345678");
            loginScreen.clinkOnLoginBtn();
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
