package homework;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Q09 extends PetStoreBaseUrl {
    //Using the https://petstore.swagger.io/ document, write an automation test that finds the number of "pets" with a status of "available" and asserts that those are more than 100.

 /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sens Get request
    Then
        Assert that number of pets whose status is "available" is more than 100
     */
  @Test
      public void q09(){
      //Set the url
      spec.pathParams("first","pet","second","findByStatus").queryParam("status","available");

      //Set the expected Data
             Response response = given(spec).get("{first}/{second}");
             response.prettyPrint();

       //Send the request and get the response

         int numOfavailablePets  = response.jsonPath().getList("id").size();
         assertTrue(numOfavailablePets>100);






  }








}
