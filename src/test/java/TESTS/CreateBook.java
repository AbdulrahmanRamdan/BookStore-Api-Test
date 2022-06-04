package TESTS;

import CLASSES.BOOKING;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.minidev.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class CreateBook {
    static String name="abdo";
    static String price="120";
    static String need="Breakfast";
    static BOOKING booking;
    static RequestSpecification requestSpecification;
    static ResponseSpecification responseSpecification;
    @BeforeClass
    public static void SetUp(){
        booking=new BOOKING(name,price,need);
        requestSpecification=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
        responseSpecification=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
;    }
    @Test
    public void CreateBook(){
       given().contentType(ContentType.JSON).body(booking).log().all().when().post("https://restful-booker.herokuapp.com/booking")
               .then().spec(responseSpecification).log().body().assertThat().body("booking.'firstname'",equalTo(name))
               .body("booking.'lastname'",equalTo(name)).body("booking.'totalprice'",equalTo(Integer.parseInt(price)))
               .body("booking.'additionalneeds'",equalTo(need)).body("bookingid",not(empty()));
    }
}
