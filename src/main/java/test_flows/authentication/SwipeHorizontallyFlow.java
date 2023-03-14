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
import org.testng.Assert;
import test_data.models.TitleAndDescription;
import test_flows.BaseFlow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SwipeHorizontallyFlow extends BaseFlow {

    private final static By firstTitleSel = MobileBy.xpath(
            "(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[1]/android.widget.TextView[1]");
    private final static By firstDescriptionSel = MobileBy.xpath(
            "(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[1]/android.widget.TextView[2]");
    public SwipeHorizontallyFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void swipeHorizontallyAndVerifyContent() {
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        SwipeScreen swipeScreen = new SwipeScreen(appiumDriver);
        SwipeCardComponent swipeCardComp = swipeScreen.swipeCardComp();

        List<TitleAndDescription> expectedContent = new ArrayList<>();
        expectedContent.add(new TitleAndDescription("FULLY OPEN SOURCE", "WebdriverIO is fully open source and can be found on GitHub"));
        expectedContent.add(new TitleAndDescription("GREAT COMMUNITY", "WebdriverIO has a great community that supports all members."));
        expectedContent.add(new TitleAndDescription("JS.FOUNDATION","The JS Foundation is host to projects that span the entire JavaScript ecosystem."));
        expectedContent.add(new TitleAndDescription("SUPPORT VIDEOS", "The community around WebdriverIO is actively speaking on various user groups or conferences about specific topics around automated testing with WebdriverIO."));
        expectedContent.add(new TitleAndDescription("EXTENDABLE", "Adding helper functions, or more complicated sets and combinations of existing commands is simple and really useful"));
        expectedContent.add(new TitleAndDescription("COMPATIBLE", "WebdriverIO works in combination with most of the TDD and BDD test frameworks in the JavaScript world"));

//        Map<String, String> actualContent = new HashMap<>(6);
        List<TitleAndDescription> actualContent = new ArrayList<>();
        String firstTitleText = appiumDriver.findElement(firstTitleSel).getText().trim();
        String firstDescriptionText = appiumDriver.findElement(firstDescriptionSel).getText().trim();
        actualContent.add(new TitleAndDescription(firstTitleText, firstDescriptionText));


        // thu short press
        TouchAction touchAction = new TouchAction<>(appiumDriver);
        for (int i = 0; i < 5; i++) {
            touchAction.press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
            String actualTitle = swipeCardComp.getTitleText().trim();
            String actualDescription = swipeCardComp.getContentText().trim();
            actualContent.add(new TitleAndDescription(actualTitle, actualDescription));
            }

        for (int index = 0; index < 6; index++) {
            Assert.assertEquals(actualContent.get(index).getTitle(), expectedContent.get(index).getTitle(), "[ERR] Wrong title display");
            Assert.assertEquals(actualContent.get(index).getDescription(), expectedContent.get(index).getDescription(), "[ERR] Wrong description display");
        }
        }
    }
