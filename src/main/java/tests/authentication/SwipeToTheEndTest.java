package tests.authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import test_flows.authentication.SwipeVerticallyFlow;
import tests.BaseTest;

public class SwipeToTheEndTest extends BaseTest {

    @Description("Swipe_002")
    @Test
    public void swipeToTheEndTest(){
        SwipeVerticallyFlow swipeVerticallyFlow = new SwipeVerticallyFlow(getDriver());
        swipeVerticallyFlow.goToSwipeScreen();
        swipeVerticallyFlow.swipeToTheEnd();
    }
}
