<<<<<<< HEAD

=======
>>>>>>> a03aaf9f3d084c8d12c24018a26ef87b4dabc10c
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.DBType;
import utils.DBUtility;

<<<<<<< HEAD
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
=======
import java.util.*;


public class DB_Test {

    @BeforeClass
    public static void setUp(){

        DBUtility.establishConnection(DBType.ORACLE);

    }

    @Test
    public void test1(){


        System.out.println("checking 3rd region is Asia");
        List<Map<String,Object>> lstOfMap = DBUtility.runSQLQuery("SELECT * FROM REGIONS");
        Assert.assertEquals("Asia", lstOfMap.get(2).get("REGION_NAME")  );
>>>>>>> a03aaf9f3d084c8d12c24018a26ef87b4dabc10c


    }

<<<<<<< HEAD
   @AfterClass
   public static void teardown(){

       DBUtility.closeConnections();
   }

}



=======
    @AfterClass
    public static void tearDown(){

        DBUtility.closeConnections();

    }


}
>>>>>>> a03aaf9f3d084c8d12c24018a26ef87b4dabc10c
