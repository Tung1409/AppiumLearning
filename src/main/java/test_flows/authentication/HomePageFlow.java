package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import models.pages.HomePageScreen;
import org.testng.Assert;
import test_flows.BaseFlow;

public class HomePageFlow extends BaseFlow {
    public HomePageFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void verifyAppPurposeText() {
        HomePageScreen homePageScreen = new HomePageScreen(appiumDriver);
        String actualAppPurposeText = homePageScreen.getAppPurposeTex();
        System.out.println(actualAppPurposeText);
        String expectedAppPurposeText = "Demo app for the appium-boilerplate";
        Assert.assertEquals(actualAppPurposeText, expectedAppPurposeText, "[ERR] Actual app purpose is incorrect");
    }

    public void verifySupportText() {
        HomePageScreen homePageScreen = new HomePageScreen(appiumDriver);
        String actualSupportText = homePageScreen.getSupportText();
        System.out.println(actualSupportText);
        String expectedSupportText = "Support";
        Assert.assertEquals(actualSupportText, expectedSupportText, "[ERR] Actual support text is incorrect");
    }
}
