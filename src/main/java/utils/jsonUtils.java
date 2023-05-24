package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import freemarker.template.ObjectWrapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class jsonUtils {
    // all json related utils will be stored here.

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static Map<String, String> getJsonDataAsMap(String jsonFileName) throws IOException {
        String completeJsonFilePath = System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;
        Map<String, String> data =  objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>(){});
        return data;
    }
}
