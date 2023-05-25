package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils extends ExtentReportManager{
    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String>headers){
       return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }


    // this post method accept payload as a String
    public static Response performPost(String endPoint, String requestPayload, Map<String, String>headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInRequest(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    // this post method accept payload as a Map of String, Object
    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String, String>headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
//        printRequestLogInRequest(requestSpecification);
//        printResponseLogInReport(response);
        return response;
    }
    public static Response performPost(String endPoint, Object requestPayloadAsPojo, Map<String, String>headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayloadAsPojo, headers);
        Response response = requestSpecification.post();
        return response;
    }

    // this post method accept payload as a Map of String, Object
    public static Response performGet(String endPoint, Map<String, String>headers){
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .get()
                .then().log().all().extract().response();
    }

    // this post method accept payload as a Map of String, Object
    public static Response performDelete(String endPoint, Map<String, Object> requestPayload, Map<String, String>headers){
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .delete()
                .then().log().all().extract().response();
    }

    // this post method accept payload as a Map of String, Object
    public static Response performPatch(String endPoint, Map<String, Object> requestPayload, Map<String, String>headers){
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .patch()
                .then().log().all().extract().response();
    }

    // this method prints request information
    private static void printRequestLogInRequest(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is "+queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is "+queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are "+queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Request Body is "+queryableRequestSpecification.getBody());
    }

    // this method prints response information
    public static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response Status Code is "+response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are "+response.getHeaders());
        ExtentReportManager.logInfoDetails("Response Body is "+response.getBody());
    }

}
