package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    // all json related utils will be stored here.
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static Map<String, Object> getJsonDataAsMap(String jsonFileName) throws IOException {
        String completeJsonFilePath = System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        Map<String, Object> data =  objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>(){});

        return data;
    }
}
