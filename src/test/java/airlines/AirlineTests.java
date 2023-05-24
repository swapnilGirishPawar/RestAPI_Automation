package airlines;
import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import restUtils.RestUtils;
import utils.jsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// How to pass env in runtime?
// edit configuration of mavenRunning with command "test -D env = qa"

public class AirlineTests extends AirlineAPIs{
    // create Airline API:-
    @Test
    public void createAirline() throws IOException {

        Map<String, Object> payload = payloads.getCreateAirlinePayloadFromMap("98945", "Swapnil Airways", "IN", "ABC", "ABC Slogan", "Pune", "xyzz.com", "2023");
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);
    }
// create passenger API:-
    @Test
    public void createPassenger() throws IOException {

        Map<String, Object> payload = payloads.getCreatePassengerPayloadFromMap("Swapnil", 10, 15);
        Response response = createPassenger(payload);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
