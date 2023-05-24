package airlines;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import restUtils.RestUtils;
import utils.jsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineTests {
    @Test
    public void createAirline() throws IOException {
        String env = System.getProperty("env") == null ? "qa" : "dev";
        Map<String, String> data = jsonUtils.getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
        String endPoint = data.get("createAirLineEndpoint");
        Map<String, Object> payload = payloads.getCreateAirlinePayloadFromMap("98993", "Swapnil Airways", "IN", "ABC", "ABC Slogan", "Pune", "xyzz.com", "2023");
        Response response = RestUtils.performPost(endPoint, payload, new HashMap<String, String>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
