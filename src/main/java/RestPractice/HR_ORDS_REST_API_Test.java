package RestPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HR_ORDS_REST_API_Test {


@BeforeClass
public static void setUP(){
    RestAssured.baseURI="http://18.209.44.3";
    RestAssured.port = 1000;
    RestAssured.basePath ="/ords/hr";

}

    @Test
    public  void test_all_regions(){


        Response response = get("/regions");

       // response.prettyPrint();

        String firstRegion =response.jsonPath().getString("items[0].region_name");

        System.out.println(firstRegion);

        String secondRegion =response.jsonPath().getString("items[0].region_name");

        System.out.println(secondRegion);

        List<String> all = response.jsonPath().getList("items.region_name");
        System.out.println(all);

        List<String> href = response.jsonPath().getList("items.links.href[0]");
        System.out.println(href);

        String allLinks = response.jsonPath().getString("items[1].links[0].href");
        System.out.println(allLinks);

        List<String> all_regionlinkList = response.jsonPath().getList("items.links.href");
        System.out.println(all_regionlinkList);

        String lastLinks = response.jsonPath().getString("links[3].rel");
        assertEquals("first", lastLinks);
        System.out.println(lastLinks);


        assertEquals(200,response.statusCode());



    }


    @Test
    public void test_single_Region(){

    Response response = given().pathParam("my_id",1)
            .get("/regions/{my_id}");
    //response.prettyPrint();

        Map<String, Object> myJsonMap = response.jsonPath().getMap("");
        System.out.println(myJsonMap);
        System.out.println(myJsonMap.get("region_id"));
        System.out.println(myJsonMap.get("region_name"));
        System.out.println(myJsonMap.get("links"));


    }


    //18.209.44.3:8000






@AfterClass

    public static void tearDown(){

    RestAssured.reset();
}





}
