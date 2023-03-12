package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginScreenModel02 {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By userNameSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");


    public LoginScreenModel02(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void  inputUserNameElem(String usernameTxt){
        if (usernameTxt.isEmpty()) appiumDriver.findElement(userNameSel).sendKeys(usernameTxt);
    }

    public void  inputPasswordElem(String passwordTxt){
        if (passwordTxt.isEmpty()) appiumDriver.findElement(passwordSel).sendKeys(passwordTxt);
    }

    public void clinkOnLoginBtn(){
        appiumDriver.findElement(loginBtnSel).click();
    }
}
