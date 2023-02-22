package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utils.Config;

public class AirtableTests {

    @Test
    public void getRecords() {
        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .get(Config.getProperty("baseUrl"));

        System.out.println(response.statusCode());

    }
}
