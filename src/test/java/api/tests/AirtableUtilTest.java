package api.tests;

import api.models.Myfields;
import api.models.Record;
import api.models.RequestBody;
import org.junit.Test;
import utils.APIUtil;

import java.util.ArrayList;
import java.util.List;

public class AirtableUtilTest {

    @Test
    public void testGetMethod() {
        String resource = "/Table%201";
        APIUtil.hitGet(resource);
    }

    @Test
    public void testPostMethod() {
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

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPost(resource,requestBody);

    }
}
