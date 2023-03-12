package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginScreenModel03 {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By userNameSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");


    public LoginScreenModel03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginScreenModel03 inputUserName(String usernameTxt){
        if (!usernameTxt.isEmpty()) appiumDriver.findElement(userNameSel).sendKeys(usernameTxt);
        return this;
    }

    public LoginScreenModel03 inputPassword(String passwordTxt){
        if (!passwordTxt.isEmpty()) appiumDriver.findElement(passwordSel).sendKeys(passwordTxt);
        return this;
    }

    public void clinkOnLoginBtn(){
        appiumDriver.findElement(loginBtnSel).click();
    }
}
