package utils;
import io.restassured.response.Response;
import restUtils.AssertionKeys;

import java.util.*;

public class AssertionsUtils {
    public static void assertExpectedValueWithJsonPath(Response response, Map<String, Object> expectedValue){
        List<AssertionKeys> actualValueMap = new ArrayList<>();
        // this line will add table header line 1:- in extent report
//        actualValueMap.add(new AssertionKeys("JSON_PATH", "EXPECTED_VALUE", "ACTUAL_VALUE", "RESULT"));
        Boolean allMatched = true;
        Set<String> jsonPaths = expectedValue.keySet();
        for(String jsonPath : jsonPaths){
            Optional<Object> actualValue = Optional.ofNullable(response.jsonPath().get(jsonPath));
             if(actualValue.isPresent()){
                 Object value = actualValue.get();
                 if(value.equals(expectedValue.get(jsonPath))){
                     actualValueMap.add(new AssertionKeys(jsonPath, expectedValue.get(jsonPath), value, "MATCHED"));
                 }
                 else {
                     allMatched = false;
                     actualValueMap.add(new AssertionKeys(jsonPath, expectedValue.get(jsonPath), value, "NOT_MATCHED"));
                     System.out.println("Value mismatched:- "+jsonPath);

                 }
             }
             else {
                 allMatched = false;
                 actualValueMap.add(new AssertionKeys(jsonPath, expectedValue.get(jsonPath), "VALUE_NOT_FOUND", "NOT_MATCHED"));
             }
        }
        if(allMatched){
//            ExtentReportManager.logPassDetails("All Assertions Passed -----------");
            System.out.println("All Assertions Passed -----------");
        }
        else {
//            ExtentReportManager.logFailDetails("All Assertions Not Passed -----------");
            System.out.println("All Assertions Not Passed -----------");

        }
        // code to create table in extent reports
//        String[][] finalAssertionMap = actualValueMap.stream().map(assertions -> new String[] {assertions.getJsonPath(),
//               String.valueOf(assertions.getExpectedValue()), String.valueOf( assertions.getActualValue()),
//                assertions.getResult()}).toArray(String[][] :: new);
//        Setup.extentTest.get().info(MarkupHelper.createTable(finalAssertionMap));
    }
}
