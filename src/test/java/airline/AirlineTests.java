package airline;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineTests {
    @Test
    public void createAirline(){
        String endPoint = "https://api.instantwebtools.net/v1/airlines";
        Map<String, Object> payload = payloads.getCreateAirlinePayloadFromMap("98990", "Swapnil Airways", "IN", "ABC", "ABC Slogan", "Pune", "xyzz.com", "2023");
        Response response = RestUtils.performPost(endPoint, payload, new HashMap<String, String>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
