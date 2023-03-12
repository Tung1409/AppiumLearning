package tests.authentication;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import platform.Platform;
import test_data.DataObjectBuilder;
import test_data.models.LoginCred;
import test_flows.authentication.LoginFlow;
import tests.BaseTest;

public class LoginTestWithDataBuilder extends BaseTest {

    @Test(dataProvider = "loginCreds")
    public void testLogin(LoginCred loginCred) {
            LoginFlow loginFlow = new LoginFlow(getDriver(), loginCred.getEmail(), loginCred.getPassword());
            loginFlow.goToLoginScreen();
            loginFlow.login();
            loginFlow.verifyLogin();
    }


    @DataProvider
    private LoginCred[] loginCreds() {
        String fileLocation = "\\src\\main\\java\\test_data\\authentication\\LoginCreds.json";
        return DataObjectBuilder.builderDataObject(fileLocation, LoginCred[].class);
    }
}
