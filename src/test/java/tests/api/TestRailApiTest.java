package tests.api;

import baseEntities.BaseApiTest;
import configuration.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRailApiTest extends BaseApiTest {

    @Test
    public void getAllUsers() {
        String endpoint = "index.php?/api/v2/get_users";

        RequestSpecification httpRequest = given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);
        httpRequest.auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        Response response = httpRequest.request(Method.GET, endpoint);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    public void getAllUsers1() {
        String endpoint = "index.php?/api/v2/get_users";

        given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
