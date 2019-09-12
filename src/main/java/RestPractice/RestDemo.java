package RestPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestDemo {

    @BeforeClass
    public static void setUp() {


        RestAssured.baseURI = "https://uinames.com";


    }


    @Test
    public void test1() {

        Response response = RestAssured.get("/api");


        response.prettyPrint();

        String restString = response.asString();

        Assert.assertTrue(restString.contains("gender"));

        int code = response.statusCode();

        Assert.assertEquals(200, code);


    }


    @Test
    public void headersTest() {


        Response response = RestAssured.get("/api");
        System.out.println(response.headers());


        System.out.println("********************");
        String ContentType = response.header("Content-Type");

        System.out.println(ContentType);

        Assert.assertEquals("application/json; charset=utf-8", ContentType);

    }

    @Test
    public void statusLineTest() {


        Response response = RestAssured.get("/api");

        String statusLine = response.statusLine();
        System.out.println(statusLine);
        Assert.assertTrue(statusLine.contains("200"));

    }
}