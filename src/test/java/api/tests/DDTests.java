package api.tests;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTests {
    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String UserID, String userName, String firstName, String lastName, String Email, String Password, String Phone) {

        User userPayload = new User();
        userPayload.setId(Integer.parseInt(UserID));
        userPayload.setUsername(userName);
        userPayload.setFirstname(firstName);
        userPayload.setLastname(lastName);
        userPayload.setEmail(Email);
        userPayload.setPassword(Password);
        userPayload.setPhone(Phone);
        Response response = UserEndPoints.createUser(userPayload);
        //response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String UserName) {
        Response response = UserEndPoints.deleteUser(UserName);
        response.then().log().all();
        //response.then().log().body().statusCode(200); //Another way of assertion, chai assertion along with REST ASSURED
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

