package RestPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class SpartanRest_API_Sunday {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = ConfigurationReader.getProperty("spartan.base_uri");
        RestAssured.port = Integer.parseInt(ConfigurationReader.getProperty("spartan.port"));
        RestAssured.basePath = ConfigurationReader.getProperty("spartan.base_path");
        // above will generate a BASE REQUEST URL OF http://52.23.254.102:8000/api
    }

    @Test
    public void All_Spartan_With_Size_And_Items_Test(){

        given()
                .accept(ContentType.JSON).
                when()
                      .get("/spartans").prettyPeek().
                then().
                statusCode(200).
                assertThat()
                .body("[0].name",equalTo("Meade"))
                .body("name", hasItem("Abie"))
       .body("",hasSize(115))
                .body("[1].gender",equalTo("Male"))
        .header("Transfer-Encoding","chunked")
        .header("Date", notNullValue());



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

}
