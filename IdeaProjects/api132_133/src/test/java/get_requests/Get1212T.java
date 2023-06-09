package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get1212T extends GoRestBaseUrl {


    /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        "Gov. Vrinda Panicker", "Sen. Devika Embranthiri" and "Rev. Jay Shukla" are among the users
    And
        The female users are less than or equals to male users
*/

@Test
    public void get12123(){
    // i) Set the URL

    spec.pathParam("first","users");

    // ii)Set the expected data


    // iii)Send the request and get the response
    Response response = given().spec(spec).get("{first}");
    response.prettyPrint();

    // iv) Do assertion
    response.
            then().
            statusCode(200).
            body("meta.pagination.limit",equalTo(10),
                    "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),"data",hasSize(10),
                    "data.status",hasItem("active"));
                   // "data.name");//hasItems("Anasooya Panicker","Arnesh Pilla","Brahmaanand Gill","Anila Singh"));

    //Kadin ve erkek sayilarini karsilastiriniz
    //1.Way:
    JsonPath jsonPath = response.jsonPath();
     List<String> genders = response.jsonPath().getList("data.gender");
    System.out.println("genders = " + genders);
    int female =0;
    for(String w : genders){
        if(w.equals("female")){
            female++;
        }

    }
    System.out.println("female = " + female);
    assertTrue(female>=genders.size()-female);


    // List<String> status =response.jsonPath().getList("data.status");
    //System.out.println("status = " + status);


    //2.Way: Groovy
   List<String> femaleList = jsonPath.getList("data.findAll{it.gender=='female'}.gender");

    System.out.println("femaleList = " + femaleList);
    List<String> maleList = jsonPath.getList("data.findAll{it.gender=='male'}.gender");
    System.out.println("maleList = " + maleList);

    assertTrue(femaleList.size() >=maleList.size());


}



}
