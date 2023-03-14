package test_flows.authentication;

import context.Contexts;
import context.WaitMoreThanOneContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test_data.models.WebviewMenuItem;
import test_flows.BaseFlow;

import java.util.ArrayList;
import java.util.List;

public class WebviewFlow extends BaseFlow {
    public WebviewFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void verifyMenuTextAndHyperLink() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
        wait.until(new WaitMoreThanOneContext(appiumDriver));

        appiumDriver.context(Contexts.WEB_VIEW);

        appiumDriver.findElement(By.cssSelector(".navbar__toggle.clean-btn")).click();
        List<WebviewMenuItem> actualMenuItem = new ArrayList<>();

        List<MobileElement> menuItemElems = appiumDriver.findElements(By.cssSelector(".menu__list li a"));
        if (menuItemElems.isEmpty()) {
            Assert.fail("There is no item on menu");
        }
        for (MobileElement menuItemElem : menuItemElems) {
            if (menuItemElem.getText().isEmpty()) {
                actualMenuItem.add(new WebviewMenuItem("Image", menuItemElem.getAttribute("href")));

            } else {
                actualMenuItem.add(new WebviewMenuItem(menuItemElem.getText(), menuItemElem.getAttribute("href")));
            }
        }

        List<WebviewMenuItem> expectedMenuItem = new ArrayList<>();
        expectedMenuItem.add(new WebviewMenuItem("Docs", "/docs/gettingstarted"));
        expectedMenuItem.add(new WebviewMenuItem("API", "/docs/api"));
        expectedMenuItem.add(new WebviewMenuItem("Blog", "/blog"));
        expectedMenuItem.add(new WebviewMenuItem("Contribute", "/docs/contribute"));
        expectedMenuItem.add(new WebviewMenuItem("Community", "/community/support"));
        expectedMenuItem.add(new WebviewMenuItem("v8", "/versions"));
        expectedMenuItem.add(new WebviewMenuItem("Image", "https://github.com/webdriverio/webdriverio"));
        expectedMenuItem.add(new WebviewMenuItem("Image", "https://twitter.com/webdriverio"));

        for (int index = 0; index < actualMenuItem.size(); index++) {
            Assert.assertEquals(actualMenuItem.get(index).getText(), expectedMenuItem.get(index).getText(),
                    "[ERR] Display wrong menu item text ");
            System.out.println(actualMenuItem.get(index).getText());
            System.out.println(expectedMenuItem.get(index).getText());

            Assert.assertEquals(actualMenuItem.get(index).getHref(), expectedMenuItem.get(index).getHref(),
                    "[ERR] Display wrong menu item href");
            System.out.println(actualMenuItem.get(index).getHref());
            System.out.println(expectedMenuItem.get(index).getHref());
        }
    }
}
