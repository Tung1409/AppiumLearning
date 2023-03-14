package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.components.screen.LoginFormComponent;
import models.pages.LoginScreen;
import platform.Platform;

public class LoginWithComponent {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            LoginScreen loginScreen = new LoginScreen(appiumDriver);
            LoginFormComponent loginFormComp = loginScreen.loginFormComp();
            BottomNavComponent bottomNavComponent = loginScreen.bottomNavComp();

            bottomNavComponent.clickOnLoginIcon();
            loginFormComp.inputUserNameElem("teo@sth.com");
            loginFormComp.inputPasswordElem("12345678");
            loginFormComp.clinkOnLoginBtn();

        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
