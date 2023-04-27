package smoketest_extra;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static smoketest_extra.S1_Post1.bookinId;
import static utils.AuthenticationHerOkuApp.generateToken;


public class S02_Put extends HerOkuAppBaseUrl {
    /*
    Given
        1) https://restful-booker.herokuapp.com/booking/{id}

        2){
            "firstname" : "Hamadin",
            "lastname" : "Okay",
            "totalprice" : 555,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-01",
                "checkout" : "2024-01-01"
            },
            "additionalneeds" : "Extra Pillow"
        }
       When
         Send Put request

       Then
         Status code should be 200

       And




     */
    @Test
    public void put01(){
        //Set the url
        spec.pathParams("first","booking","second",bookinId);

        //Set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2023-01-01","2024-01-01");
        BookingPojo expectedData = new BookingPojo("Hamadin","Okay",555,false,bookingDatesPojo,"Extra Pillow");
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
       Response response= given().spec(spec).
                          header("Cookie","token="+generateToken()).
                          body(expectedData).
                          put("/{first}/{second}");
       response.prettyPrint();

       //Do assertion

        /*
        BookingResponsePojo actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());

  */
    }
}
