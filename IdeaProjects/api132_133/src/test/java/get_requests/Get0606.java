package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get0606 extends HerOkuAppBaseUrl {

    /*
      Given
          https://restful-booker.herokuapp.com/booking/32
      When
          User send a GET request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response content type is “application/json”
      And
          Response body should be like;
              {
                  "firstname": "John",
                  "lastname": "Smith",
                  "totalprice": 111,
                  "depositpaid": true,
                  "bookingdates": {
                      "checkin": "2018-01-01",
                      "checkout": "2019-01-01"
                  },
                  "additionalneeds": "Breakfast"
              }
   */

    @Test
    public void get0606(){
        //Set the URL
        spec.pathParams("first","booking","second","23");

        //Set the expected data


        //Send the request and get the response
       Response response = given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();


       //Do Assertion
        //1.Way

        response.
                then().
                statusCode(200).contentType(ContentType.JSON).
                body("firstname",equalTo("Josh"),"lastname",equalTo("Allen"),"totalprice",equalTo(111),"depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),"bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("super bowls"));

        //2.Way: JsonPath
            JsonPath jsonPath = response.jsonPath();
        assertEquals("Josh",jsonPath.getString("firstname"));
        assertEquals("Allen",jsonPath.getString("lastname"));
        assertEquals(111,jsonPath.getInt("totalprice"));
        assertTrue(jsonPath.getBoolean("depositpaid"));
        assertEquals(null,jsonPath.getString("checkout"));
        assertEquals(null,jsonPath.getString("checkin"));
        assertEquals("super bowls",jsonPath.getString("additionalneeds"));

        //3.Way: Test NG Soft Assert
        //1. SoftAssert objesi olustur
        SoftAssert softAssert = new SoftAssert();

        //2. Assertion
        softAssert.assertEquals(jsonPath.getString("firstname"),"Josh","firstname is not match");
        softAssert.assertEquals(jsonPath.getString("lastname"),"Allen","lastname is not match");
        softAssert.assertEquals(jsonPath.getInt("totalprice"),111,"lastname is not match");
        softAssert.assertEquals(jsonPath.getBoolean("depositpaid"),true,"deposit is not match");
        softAssert.assertEquals(jsonPath.getString("checkin"),null,"checkin is not match");
        softAssert.assertEquals(jsonPath.getString("checkout"),null,"checkout is not match");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"),"super bowls","additionalneeds are not match");

        //3. softAssert.assertAll() diyerek dogrulamayi kontrol et aksi taktirde test hep "PASS" olur.
        softAssert.assertAll();


    }

}
