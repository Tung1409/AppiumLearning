package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import platform.Platform;

import java.util.List;

public class XpathLearning {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            MobileElement navigationLoginScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navigationLoginScreenBtn.click();

            List<MobileElement> credFieldsElem = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            credFieldsElem.get(USERNAME_INDEX).sendKeys("teo@sth.com");
            credFieldsElem.get(PASSWORD_INDEX).sendKeys("12345678");

            // Find login info text By UISelector
            MobileElement loginInstructorElem =
                    appiumDriver.findElement(MobileBy.AndroidUIAutomator(
                            "new UiSelector().textContains(\"When the device\")"));
            System.out.println(loginInstructorElem.getText());


            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();

    }
}
