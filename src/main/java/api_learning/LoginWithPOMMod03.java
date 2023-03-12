package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreenModel03;
import platform.Platform;

public class LoginWithPOMMod03 {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            MobileElement navigationLoginScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navigationLoginScreenBtn.click();

            LoginScreenModel03 loginScreen = new LoginScreenModel03(appiumDriver);
            loginScreen.inputUserName("teo@sth.com").inputPassword("12345678").clinkOnLoginBtn();
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
