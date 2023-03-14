package models.components.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SwipeCardComponent {
    private final static By titleSel = MobileBy.xpath(
            "(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[2]/android.widget.TextView[1]");

    private final static By contentSel = MobileBy.xpath(
            "(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[2]/android.widget.TextView[2]");

    private final AppiumDriver<MobileElement> appiumDriver;

    public SwipeCardComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public String getTitleText(){
        return appiumDriver.findElement(titleSel).getText().trim();
    }

    public String getContentText(){
        return appiumDriver.findElement(contentSel).getText().trim();
    }

}
