package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFormComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By userNameSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    private final static By validLoginSel = MobileBy.id("android:id/alertTitle");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    @Step("Input username as {usernameTxt}")
    public void inputUserNameElem(String usernameTxt) {
        if (!usernameTxt.isEmpty()) {
            MobileElement userNameElem = appiumDriver.findElement(userNameSel);
            userNameElem.clear();
            userNameElem.sendKeys(usernameTxt);
        }
    }

    @AndroidFindBy(xpath = "//*[contains(@text, 'Please enter a valid email address')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter a valid email address\"")
    private MobileElement incorrectEmailTextElem;

    public String getInvalidEmailText(){
         return incorrectEmailTextElem.getText().trim();
    }

    @Step("Input password as {passwordTxt}")
    public void inputPasswordElem(String passwordTxt) {
        if (!passwordTxt.isEmpty()) {
            MobileElement passwordElem = appiumDriver.findElement(passwordSel);
            passwordElem.clear();
            passwordElem.sendKeys(passwordTxt);
        }
    }

    @AndroidFindBy(xpath = "//*[contains(@text, 'Please enter at least 8 characters')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter at least 8 characters\"")
    private MobileElement incorrectPasswordTextElem;

    public String getInvalidPasswordText(){
        return incorrectPasswordTextElem.getText().trim();
    }

    @Step("Click on login button")
    public void clinkOnLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }

    public String getValidLoginText(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        return appiumDriver.findElement(validLoginSel).getText();
    }
}
