package api.tests;

import api.models.Myfields;
import api.models.Record;
import api.models.RequestBody;
import com.github.javafaker.Faker;
import org.junit.Test;
import utils.APIUtil;

import java.util.ArrayList;
import java.util.List;

public class AirtableUtilTest {

    public static String myRecord;

    @Test
    public void testZGetMethod() {
        String resource = "/Table%201";
        APIUtil.hitGet(resource);
    }

    @Test
    public void testCPostMethod() {

        Faker faker = new Faker();
        String resource = "/Table%201";

        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String email = fName + lName + "@gmail.com";

        Myfields fields = new Myfields();
        fields.setFirstName("Elliot");
        fields.setLastName("Smith");
        fields.setAddress("442 MacGyver Row");
        fields.setStudent(true);
        fields.setEmail("Elliot.Smith@gmail.com");
        fields.setAge(30);

        Record record = new Record();
        record.setFields(fields);

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPost(resource, requestBody);
        myRecord = APIUtil.getResponseBody().getRecords().get(0).getId();
        System.out.println(myRecord);
    }

    @Test
    public void testZPatchMethod() {

        String resource = "/Table%201";

        Myfields fields = new Myfields();
        fields.setFirstName("Elliot");
        fields.setLastName("Smith");
        fields.setAddress("442 MacGyver Row");
        fields.setStudent(true);
        fields.setEmail("Elliot.Smith@gmail.com");
        fields.setAge(30);

        Record record = new Record();
        record.setFields(fields);
        record.setId(myRecord);

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPatch(resource, requestBody);
    }

    @Test
    public void testADelete(){
        System.out.println(myRecord);
        String resource = "/Table%201";
        String recordToBeDeleted = myRecord;
        APIUtil.hitDelete(resource,recordToBeDeleted);
        System.out.println(APIUtil.getResponse().asString());

    }



}
