package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

//Created for CRUD operations, CREATE, UPDATE,DELETE,RETRIEVE
public class UserEndPoints {
     public static Response createUser(User payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);
        return response;
    }

    public static Response readUser(String userName){
        Response response = given()
                .pathParam("username",userName) //Pass path parameter name(as in Routes.class) and value
                .when()
                .get(Routes.get_url);
        return response;
    }

    public static Response updateUser(String userName, User payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName) //Pass path parameter name(as in Routes.class) and value
                .body(payload)
                .when()
                .post(Routes.update_url);
        return response;
    }

    public static Response deleteUser(String userName){
        Response response = given()
                .pathParam("username",userName)//Pass path parameter name(as in Routes.class) and value
                .when()
                .get(Routes.delete_url);
        return response;
    }
}
