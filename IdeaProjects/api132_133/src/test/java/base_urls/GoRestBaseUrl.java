package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRestBaseUrl {

    protected RequestSpecification spec;

    @Before//This will run before each test method
    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1").build();
    }


}