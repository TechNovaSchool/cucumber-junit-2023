package api.tests;

import api.models.book.BookRecords;
import api.models.book.CreateOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class BookAPITest {


    @Test
    public void createJsonObject() throws JsonProcessingException {
        BookRecords records = new BookRecords();

        records.setId("myRandomID");
        records.setBookId(1);
        records.setCustomerName("Andrew");
        records.setQuantity(10);

        ObjectMapper objectMapper = new ObjectMapper();// --> this is from jackson library

        String recordsJson = objectMapper.writeValueAsString(records);

        System.out.println(recordsJson);

    }


    @Test
    public void postAnOrder() throws JsonProcessingException {
        CreateOrder createOrder = new CreateOrder();
        createOrder.setBookId(1);
        createOrder.setCustomerName("Jim Smith");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(createOrder);
        System.out.println(requestBody);

        Response response = RestAssured.given()
                .header("Authorization", "Bearer e3172a803e39f1d0fcdccf4a930bde1c9344890b43990c1b0516e07b71a47559")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://simple-books-api.glitch.me/orders");

        System.out.println(response.statusCode());
        System.out.println(response.asString());

    }





}
