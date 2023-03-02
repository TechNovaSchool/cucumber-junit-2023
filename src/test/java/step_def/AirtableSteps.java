package step_def;

import api.models.Myfields;
import api.models.Record;
import api.models.RequestBody;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AirTableBasePage;
import pages.AirTableLoginPage;
import utils.APIUtil;
import utils.Config;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class AirtableSteps {
    Faker faker = new Faker();
    String recordID;

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
        Assert.assertEquals(actualName, "Elliot");


    }

    @When("a user creates a record")
    public void aUserCreatesARecord() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fakeEmail = faker.internet().emailAddress();//myfakeemail@gmail.com
        int index = fakeEmail.indexOf("@");
        String emailProvider = fakeEmail.substring(index);

        Myfields fields = new Myfields();
        fields.setFirstName(firstName);
        fields.setLastName(lastName);
        fields.setAge(faker.number().numberBetween(16, 30));
        fields.setEmail(firstName + "." + lastName + emailProvider);
        fields.setStudent(faker.random().nextBoolean());
        fields.setAddress(faker.address().streetAddress());

        Record record = new Record();
        record.setFields(fields);

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPost(resource, requestBody);

    }

    @When("a user is saving the recordID")
    public void aUserIsSavingTheRecordID() {
        recordID = APIUtil.getResponseBody().getRecords().get(0).getId();
    }

    @And("a user updates email")
    public void aUserUpdatesEmail() {
        Myfields fields = new Myfields();
        fields.setEmail(faker.internet().emailAddress());

        Record record = new Record();
        record.setFields(fields);
        record.setId(recordID);

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPatch(resource, requestBody);


    }

    @When("user delete the recordID")
    public void userDeleteTheRecordID() {
        APIUtil.hitDelete(resource, recordID);
    }

    @When("a user tries to create a record with invalid payload")
    public void aUserTriesToCreateARecordWithInvalidPayload() {
        RequestBody requestBody = new RequestBody();
        APIUtil.hitPost(resource, requestBody);
    }


    @Then("user will receive status code: {int}")
    public void userWillReceiveStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, APIUtil.getResponse().statusCode());
    }

    @Given("user is logs in the airtable account")
    public void user_is_logs_in_the_airtable_account() throws InterruptedException {
        AirTableLoginPage airTableLoginPage = new AirTableLoginPage();
        Driver.getDriver().get(Config.getProperty("loginPageAirTable"));
        airTableLoginPage.emailField.sendKeys(Config.getProperty("loginAirtable"));
        airTableLoginPage.passwordField.sendKeys(Config.getProperty("passwordAirtable"));
        airTableLoginPage.signInBtn.click();

    }
    @When("user selects a base")
    public void user_selects_a_base() {
        AirTableBasePage airTableBasePage = new AirTableBasePage();
        airTableBasePage.baseAvatar.click();
    }
    @When("adds a new record")
    public void adds_a_new_record() {

    }
    @Then("will verify the record was saved, using api call")
    public void will_verify_the_record_was_saved_using_api_call() {

    }

}
