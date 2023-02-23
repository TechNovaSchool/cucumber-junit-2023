package api.tests;

import api.models.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utils.Config;

public class AirtableTests {

    @Test
    public void getRecords() throws JsonProcessingException {
        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .get(Config.getProperty("baseUrl"));

        System.out.println(response.statusCode());

        ObjectMapper obj = new ObjectMapper();

        ResponseBody rb = obj.readValue(response.asString(), ResponseBody.class);

        System.out.println(rb.getRecords().get(0).getFields().getFirstName());

        int size = rb.getRecords().size();

        for (int i = 0; i < size; i++) {
            if (rb.getRecords().get(i).getFields().getFirstName().startsWith("A")) {
                String firstName = rb.getRecords().get(i).getFields().getFirstName();
                String lastName = rb.getRecords().get(i).getFields().getLastName();
                String email = rb.getRecords().get(i).getFields().getEmail();
                boolean studentYes = rb.getRecords().get(i).getFields().isStudent();
                int age = rb.getRecords().get(i).getFields().getAge();

                System.out.println(firstName + " " + lastName + " " + email
                        + " " + studentYes + " " +age);
            }
        }






    }
}
