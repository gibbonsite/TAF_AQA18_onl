package tests.api;

import baseEntities.BaseApiGsonTest;
import configuration.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.json.TypeToken;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

public class TestRailApiTest2 extends BaseApiGsonTest {

    @Test
    public void getUser() {
        int userID = 1;

        String endpoint = "index.php?/api/v2/get_user/{user_id}";

        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .roleId(1)
                .role("Lead")
                .build();

        User actualUser = given()
                .pathParam("user_id", userID)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class, ObjectMapperType.GSON);

        System.out.println(actualUser.toString());

        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getUser1() {
        int userID = 1;

        String endpoint = "index.php?/api/v2/get_user/{user_id}";

        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .pathParam("user_id", userID)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        User actualUser = gson.fromJson(response.getBody().asPrettyString(), User.class);
        System.out.println(actualUser.toString());

        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getUser2() {
        int userID = 1;

        String endpoint = "index.php?/api/v2/get_user/{user_id}";

        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .roleId(1)
                .role("Lead")
                .build();

        User actualUser = given()
                .pathParam("user_id", userID)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class);

        System.out.println(actualUser.toString());
        System.out.println(expectedUser.toString());

        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getAllUsers1() {
        String endpoint = "index.php?/api/v2/get_users";

        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        User[] actualUserList = gson.fromJson(response.getBody().asPrettyString(),
                User[].class);

        System.out.println(actualUserList.length);
        System.out.println(actualUserList[0].toString());
        System.out.println(actualUserList[1].toString());
    }

    @Test
    public void getAllUsers2() {
        String endpoint = "index.php?/api/v2/get_users";

        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        Type listType = new TypeToken<ArrayList<User>>(){}.getType();

        List<User> actualUserList = gson.fromJson(response.getBody().asPrettyString(),
                listType);

        System.out.println(actualUserList.size());
        System.out.println(actualUserList.get(0).toString());
        System.out.println(actualUserList.get(1).toString());
    }
}
