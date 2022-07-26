package Collection;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

import static pojo.Constant.Constant.*;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class TriggerIntent_Client extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Trigger intent Client 200")
    @Story("An Endpoint to Trigger intent Client 200")
    public void TriggerIntent_Client_200() throws InterruptedException, IOException {
        Response response = POST_200(TriggerIntentClient_EndPoint, generateStringFromResource("./src/main/java/Payload/TriggerIntent_Client.json"));

        response.prettyPeek().then().spec(responseSpec_200);

        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Intent Triggered Successfully");

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Trigger intent Client 401")
    @Story("An Endpoint to trigger intent Client 401")
    public void TriggerIntent_Client_401() throws InterruptedException, IOException {
        Response response = POST_401(TriggerIntentClient_EndPoint, generateStringFromResource("./src/main/java/Payload/TriggerIntent_Client.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to trigger intent Client 403")
    @Story("An Endpoint to trigger intent Client 403")
    public void TriggerIntent_Client_403() throws InterruptedException, IOException {
        Response response = POST_403(TriggerIntentClient_EndPoint, generateStringFromResource("./src/main/java/Payload/TriggerIntent_Client.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to trigger intent Client 400")
    @Story("An Endpoint to trigger intent Client 400")
    public void TriggerIntent_Client_400() throws InterruptedException, IOException {
        Response response = POST_200(TriggerIntentClient_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateUser.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }
}
