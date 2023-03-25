package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
/*
       Given
           https://restful-booker.herokuapp.com/booking
       When
           User sends get request to the URL
       Then
           Status code is 200
         And
             Among the data there should be someone whose firstname is "John" and lastname is "Smith"
    */

  @Test
    public void get05(){
      //Set the url
         // https://restful-booker.herokuapp.com/booking?firstname=Jane&lastname=Doe
         spec.pathParams("first","booking").queryParams("firstname","Jane","lastname","Doe");

         //Set the expected data and get the response \
        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();

       //Do assertion
      response.then().statusCode(200).body("",hasSize(greaterThan(0)));

      //2nd Way
      assertTrue(response.asString().contains("bookingid"));



  }




}
