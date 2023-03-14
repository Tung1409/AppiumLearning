package tests.authentication;

import org.testng.annotations.Test;
import test_flows.authentication.WebviewFlow;
import tests.BaseTest;

public class WebviewTest extends BaseTest {

    @Test
    public void webviewTest(){
        WebviewFlow webviewFlow = new WebviewFlow(getDriver());
        webviewFlow.goToWebView();
        webviewFlow.verifyMenuTextAndHyperLink();
    }
}
