package homework;
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */

import base_urls.RegresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anEmptyMap;

public class Q02 extends RegresBaseUrl {
 @Test
    public void Q02(){

     // i) Set the URL
     String url ="https://reqres.in/api/users/23";
     spec.pathParams("first","users","second",23);


     //ii)Set the expected data

     //iii) Send the request and get the response
     Response response =given().spec(spec).when().get("/{first}/{second}");
     response.prettyPrint();

     //HTTP Status code should be 404
  System.out.println(response.statusCode());

     // Status Line should be HTTP/1.1 404 Not Found
  System.out.println(response.statusLine());

  response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found").
          header("Server","cloudflare");       //.body("",anEmptyMap()); ????




 }





















}
