package tests.authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import test_flows.authentication.SwipeHorizontallyFlow;
import tests.BaseTest;

public class SwipeHorizontallyAndVerifyTest extends BaseTest {

    @Description("Swipe_001")
    @Test
    public void swipeTest(){
        SwipeHorizontallyFlow swipeHorizontallyFlow = new SwipeHorizontallyFlow(getDriver());
        swipeHorizontallyFlow.goToSwipeScreen();
        swipeHorizontallyFlow.swipeHorizontallyAndVerifyContent();
    }
}
