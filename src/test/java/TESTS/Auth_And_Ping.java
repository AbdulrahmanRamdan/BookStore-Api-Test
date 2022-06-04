package TESTS;

import CLASSES.AUTH;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class Auth_And_Ping {
    static RequestSpecification requestSpecification;
    @BeforeClass
    public static void Setup(){
        requestSpecification=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
    @Test
    public void Auth(){
        AUTH auth=new AUTH("admin","password123");
        given().contentType(ContentType.JSON).body(auth).log().body()
                .when().post("https://restful-booker.herokuapp.com/auth").then().assertThat().body("token",not(""))
                .statusCode(200).log().body();
    }
    @Test
    public void ping(){
        given().log().all().spec(requestSpecification).when().get("/ping")
                .then().log().body().statusCode(201).contentType(ContentType.TEXT);
    }
}
