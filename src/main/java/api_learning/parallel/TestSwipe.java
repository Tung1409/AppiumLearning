package api_learning.parallel;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Description;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class TestSwipe extends BaseTest {

    @Description("Swipe to right then back to left")
    @Test(description = "Swipe test")
    public void testSwipe() {
        MobileElement navigationSwipeScreenBtn = getDriver().findElement(MobileBy.AccessibilityId("Swipe"));
        navigationSwipeScreenBtn.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(
                "new UiSelector().textContains(\"Swipe horizontal\")")));

        // Get mobile window size
        Dimension windowSize = getDriver().manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        // Calculate touch point
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        // Convert coordinates -> point option
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        // Swipe up
        TouchAction touchAction = new TouchAction<>(getDriver());
        for (int i = 0; i < 5; i++) {
            touchAction.press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
        }

        for (int i = 0; i < 5; i++) {
            touchAction.longPress(endPoint)
                    .moveTo(startPoint)
                    .release()
                    .perform();
        }
    }

}
