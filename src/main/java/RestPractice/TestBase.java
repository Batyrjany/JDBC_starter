package RestPractice;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {


    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://18.209.44.3";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
        // above will generate a BASE REQUEST URL OF http://18.209.44.3:8000/api
    }


}
