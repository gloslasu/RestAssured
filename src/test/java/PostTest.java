// biblioteki gson, jackson, Json, Simple json

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostTest {

    @Test
    private void postTest1(){
// post z użyciem mapy
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("last_name", "Lech");
        map.put("first_name", "Sławek");
        System.out.println(map);

        JSONObject request = new JSONObject(map); //formatuje do postaci JSONa
        System.out.println(request);
    }

    @Test
    private void postTest2(){
//dodawanie kluczy i wartości bez użycia mapy
        JSONObject request = new JSONObject();
        request.put("first_name", "Sławek");
        request.put("last_name", "Lech");

        System.out.println(request);

        given().
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
                post("https://reqres.in/api/users").

        then().
                statusCode(201). // post 201
                log().all();
    }


}
