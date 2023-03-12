package api_learning.testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameter {

    @Test
    @Parameters({"udid", "systemPort"})
    public void parameter(String udid, String systemPort) {
        // cai String udid, systemPort no se match theo thu tu cua @Parameter("udid", "systemPort")
        System.out.printf("udid: %s | systemPort: %s", udid, systemPort);
    }
}
