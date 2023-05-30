package airlines;
import airlines.Pojos.Airline;
import airlines.Pojos.Passenger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

// How to pass env in runtime?
// edit configuration of mavenRunning with command "test -D env = qa"

public class AirlineTests extends AirlineAPIs{
    // create Airline API:-
        // create airline API using pojo payload:-
    @Test
    public void createAirlineUsingPojo(){
//        Airline payload = payloads.getCreateAirlineFromPojo();
        Airline payload = new Airline();
        Response response = createAirline(payload);
        System.out.println("-----------------------------------------Create Airline Request-----------------------------------------");
        System.out.println(payload);
        System.out.println("-----------------------------------------Create Airline Response-----------------------------------------");
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
    }
    // create airline API using map payload:-
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
//        Map<String, Object> payload = payloads.getCreatePassengerPayloadFromMap();
        Passenger payload = new Passenger().toBuilder().name("Swapnil").build();
        System.out.println("-----------------------------------------Create Passenger Request-----------------------------------------");
        System.out.println(payload);
        Response response = createPassenger(payload);
        System.out.println("-----------------------------------------Create Passenger Response-----------------------------------------");
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void createAirlineAndVerifyResponse() throws JsonProcessingException {
        Airline payload = new Airline();
        Response res = createAirline(payload);
        Assert.assertEquals(res.jsonPath().get("name"), payload.getName());
        ObjectMapper objectMapper = new ObjectMapper();
        Airline createAirlineRes = objectMapper.readValue(res.getBody().asString(), Airline.class);
        Assert.assertEquals(createAirlineRes, payload);

    }
}