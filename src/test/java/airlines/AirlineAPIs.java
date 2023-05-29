package airlines;

import airlines.Pojos.Airline;
import airlines.Pojos.Passenger;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {
    public Response createAirline(Map<String, Object> createAirlinePayload){
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        return RestUtils.performPost(endPoint,createAirlinePayload, new HashMap<>());
    }
    public Response createAirline(Airline createAirlinePayload){
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        return RestUtils.performPost(endPoint,createAirlinePayload, new HashMap<>());
    }
    public Response createPassenger(Passenger createPassengerPayload){
        String endPoint = (String) Base.dataFromJsonFile.get("createPassengerEndpoint");
        return RestUtils.performPost(endPoint,createPassengerPayload, new HashMap<>());
    }

}
