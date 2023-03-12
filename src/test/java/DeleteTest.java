import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DeleteTest {

    @Test
    private void deleteTest1(){

        when().
           delete("https://reqres.in/api/users/2").

        then().
           statusCode(204). // delete 204
           log().all();
    }

}
