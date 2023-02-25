package api.tests;

import org.junit.Test;
import utils.APIUtil;

public class AirtableUtilTest {

    @Test
    public void testGetMethod() {
        String resource = "/Table%201";
        APIUtil.hitGet(resource);
    }
}
