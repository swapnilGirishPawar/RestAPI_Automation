package airlines;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    public static Map<String, Object> dataFromJsonFile;


    static{
//        String env = System.getProperty("env") == null ? "qa" : "dev";
        try {
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("/airlines/qa/airlinesApiData.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

