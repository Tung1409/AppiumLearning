package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.pages.LoginScreen;
import platform.Platform;

public class SwipeTest {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);
        try {
            LoginScreen loginScreen = new LoginScreen(appiumDriver);
            BottomNavComponent bottomNavComp = loginScreen.bottomNavComp();
            bottomNavComp.clickOnSwipeIcon();
            SwipeController swipeController = new SwipeController(appiumDriver, 50, 10,
                    50, 50, 3);
            swipeController.swipeToDestination();
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
