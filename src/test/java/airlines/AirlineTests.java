package airlines;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

// How to pass env in runtime?
// edit configuration of mavenRunning with command "test -D env = qa"

public class AirlineTests extends AirlineAPIs{
    // create Airline API:-
    @Test
    public void createAirline() throws IOException {
        Map<String, Object> payload = payloads.getCreateAirlinePayloadFromMap();
        Response response = createAirline(payload);
        System.out.println("-----------------------------------------Create Airline Request-----------------------------------------");
        System.out.println(payload);
        System.out.println("-----------------------------------------Create Airline Response-----------------------------------------");
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
    }
// create passenger API:-
    @Test
    public void createPassenger() throws IOException {
        Map<String, Object> payload = payloads.getCreatePassengerPayloadFromMap();
        System.out.println("-----------------------------------------Create Passenger Request-----------------------------------------");
        System.out.println(payload);
        Response response = createPassenger(payload);
        System.out.println("-----------------------------------------Create Passenger Response-----------------------------------------");
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
    }
}