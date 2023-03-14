package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.components.screen.SwipeCardComponent;
import org.openqa.selenium.WebElement;

public class SwipeScreen {

    private final AppiumDriver<MobileElement> appiumDriver;

    public SwipeScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public SwipeCardComponent swipeCardComp(){
        return new SwipeCardComponent(appiumDriver);
    }

    public BottomNavComponent bottomNavComp(){
        return new BottomNavComponent(appiumDriver);
    }
}
