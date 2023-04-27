package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post0101 extends JsonPlaceHolderBaseUrl {
      /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
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

    /*
    De-Serialization: Json datanin Java objesine cevrilmesi.
    Serialization: Java objsinin Json data ya cevrilmesi.
    2 turlu De-Serialization yapacagiz:
       i) Gson: Google tarafindan uretilmistir.
       ii)Object Mapper: En populeri
     */




   @Test
    public void post0101(){
       //Set the URL
       spec.pathParam("first","todos");

       //Set the expected data ==>Payload
       /*
       {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        */

       Map<String,Object> expectedData =new HashMap<>();
       expectedData.put("userId",55);
       expectedData.put("title","Tidy your room");
       expectedData.put("completed",false);
       System.out.println("expectedData = " + expectedData);

       //Send the request and get the response
       Response response = given().spec(spec).when().body(expectedData).//Gonderecegimiz expected datanin body sini iceriyor.
               post("/{first}");
        response.prettyPrint();
        
        
        //Do Assertion
         Map<String,Object> actualData = response.as(HashMap.class);//De-Serialization ==> Json to Java 
      System.out.println("actualData = " + actualData);


      assertEquals(201,response.statusCode());
      assertEquals(expectedData.get("completed"),actualData.get("completed"));
      assertEquals(expectedData.get("title"),actualData.get("title"));
      assertEquals(expectedData.get("userId"),actualData.get("userId"));

        
        
        
        
   }



}
