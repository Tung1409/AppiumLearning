package tests.authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import test_data.DropDownOption;
import test_flows.authentication.FormFlow;
import tests.BaseTest;

public class InputFormTest extends BaseTest {
    @Test
    @Description("Form_001, Form_002, Form_003, Form_004, Form_005")
    public void inputFormTest(){
        FormFlow formFlow = new FormFlow(getDriver());
        formFlow.goToFormScreen();
        formFlow.inputText("teo");
        formFlow.verifyInputText();
        formFlow.clickAndVerifySwitchStatus();
        formFlow.selectDropdownOption(DropDownOption.ThisApp);
        formFlow.checkActiveAndInActiveButtonFunction();
    }
}
