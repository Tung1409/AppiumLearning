package test_flows;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import models.components.global.BottomNavComponent;
import models.pages.FormScreen;
import models.pages.LoginScreen;

public class BaseFlow {

    protected AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToWebView(){
        new BottomNavComponent(appiumDriver).clickOnWebviewIcon();
    }
    @Step("Go to login screen")
    public void goToLoginScreen(){
        new LoginScreen(appiumDriver).bottomNavComp().clickOnLoginIcon();
    }

    public void goToFormScreen(){
        new BottomNavComponent(appiumDriver).clickOnFormIcon();
    }

    public void goToSwipeScreen(){
        new BottomNavComponent(appiumDriver).clickOnSwipeIcon();
    }


    //TODO uninstall Appiumsetting roi cai dat lai
}
