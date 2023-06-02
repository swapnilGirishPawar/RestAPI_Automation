package airlines;
import airlines.Pojos.Airline;
import airlines.Pojos.Passenger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.jvnet.staxex.StAxSOAPBody;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.AssertionsUtils;
import utils.excelUtils;

import java.io.IOException;
import java.util.*;

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
        payload.setCountry("India");
        Response res = createAirline(payload);
        Assert.assertEquals(res.jsonPath().get("name"), payload.getName());
        ObjectMapper objectMapper = new ObjectMapper();
        Airline createAirlineRes = objectMapper.readValue(res.getBody().asString(), Airline.class);
        Assert.assertEquals(createAirlineRes, payload);
    }

    @Test
    public void createAirlineAndVerifyWithAssertionCode(){
        Airline payload = payloads.getCreateAirlineFromPojo();
        Response response = createAirline(payload);
        Map<String, Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("id", payload.getId());
        expectedValueMap.put("name", payload.getName());
        expectedValueMap.put("country", payload.getCountry());
        expectedValueMap.put("logo", payload.getLogo());
        expectedValueMap.put("slogan", payload.getSlogan());
        expectedValueMap.put("head_quaters", payload.getHead_quaters());
        expectedValueMap.put("website", payload.getWebsite());
        expectedValueMap.put("established", payload.getEstablished());
        AssertionsUtils.assertExpectedValueWithJsonPath(response, expectedValueMap);
    }


    // dataProvider :- data driven approach
        // step 1 - Create dataProvider
    @DataProvider(name = "airlineData")
    public Iterator<Airline> createAirlineData() throws IOException {
        List<LinkedHashMap<String, String>> excelDataAsListMap =  excelUtils.getExcelDataListAsMap("createAirlineData", "Sheet1");
        List<Airline> airlineData = new ArrayList<>();
        for (LinkedHashMap<String, String> data : excelDataAsListMap) {
            Airline airline = Airline.builder()
                    .id(Integer.parseInt(data.get("id")))
                    .name(data.get("name"))
                    .country(data.get("country"))
                    .logo(data.get("logo"))
                    .slogan(data.get("slogan"))
                    .head_quaters(data.get("headQuarter"))
                    .website(data.get("website"))
                    .established(data.get("established"))
                    .build();
            airlineData.add(airline);
        }
        return airlineData.iterator();
    }

    // step 2 = pass iterator from dataProvidor method to test method and fetch the value through it.
    @Test(dataProvider = "airlineData")
    public void createAirlineWithDataProvider(Airline airline){
        Response response = createAirline(airline);
        Map<String, Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("id", airline.getId());
        expectedValueMap.put("name", airline.getName());
        expectedValueMap.put("country", airline.getCountry());
        expectedValueMap.put("logo", airline.getLogo());
        expectedValueMap.put("slogan", airline.getSlogan());
        expectedValueMap.put("head_quaters", airline.getHead_quaters());
        expectedValueMap.put("website", airline.getWebsite());
        expectedValueMap.put("established", airline.getEstablished());
        AssertionsUtils.assertExpectedValueWithJsonPath(response, expectedValueMap);
    }

}