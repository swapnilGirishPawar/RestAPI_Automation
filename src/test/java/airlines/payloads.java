package airlines;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class payloads {

    // Creation of payload by using string method is not better than creating the payloads with the hashmaps

    public static String getCreateAirlinePayloadFromString(String id, String name, String country, String logo, String slogan, String head_quaters, String website, String established){
        String payload = "{\n" +
                "    \"id\": "+id+",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"country\": \""+country+"\",\n" +
                "    \"logo\": \""+logo+"\",\n" +
                "    \"slogan\": \""+slogan+"\",\n" +
                "    \"head_quaters\": \""+head_quaters+"\",\n" +
                "    \"website\": \""+website+"\",\n" +
                "    \"established\": \""+established+"\"\n" +
                "}";
        return payload;
    }
    public static Map getCreateAirlinePayloadFromMap(String id, String name, String country, String logo, String slogan, String head_quaters, String website, String established){
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("name", name);
        payload.put("country", country);
        payload.put("logo", logo);
        payload.put("slogan", slogan);
        payload.put("head_quaters", head_quaters);
        payload.put("website", website);
        payload.put("established", established);
        return payload;
    }
    // Using dataFaker:-
    public static Map getCreateAirlinePayloadFromMap(){
        Map<String, Object> payload = new HashMap<>();
        Faker faker = new Faker();
        payload.put("id", RandomDataGenerator.getRandomNumber(10));
        payload.put("name", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME));
        payload.put("country", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY));
        payload.put("logo", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FULLNAME));
        payload.put("slogan", RandomDataGenerator.getRandomAlphabate(20));
        payload.put("head_quaters", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME));
        payload.put("website", RandomDataGenerator.getRandomWebiste());
        payload.put("established",RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));
        return payload;
    }
    public static String getCreateAirlinePayloadFromString(String name, int trips, int airline){
        String payload = "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"trips\": "+trips+",\n" +
                "    \"airline\": "+airline+"\n" +
                "}";
        return payload;
    }
    public static Map getCreatePassengerPayloadFromMap(String name, int trips, int airline){
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("trips", trips);
        payload.put("airline", airline);
        return payload;
    }
    public static Map getCreatePassengerPayloadFromMap(){
        Map<String, Object> payload = new HashMap<>();
        Faker faker = new Faker();
        payload.put("name", faker.name().firstName());
        payload.put("trips", faker.number().digit());
        payload.put("airline", faker.number().digit());
        return payload;
    }

}
