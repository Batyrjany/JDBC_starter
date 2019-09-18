package RestPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseURIDemo {


  @BeforeClass
    public static void setup() {


      RestAssured.baseURI = "https://api.got.show/api";

  }
       @Test
    public void cultureTest() {


      //  RestAssured.baseURI = "https://api.got.show/api";


        Response response = RestAssured.get("/cultures/");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Ironborn"));

    }

    @Test
    public void citiesTest(){
      //  RestAssured.baseURI = "https://api.got.show/api";
        Response response = RestAssured.get("/cities/");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("White Harbor"));



    }

}