package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationExerciseTestUrl {

    protected RequestSpecification spec;

    @Before

    public void setup(){
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://automationexercise.com").build();
    }











}
