package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.time.Duration;

public class SwipeVertically {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            MobileElement navigationFormScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navigationFormScreenBtn.click();
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(
                    "new UiSelector().textContains(\"Form components\")")));

            // Get mobile window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate touch point
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;


            // Convert coordinates -> point option
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            // Swipe up
            TouchAction touchAction = new TouchAction<>(appiumDriver);
            touchAction.press(startPoint)
                    // khi dung press thi minh phai wait
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();

            // Swipe down
            // xai Longpress thi khong can wait
            touchAction.longPress(endPoint)
                    .moveTo(startPoint)
                    .release()
                    .perform();

//
//            MobileElement activeBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));
//            activeBtnElem.click();

            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();

    }
}
