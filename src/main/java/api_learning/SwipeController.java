package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipeController {

    private final AppiumDriver<MobileElement> appiumDriver;
    private int xStartCoordinate;
    private int xEndCoordinate;
    private int yStartCoordinate;
    private int yEndCoordinate;
    private int swipeTime;

    public SwipeController(AppiumDriver<MobileElement> appiumDriver, int xStartCoordinate, int xEndCoordinate,
                           int yStartCoordinate, int yEndCoordinate, int swipeTime) {
        this.appiumDriver = appiumDriver;
        this.xStartCoordinate = xStartCoordinate;
        this.xEndCoordinate = xEndCoordinate;
        this.yStartCoordinate = yStartCoordinate;
        this.yEndCoordinate = yEndCoordinate;
        this.swipeTime = swipeTime;
    }

    public void swipeToDestination(){
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = xStartCoordinate * screenWidth / 100;
        int xEndPoint = xEndCoordinate * screenWidth / 100;

        int yStartPoint = yStartCoordinate * screenHeight / 100;
        int yEndPoint = yEndCoordinate * screenHeight / 100;

        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction<>(appiumDriver);
        for (int i = 0; i < swipeTime; i++) {
            touchAction.press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
        }
    }


}
