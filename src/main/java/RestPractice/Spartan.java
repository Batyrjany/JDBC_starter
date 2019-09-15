package RestPractice;

import io.restassured.http.ContentType;
import org.junit.Test;



import static io.restassured.RestAssured.given;

public class Spartan {

private String name;
private String gender;
private long phone;

    public Spartan(String name, String gender, long phone) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Test
    public void Add_NewSpartan_withPojoAsBody_Test() {


        Spartan spartan = new Spartan("Myensulu","Female",123123123);
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(spartan)
                .when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(201);




    }

}
