package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

public class Get0303 {

       /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
     */

    @Test

    public void get0303(){
        //Set the URL
        String url="https://jsonplaceholder.typicode.com/todos/23";


        //Set the request and get the response

        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion
        //1 way
        response.
                then().statusCode(200).contentType("application/json").
        body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).//et itaque necessitatibus maxime molestiae qui quas velit
                body("completed",equalTo(false)).
                body("userId",equalTo(2)).//"userId:2
                body("id",equalTo(23));


        //2 way
        response.
                then().statusCode(200).contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),"completed",equalTo(false),"userId",equalTo(2),"id",equalTo(23));





    }











}
