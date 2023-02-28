package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.APIUtil;

public class AirtableSteps {

    String resource = "/Table%201";

    @When("user call a GET endpoint")
    public void user_call_a_get_endpoint() {
        APIUtil.hitGet(resource);

    }

    @Then("user will receive status {string}")
    public void user_will_receive_status(String statusCode) {
//        String strParse = Integer.toString(APIUtil.getResponse().statusCode());
        String str = String.valueOf(APIUtil.getResponse().statusCode());
        Assert.assertEquals(statusCode, str);

    }

    @When("user call a GET single endpoint")
    public void userCallAGETSingleEndpoint() {
        APIUtil.hitGet(resource + "/rec1jvzVX859WtimN");
    }

    @And("user verify the first name")
    public void userVerifyTheFirstName() {

        String actualName = APIUtil.getResponseBody().getFields().getFirstName();
        Assert.assertEquals(actualName,"Elliot");


    }
}
