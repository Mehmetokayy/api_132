package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationHerOkuApp {

    public static String generateToken() {
        Map<String, String> tokenBody = new HashMap<>();
        tokenBody.put("username", "admin");
        tokenBody.put("password", "password123");

        Response response = given().contentType(ContentType.JSON).body(tokenBody).post("https://restful-booker.herokuapp.com/auth");
        response.prettyPrint();
        return response.jsonPath().getString("token");

    /*
       public static String generateToken = new HashMap<>();
       Map<String,String> tokenBody = new HashMap<>();
       tokenBody.put("username","admin");
       tokenBody.put("password","password123");


      Response response = given().bod(tokenBody).when().post();

    {
    "username" : "admin",
    "password" : "password123"
}
     */


}}
