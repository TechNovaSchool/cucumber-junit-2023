package api.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class MyFirstAPITest {
    //1. Hitting an endpoint or hit the api
    //2. What type of request it will be (get, patch, post, delete),
    // auth, headers, url(endpoint),params,body (request/response)

    @Test
    public void getListOfTheBooks() {
        Response response = RestAssured.get("https://simple-books-api.glitch.me/books");
        System.out.println(response.asString());
//        System.out.println(response.statusCode());
        Assert.assertEquals(200, response.statusCode());

        JsonPath jsonPath = response.jsonPath();
        String str = jsonPath.get("[1].name");
        int size = jsonPath.getList("").size();

        for (int i = 0; i < size; i++) {
            String names = jsonPath.get("[" + i + "].name");
            System.out.println(names);
        }
    }
    //authorization example
    @Test
    public void getAllOrders(){
        Response response = RestAssured.given()
                .header("Authorization", "Bearer e3172a803e39f1d0fcdccf4a930bde1c9344890b43990c1b0516e07b71a47559")
                .get("https://simple-books-api.glitch.me/orders");
        System.out.println(response.statusCode());
    }

    @Test
    public void airtableAuth(){
        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .get("https://api.airtable.com/v0/appQnSxkexdg2mCnv/Table%201");

        System.out.println(response.statusCode());
    }


}
