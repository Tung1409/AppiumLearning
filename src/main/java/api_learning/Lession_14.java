package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Lession_14 {

    public static void main(String[] args) {
        // Send a request into Appium sever > ask to launch the app

        AppiumDriver<MobileElement> appiumDriver = null;

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity t13");

        try {
            URL appiumSever = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AndroidDriver<MobileElement>(appiumSever, desiredCapabilities);

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (appiumDriver != null) appiumDriver.quit();
    }
}
