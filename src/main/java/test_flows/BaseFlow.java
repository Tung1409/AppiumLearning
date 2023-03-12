package test_flows;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import models.pages.LoginScreen;

public class BaseFlow {

    protected AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Go to login screen")
    public void goToLoginScreen(){
        new LoginScreen(appiumDriver).bottomNavComp().clickOnLoginIcon();
    }
}
