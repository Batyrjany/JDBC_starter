package RestPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.ConfigurationReader;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasSize;

import static org.junit.Assert.*;

public class Spartan_Rest_API_Sunday {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = ConfigurationReader.getProperty("spartan.base_uri");
        RestAssured.port = Integer.parseInt(ConfigurationReader.getProperty("spartan.port"));
        RestAssured.basePath = ConfigurationReader.getProperty("spartan.base_path");
        // above will generate a BASE REQUEST URL OF http://52.23.254.102:8000/api
    }

    @Test
    public void All_Spartan_With_Size_And_Items_Test() {

        given()
                .accept(ContentType.JSON).
                when()
                .get("/spartans").prettyPeek().
                then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
               .body("[0].name", equalTo("Fidole"))
                .body("name", hasItem("Fidole"))
                .body("name", hasSize(139) )
               .body("[1].gender", is("Female"))
                .header("Transfer-Encoding", "chunked")
                .header("Date", notNullValue())

        ;


    }

    // logging in RestAssured
    @Test
    public void Single_Spartan_LoggingAll_Details_Test() {

        given()
                .pathParam("my_id", 3)
                .log().all(). // we can put log().all() to see all request information in console
        when()
                .get("/spartans/{my_id}").
        then()
                // we can put log().all() to see all response information in console
                // there are multiple option to see exactly when we want to see the log
                // in below example we only want to see the response log if any validation fails
                .log().ifValidationFails()
                .statusCode(200)

        ;


    }
}
