package RestPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class HamCrestLibrary {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://18.209.44.3";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";

    }
    @Test
    public void DoingAssertionWithHamcrest_ForSpartan(){
//        Response response= given().pathParam("my_id",3).get("/spartans/{my_id}");
//        response.prettyPrint();

        given()
                .pathParam("my_id",3).
                when()
                .get("/spartans/{my_id}").
                then()
                .assertThat().statusCode(equalTo(200))
                .contentType(ContentType.JSON)
                .body("id",equalTo(3))
                .body("gender",equalTo("Male"))
                .body("phone", hasToString("6105035231"));



    }


    @Test
    public void arrayTest(){

        int[] nums =  {1,4,6,7,8};

        Matchers.contains(hasItemInArray(1));
    }
    @Test
    public void Calculation_Test(){
        int a = 10 , b=20;

        assertEquals(30, a+b);

        assertThat(30,equalTo(a+b));
        assertThat(20,lessThan(a+b));
        assertThat(40,greaterThan(a+b));
    }
    @AfterClass

    public static void tearDown(){

        RestAssured.reset();
    }
}
