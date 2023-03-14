package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import models.components.screen.SwipeCardComponent;
import models.pages.SwipeScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_flows.BaseFlow;

import java.time.Duration;

public class SwipeVerticallyFlow extends BaseFlow {
    public SwipeVerticallyFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void swipeToTheEnd(){
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        By webdriverIoLogoSel = MobileBy.AccessibilityId("WebdriverIO logo");
        By foundTextSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"You found me!!!\")");

        for (int i = 0; i < 10; i++) {
            TouchAction touchAction = new TouchAction<>(appiumDriver);
            touchAction.press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
            WebDriverWait wait = new WebDriverWait(appiumDriver, 3L);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(webdriverIoLogoSel));
                String foundString = appiumDriver.findElement(foundTextSel).getText().trim();
                System.out.println(foundString);
                break;
            } catch (Exception ignored){}
        }

    }
}
