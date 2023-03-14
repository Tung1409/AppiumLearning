package tests.authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import test_flows.authentication.HomePageFlow;
import tests.BaseTest;

public class AppPurposeAndSupportDisplayTest extends BaseTest {

    @Description("HomePage_001, HomePage_002")
    @Test
    public void testAppPurposeDisplay(){
        HomePageFlow homePageFlow = new HomePageFlow(getDriver());
        homePageFlow.verifyAppPurposeText();
        homePageFlow.verifySupportText();
    }
}
