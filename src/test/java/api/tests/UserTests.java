package api.tests;
import api.endpoints.RoutesFromProperty;
import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import jdk.jfr.Enabled;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.*;

public class UserTests {
    Faker faker;
    User userPayload;
    @BeforeClass
    public void setupData(){

        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());//Parallely setting random id from faker to user payload
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostUser(){
       // System.out.println(RoutesFromProperty.getUrl());
       Response response = UserEndPoints.createUser(userPayload);
       response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2)
    public void testGetUser() {
        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void testUpdateUser(){
        //update data using payload
        userPayload.setFirstname(faker.name().firstName());//Parallely setting random id from faker to user payload
        userPayload.setLastname(faker.name().lastName());
        //Hence we updated only Lastname, email and pwd and pass as updated payload
        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().body();
       // Assert.assertEquals(response.getStatusCode(),200);
        //testGetUser();
    }

    @Test(priority = 4)
    public void testDeleteUser(){
        Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        //response.then().log().body().statusCode(200); //Another way of assertion, chai assertion along with REST ASSURED
        Assert.assertEquals(response.getStatusCode(),200); //Testng Assertion

    }

}


