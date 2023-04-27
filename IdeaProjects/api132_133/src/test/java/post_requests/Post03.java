package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {
    /*
     Given

        {
        "userId": 55,
        "title": "Tidy your room",
        "completed": false
        }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
 */
    @Test
    public void post03(){
        //Set the URL
        spec.pathParam("first","todos");
        
        //Set the expected data 
       JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);
        
        //Send the request and get the response

      Response response = given(spec).body(expectedData).post("{first");
      response.prettyPrint();

       //Do Assertion
        
        
        JsonPlaceHolderPojo acttualData = response.as(JsonPlaceHolderPojo.class);
        System.out.println("acttualData = " + acttualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),acttualData.getUserId());
        assertEquals(expectedData.getTitle(),acttualData.getTitle());
        assertEquals(expectedData.getCompleted(),acttualData.getCompleted());

        
        
        
        
    }
    
    


}
