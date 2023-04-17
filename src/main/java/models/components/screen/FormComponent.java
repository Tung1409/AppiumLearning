package models.components.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final By inputFieldSel = MobileBy.AccessibilityId("text-input");
    private final By inputTextResultSel = MobileBy.AccessibilityId("input-text-result");
    private final By switchSel = MobileBy.AccessibilityId("switch");
    private final By switchTextSel = MobileBy.AccessibilityId("switch-text");
    private final By dropdownIcon = MobileBy.AccessibilityId("Dropdown");

    private final By webdriverioOptionSel = MobileBy.AndroidUIAutomator(
            "new UiSelector().textContains(\"webdriver.io is awesome\")");
    private final By appiumOptionSel = MobileBy.AndroidUIAutomator(
            "new UiSelector().textContains(\"Appium is awesome\")");
    private final By thisAppioOptionSel = MobileBy.AndroidUIAutomator(
            "new UiSelector().textContains(\"This app is awesome\")");
    private final By buttonActiveSel = MobileBy.AccessibilityId("button-Active");
    private final By alertSessionSel = MobileBy.id("android:id/alertTitle");
    private final By okButtonAlertSessionSel = MobileBy.id("android:id/button1");
    private final By buttonInactiveSel = MobileBy.AccessibilityId("button-Inactive");
    public FormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;

    }

    public void sendKeyToInputField(String inputText){
        MobileElement inputFieldElem = appiumDriver.findElement(inputFieldSel);
        inputFieldElem.sendKeys(inputText);
    }

    public String getInputText(){
        return appiumDriver.findElement(inputFieldSel).getText().trim();
    }
    public String getInputResultText(){
        return appiumDriver.findElement(inputTextResultSel).getText().trim();
    }

    public void clickOnSwitch(){
        appiumDriver.findElement(switchSel).click();
    }

    public String getSwitchStatus(){
        return appiumDriver.findElement(switchSel).getText();
    }

    public String getSwitchText(){
        return appiumDriver.findElement(switchTextSel).getText().trim();
    }

    public void clickOnDropdownIcon(){
        appiumDriver.findElement(dropdownIcon).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(webdriverioOptionSel));
    }

    public void selectWebdriverIoOption(){
        appiumDriver.findElement(webdriverioOptionSel).click();
    }

    public void selectAppiumOption(){
        appiumDriver.findElement(appiumOptionSel).click();
    }

    public void selectThisAppOption(){
        appiumDriver.findElement(thisAppioOptionSel).click();
    }

    public void clickOnActiveButton(){
        appiumDriver.findElement(buttonActiveSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertSessionSel));
    }

    public void closeAlertSession(){
        appiumDriver.findElement(okButtonAlertSessionSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(alertSessionSel));
    }

    public void clickOnInactiveButton(){
        appiumDriver.findElement(buttonInactiveSel).click();
    }
}
