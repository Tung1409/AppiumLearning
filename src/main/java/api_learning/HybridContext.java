package api_learning;

import context.Contexts;
import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HybridContext {

    // Hybrid context la 1 cai lai, no nhung' webview vao native context
    // de tuong tac tren webcontext: tu native sang webcontext va nguoc lai
    // cho nen dau tien minh phai xem coi co bao nhieu context

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            By webViewNavBtnSel = MobileBy.AccessibilityId("Webview");
            MobileElement webViewNavBtnElem = appiumDriver.findElement(webViewNavBtnSel);
            webViewNavBtnElem.click();

            // phai chờ cho no co nhieu context roi moi switch qua

            // Wait until we have more than one context
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(new WaitMoreThanOneContext(appiumDriver));

            for (String contextHandle : appiumDriver.getContextHandles()) {
                System.out.println(contextHandle);
            }

            // Switch to Webview
            appiumDriver.context(Contexts.WEB_VIEW);

            // Interact with Webview Element
            WebElement navToggleBtnElem = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnElem.click();

            List<MobileElement> menuItemElems = appiumDriver.findElementsByCssSelector(".menu__list li a");
            Map<String, String> menuItemDataMap = new HashMap<>();
            // co the thay the Map = List
            List<MenuItemData> menuItemDataList = new ArrayList<>();

            if (menuItemElems.isEmpty()){
                throw new RuntimeException("There is no list item");
            }
            for (MobileElement menuItemElem : menuItemElems) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");
                if (itemText.isEmpty()) {
                    menuItemDataMap.put("Image", itemHref);
                    menuItemDataList.add(new MenuItemData("Image", itemHref));
                } else {
                    menuItemDataMap.put(itemText, itemHref);
                    menuItemDataList.add(new MenuItemData(itemText, itemHref));
                }
            }

            // Verification
            for (String itemText : menuItemDataMap.keySet()) {
                System.out.println("Item Text: " + itemText);
                System.out.println("item Href: " + menuItemDataMap.get(itemText));
            }

            for (MenuItemData menuItemData : menuItemDataList) {
                System.out.println(menuItemData);
            }
            // Switch back to Native COntext
            appiumDriver.context(Contexts.NATIVE);

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

    public static class MenuItemData{
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }

        @Override
        public String toString() {
            return "MenuItemData{" +
                    "name='" + name + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
}
