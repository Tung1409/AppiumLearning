package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import models.components.login.LoginFormComponent;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {

    private String username;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        super(appiumDriver);
        this.username = username;
        this.password = password;
    }

    public void login() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComp = loginScreen.loginFormComp();

        if (!username.isEmpty()) {
            loginFormComp.inputUserNameElem(username);
        }

        if (!password.isEmpty()) {
            loginFormComp.inputPasswordElem(password);
        }

        loginFormComp.clinkOnLoginBtn();
    }

    public void verifyLogin() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComp = loginScreen.loginFormComp();
        boolean isEmailValid = EmailValidator.getInstance().isValid(username);
        boolean isPasswordValid = password.length() >= 8;

        if (isEmailValid && isPasswordValid) {
            verifyCorrectLoginCreds(loginFormComp);
        }

        if (!isEmailValid) {
            verifyIncorrectEmail(loginFormComp);
        }

        if (!isPasswordValid) {
            verifyIncorrectPassword(loginFormComp);
        }
    }
    @Step("Verify with correct login cred")
    private void verifyCorrectLoginCreds(LoginFormComponent loginFormComp) {
        String actualValidLoginStr = loginFormComp.getValidLoginText();
        String expectedValidLoginStr = "Success";
        Assert.assertEquals(actualValidLoginStr, expectedValidLoginStr, "[ERR] actual valid login str is not correct");
    }

    @Step("Verify with incorrect email")
    private void verifyIncorrectEmail(LoginFormComponent loginFormComp) {
        String actualInvalidEmailStr = loginFormComp.getInvalidEmailText();
        String expectedInvalidEmailStr = "Please enter a valid email address";
        Assert.assertEquals(actualInvalidEmailStr, expectedInvalidEmailStr, "[ERR] actual invalid email str is not correct");
    }

    @Step("Verify with incorrect password")
    private void verifyIncorrectPassword(LoginFormComponent loginFormComp) {
        String actualInvalidPasswordStr = loginFormComp.getInvalidPasswordText();
        String expectedInvalidPasswordStr = "Please enter at least 8 characters";
        Assert.assertEquals(actualInvalidPasswordStr, expectedInvalidPasswordStr, "[ERR] actual invalid password str is not correct");
    }
}
