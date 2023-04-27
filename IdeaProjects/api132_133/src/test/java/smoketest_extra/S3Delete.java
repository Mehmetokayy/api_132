package smoketest_extra;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S3Delete extends HerOkuAppBaseUrl {
     /*
     Given
     https://restful-booker.herokuapp.com/booking/1715

     When
         Send delete request

     Then
         Status code should be 201
     And
         Body should be  "Created"
      */

    @Test
    public void delete01(){
        //Set the url
        spec.pathParams("first","booking","second","1599");


        //Set the expected data
        String expectedData = "Created";

        //Send the request and get the response
       Response response = given().
                           spec(spec).
                           header("Cookie","token=c08a81aa116ffe8").when().delete("/{first}/{second}");

       response.prettyPrint();



       //Do assertion
        assertEquals(201,response.statusCode());
        assertEquals(expectedData,response.asString());






    }



}
