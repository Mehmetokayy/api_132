package homework;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Q01 {
   /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

   @Test
   public void  Q01() {


       String url = "https://reqres.in/api/users/3";

       Response response = given().when().get(url);
       response.prettyPrint();


       // HTTP Status Code should be 200
       System.out.println(response.statusCode());

       //Content Type should be JSON
       System.out.println(response.contentType());


       //Status Line should be HTTP/1.1 200 OK
       System.out.println(response.statusLine());

       //How to see "Header" on console:
       System.out.println(response.header("Via"));

       //How to see "Headers" on console:
       System.out.println(response.headers());

       //How to see "Time" on console
       System.out.println(response.time());

       //Server is "cloudflare"
       System.out.println(response.header("Server")); //cloudflare


   }


}
