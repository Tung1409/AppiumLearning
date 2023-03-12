package api_learning.parallel;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.models.LoginCred;
import test_flows.authentication.LoginFlow;
import tests.BaseTest;

public class LoginDevice01 extends BaseTest {

    @Description("Login with data driven")
    @Test(dataProvider = "loginCreds", description = "Login test")
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
