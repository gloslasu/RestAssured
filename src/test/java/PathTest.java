import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathTest {
    @Test
    private void pathTest1(){
//dodawanie kluczy i wartości bez użycia mapy
        JSONObject request = new JSONObject();
        request.put("first_name", "Sławek");
        request.put("last_name", "Lech");

        given().
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).

                when().
                patch("https://reqres.in/api/users/2").

                then().
                statusCode(200). // patch 200
                log().all();
    }


}
