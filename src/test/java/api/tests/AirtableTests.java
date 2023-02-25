package api.tests;

import api.models.Myfields;
import api.models.Record;
import api.models.RequestBody;
import api.models.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.Config;

import java.util.ArrayList;
import java.util.List;

public class AirtableTests {

    String myRecordID;

    @Test
    public void a_getRecords() throws JsonProcessingException {
        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .get(Config.getProperty("baseUrl"));

        System.out.println(response.statusCode());

        ObjectMapper obj = new ObjectMapper();

        ResponseBody rb = obj.readValue(response.asString(), ResponseBody.class);

        System.out.println(rb.getRecords().get(0).getFields().getFirstName());

        int size = rb.getRecords().size();

//        for (int i = 0; i < size; i++) {
//            if (rb.getRecords().get(i).getFields().getFirstName().startsWith("A")) {
//                String firstName = rb.getRecords().get(i).getFields().getFirstName();
//                String lastName = rb.getRecords().get(i).getFields().getLastName();
//                String email = rb.getRecords().get(i).getFields().getEmail();
//                boolean studentYes = rb.getRecords().get(i).getFields().isStudent();
//                int age = rb.getRecords().get(i).getFields().getAge();
//
//                System.out.println(firstName + " " + lastName + " " + email
//                        + " " + studentYes + " " +age);
//            }
//        }

//        for (Record element : rb.getRecords()) {
//            if (element.getFields().getFirstName().startsWith("A")) {
//                System.out.println(element.getFields().getFirstName()
//                        + " " + element.getFields().getLastName()
//                        + " " + element.getFields().getEmail()
//                        + " " + element.getFields().isStudent()
//                        + " " + element.getFields().getAge());
//
//            }
//        }

        for (Record element : rb.getRecords()) {

            String firstChart = element.getFields().getFirstName().substring(0, 1);
            if (firstChart.equals("A")) {
                System.out.println(element.getFields().getFirstName()
                        + " " + element.getFields().getLastName()
                        + " " + element.getFields().getEmail()
                        + " " + element.getFields().isStudent()
                        + " " + element.getFields().getAge());
            }
        }
    }


    @Test
    public void b_postRecord() throws JsonProcessingException {

        Myfields newStudent = new Myfields();
        newStudent.setFirstName("Andres");
        newStudent.setLastName("Nova");
        newStudent.setEmail("andrew@gmail.com");
        newStudent.setStudent(true);
        newStudent.setAddress("1478 Drive rd");
        newStudent.setAge(25);

        Record record = new Record();
        record.setFields(newStudent);

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();

        requestBody.setRecords(records);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(requestBody);
        System.out.println(jsonValue);

        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(jsonValue)
                .post(Config.getProperty("baseUrl"));

        System.out.println(response.statusCode());

        ResponseBody rb = objectMapper.readValue(response.asString(), ResponseBody.class);
        myRecordID = rb.getRecords().get(0).getId();
        System.out.println(myRecordID);
    }

    @Test
    public void c_patchRecord() throws JsonProcessingException {
        System.out.println(myRecordID);


        Myfields studentUpdate = new Myfields();
        studentUpdate.setAddress("1478 Drive rd");

        Record record = new Record();
        record.setFields(studentUpdate);
        record.setId(myRecordID);

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(requestBody);
        System.out.println(jsonValue);

        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(jsonValue)
                .patch(Config.getProperty("baseUrl"));

        System.out.println(response.statusCode());
    }

    @Test
    public void d_deleteRecord() {

        String queryParam = "records[]";
        String recordID = myRecordID;

        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .queryParam(queryParam, recordID)
                .delete(Config.getProperty("baseUrl"));

        Assert.assertEquals(response.statusCode(),200);
        System.out.println(response.statusCode());


    }
}
