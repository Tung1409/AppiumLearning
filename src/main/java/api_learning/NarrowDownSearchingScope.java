package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDownSearchingScope {

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

            int yStartPoint = 0;
            int yEndPoint = 50 * screenHeight / 100;

            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction<>(appiumDriver);
//            touchAction.press(startPoint)
//                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
            touchAction.longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            List<MobileElement> notificationsElem =
                    appiumDriver.findElements(MobileBy.id("android:id/status_bar_latest_event_content"));
            Map<String, String> notificationContents = new HashMap<>();
            for (MobileElement notificationElem : notificationsElem) {
                MobileElement titleElem = notificationElem.findElement(MobileBy.id("android:id/title"));
                MobileElement contentElem = notificationElem.findElement(MobileBy.id("android:id/text"));
                notificationContents.put(titleElem.getText().trim(), contentElem.getText().trim());
            }

            if (notificationContents.isEmpty()) {
                throw new RuntimeException("There is no notification");
            }

            for (String title : notificationContents.keySet()) {
                System.out.println("Title: " + title);
                System.out.println("Content: " + notificationContents.get(title));
            }


            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();

    }
}