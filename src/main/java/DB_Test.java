
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.DBType;
import utils.DBUtility;

import java.util.List;
import java.util.Map;

public class DB_Test {

   @BeforeClass

   public static void setUp(){
       DBUtility.establishConnection(DBType.ORACLE);

   }


    @Test
    public void test(){

        System.out.println("Checking 3rd region in ASIA");

        List<Map<String,Object>> lstMap = DBUtility.runSQLQuery("SELECT *FROM REGIONS");
        Assert.assertEquals("Asia", lstMap.get(2).get("REGION_NAME"));


    }

   @AfterClass
   public static void teardown(){

       DBUtility.closeConnections();
   }

}



