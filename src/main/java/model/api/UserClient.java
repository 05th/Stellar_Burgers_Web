package model.api;

import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class UserClient {
    public static String URL = "https://stellarburgers.nomoreparties.site";
    private static final String REGISTER = "/api/auth/register";
    private static final String LOGIN = "/api/auth/login";
    private static final String USER = "/api/auth/user";

    public Response createUser(Map<String, String> param){
        return given().log().all()
                .header("Content-type", "application/json")
                .and()
                .body(param)
                .when()
                .post(URL + REGISTER);
    }
    public Response deleteUser(String accessToken){
        return given().log().all()
                .header("Authorization", accessToken)
                .delete(URL + USER);
    }
}