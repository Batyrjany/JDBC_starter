package RestPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasToString;

public class SerializingAndDeserializing {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://18.209.44.3";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";

    }
    @Test
    public void Single_Spartan_LoggingAll_Details_Test() {

        given().
                pathParam("my_id", 3).
                log().all()
                .when()
                .get("/spartans/{my_id}")
                .then()
                .log().all()
                .log().ifValidationFails()
                .statusCode(200);

    }
    @Test
    public void Add_NewSpartan_Test() {


        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("name","Ashraf");
        bodyMap.put("gender","Male");
        bodyMap.put("phone","6105035231");




        given()
                .log().all()
                .contentType(ContentType.JSON)
//                .body("{\n" +
//                        "        \"name\": \"Fidole\",\n" +
//                        "        \"gender\": \"Male\",\n" +
//                        "        \"phone\": 6105035231\n" +
//                        "    }")
                //OR we can pass map as a data json body
                .body(bodyMap)
                .when()
                .post("/spartans")
                .then()
                .statusCode(201)
                 .body("success", is("A Spartan is Born!"))
                  .body("data.name", equalToIgnoringCase("Fidole"))
                  .body("data.phone", hasToString("6105035231"));




    }

}
