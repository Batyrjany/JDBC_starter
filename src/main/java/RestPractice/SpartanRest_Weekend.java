package RestPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class SpartanRest_Weekend {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://18.209.44.3";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";

    }

    @Test
    public void test1(){
        //RequestSpecification reqSpec = given().accept(ContentType.JSON);
        Response response =
                // RequestSpecification
                given()
                        .accept(ContentType.JSON).
                        when()
                        // Actual request is being sent using HTTP verbs methods with URL
                        .get("/spartans") ;
        // eventually it will return a Response object
    }
    @Test
    public void test2(){
        //RequestSpecification reqSpec = given().accept(ContentType.JSON);
        Response response =
                // RequestSpecification
                given()
                        .accept(ContentType.JSON).
                        when()
                        // Actual request is being sent using HTTP verbs methods with URL
                        .get("/spartans/2") ;
        // eventually it will return a Response object
        response.prettyPrint();
        assertEquals( "Male" , response.path("gender").toString()     );
    }
    @Test
    public void Search_By_Providing_Query_Parameter() {
        Response response = given().
                accept(ContentType.JSON).
                queryParam("gender", "Male").
                //param("gender","Male").
                        when().
                        get("/spartans/search");
        assertEquals(200, response.statusCode());
        assertFalse(response.asString().contains("Female"));
        response.prettyPrint();
        System.out.println(response.path("pageable.sort.empty").toString());

        boolean isEmpty =response.jsonPath().getBoolean("pageable.sort.empty");
       // assertTrue("ASSERTION FOR EMPTY HAS FAILED", !isEmpty);

        int totalElements = response.jsonPath().getInt("totalElements");
        int size = response.jsonPath().getInt("size");

        System.out.printf(totalElements+" and "+ size);


    }


    @Test
    public void Search_By_Providing_Query_Parameter1() {
        Response response = given().
                accept(ContentType.JSON).
                queryParam("gender", "Male").
                //param("gender","Male").
                        when().
                        get("/spartans/search");
        assertEquals(200, response.statusCode());
        assertFalse(response.asString().contains("Female"));


        long firstPhone =response.jsonPath().getLong("content[0].phone");
        System.out.println("firts guy's phone is " + firstPhone);


        //List<String> phoneList = response.jsonPath().getList("content.phone");
        List<Long> phoneList = response.jsonPath().getList("content.phone");

        System.out.println( phoneList);

        List<String> nameList = response.jsonPath().getList("content.name");

        System.out.println( nameList);

    }
    @AfterClass

    public static void tearDown(){

        RestAssured.reset();
    }
}
