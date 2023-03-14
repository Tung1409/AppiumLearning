package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.screen.FormComponent;
import models.pages.FormScreen;
import org.testng.Assert;
import test_data.DropDownOption;
import test_flows.BaseFlow;

public class FormFlow extends BaseFlow {
    public FormFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void inputText(String text){
        FormScreen formScreen = new FormScreen(appiumDriver);
        formScreen.formComp().sendKeyToInputField(text);
    }

    public void verifyInputText(){
        FormScreen formScreen = new FormScreen(appiumDriver);
        String actualInputTextDisplayed = formScreen.formComp().getInputText();
        String expectedInputTextDisplayed = formScreen.formComp().getInputResultText();
        Assert.assertEquals(actualInputTextDisplayed, expectedInputTextDisplayed, "[ERR] Wrong text displayed");
        System.out.println(actualInputTextDisplayed);
        System.out.println(expectedInputTextDisplayed);
    }

    public void clickAndVerifySwitchStatus(){
        FormScreen formScreen = new FormScreen(appiumDriver);
        FormComponent formComp = formScreen.formComp();
        formComp.clickOnSwitch();
        String switchStatus = formComp.getSwitchStatus();
        String actualSwitchText = formComp.getSwitchText();
        if (switchStatus.equals("ON")){
            String expectedSwitchText = "Click to turn the switch OFF";
            Assert.assertEquals(actualSwitchText, expectedSwitchText, "[ERR] Display wrong switch status");
        }

        if (switchStatus.equals("OFF")){
            String expectedSwitchText = "Click to turn the switch ON";
            Assert.assertEquals(actualSwitchText, expectedSwitchText, "[ERR] Display wrong switch status");
        }

        System.out.println(switchStatus);
        System.out.println(actualSwitchText);
    }

    public void selectDropdownOption(DropDownOption dropDownOption){
        FormScreen formScreen = new FormScreen(appiumDriver);
        FormComponent formComp = formScreen.formComp();
        formComp.clickOnDropdownIcon();

        switch (dropDownOption){
            case Webdriverio:
                formComp.selectWebdriverIoOption();
                break;
            case Appium:
                formComp.selectAppiumOption();
                break;
            default:
                formComp.selectThisAppOption();
                break;
        }
    }

    public void checkActiveAndInActiveButtonFunction(){
        FormScreen formScreen = new FormScreen(appiumDriver);
        FormComponent formComp = formScreen.formComp();
        formComp.clickOnActiveButton();
        formComp.closeAlertSession();
        formComp.clickOnInactiveButton();
    }
}
