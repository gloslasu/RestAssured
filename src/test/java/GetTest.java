import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetTest {

    @Test
    public void getTest1(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Response response1 = get("https://reqres.in/api/users?page=2"); // import static io.restassured.RestAssured.*;

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    private void getTest2(){
        Response response = get("https://reqres.in/api/users?page=2");
        given().
                get("https://reqres.in/api/users?page=2").

        then().
                statusCode(200).
                body("data.id[0]", equalTo(7)). //import static org.hamcrest.Matchers.*;
                log().all();



    }


}
