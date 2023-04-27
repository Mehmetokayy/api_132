package get_requests;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

public class Get1212 extends HerOkuAppBaseUrl {




     /*
        Given
            https://restful-booker.herokuapp.com/booking/535
        When
            I send GET Request to the url
        Then
            Response body should be like that;
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
    public void get1212(){
        //Set the URL
        spec.pathParams("first","booking","second","535");

        //Set the expected Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("John","Smith",111,true,bookingDatesPojo,"Breakfast");





    }

}
