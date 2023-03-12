package tests.swipe;

import api_learning.SwipeController;
import models.components.global.BottomNavComponent;
import models.pages.LoginScreen;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SwipeControllerTest extends BaseTest {

    @Test
    public void testSwipe(){
            LoginScreen loginScreen = new LoginScreen(getDriver());
            BottomNavComponent bottomNavComp = loginScreen.bottomNavComp();
            bottomNavComp.clickOnSwipeIcon();
            SwipeController swipeController = new SwipeController(getDriver(), 50, 10,
                    50, 50, 3);
            swipeController.swipeToDestination();
    }
}

