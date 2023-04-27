package smoketest_extra;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S1_Post1 extends HerOkuAppBaseUrl {

      /*
   ** Given
       https://restful-booker.herokuapp.com/booking
    ** And
    {
    "bookingid": 9010,
    "booking": {
        "firstname": "Mehmet",
        "lastname": "Okay",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Nothing"
    }
}
    **  When
         Send post request

   ** Then
     Status code should be 200
    **And
      Response body should be :
    {
    "bookingid": 9010,
    "booking": {
        "firstname": "Mehmet",
        "lastname": "Okay",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Nothing"
    }
}

     */
  static int bookinId;
 @Test
    public void post01(){
     //Set url
     spec.pathParam("first","booking");


     //Set expected data
     BookingDatesPojo bookingDatesPojo =new BookingDatesPojo("2018-01-01","2019-01-01");
     BookingPojo expectedData =new BookingPojo("Mehmet","Okay",111,true,bookingDatesPojo,"Nothing");
     System.out.println("expectedData = " + expectedData);


     //Send the request and get the response
      Response response= given().spec(spec).when().body(expectedData).post("{first}");
       response.prettyPrint();



       //Do assertion
    BookingResponsePojo actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),BookingResponsePojo.class);
  System.out.println("actualData = " + actualData);

  assertEquals(200,response.statusCode());
  assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
  assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
  assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
  assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
  assertEquals(bookingDatesPojo.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
  assertEquals(bookingDatesPojo.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
  assertEquals(expectedData.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());

   bookinId= actualData.getBookingid();

 }



}
