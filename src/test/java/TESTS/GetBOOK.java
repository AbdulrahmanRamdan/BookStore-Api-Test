package TESTS;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
@RunWith(DataProviderRunner.class)
public class GetBOOK {
   static RequestSpecification requestSpecification;
   static ResponseSpecification responseSpecification;
   @DataProvider
   public static Object[] IDS(){
       return new Object[]{"65","357","150","527","542"};
   }
    @BeforeClass
    public static void Setup(){
        requestSpecification=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
        responseSpecification=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }
    @Test
    public void GET_ALL_BOOKS(){
        given().log().all().spec(requestSpecification).when().get("/booking").then().spec(responseSpecification).log().body()
                .assertThat().body("bookingid",not(isEmptyOrNullString()));
    }
    @Test
    @UseDataProvider("IDS")
    public void GET_BOOK_BY_ID(String ID){
        given().log().all().spec(requestSpecification).pathParams("ID",ID).when().get("/booking/{ID}").then().spec(responseSpecification).log().body()
                .assertThat().body("firstname",not(isEmptyOrNullString())).body("totalprice",not(isEmptyOrNullString()));
    }
}
