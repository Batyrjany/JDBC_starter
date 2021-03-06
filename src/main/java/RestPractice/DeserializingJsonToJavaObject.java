package RestPractice;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.ConfigurationReader;

import static io.restassured.RestAssured.get;

public class DeserializingJsonToJavaObject {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = ConfigurationReader.getProperty("spartan.base_uri");
        RestAssured.port = Integer.parseInt(ConfigurationReader.getProperty("spartan.port"));
        RestAssured.basePath = ConfigurationReader.getProperty("spartan.base_path");
        // above will generate a BASE REQUEST URL OF http://52.23.254.102:8000/api
    }


    @Test
    public void DeserializeAnJsonToObject_Test() {

        // FIRST WAY
        Spartan sp1 = get("/spartans/10").prettyPeek()
                .jsonPath()
                .getObject("",Spartan.class) ;
        System.out.println(sp1);


        System.out.println("*******************");

        // SECOND WAY

        Spartan sp2 = get("/spartans/15").prettyPeek().as(Spartan.class);
        System.out.println(sp2);




    }



}