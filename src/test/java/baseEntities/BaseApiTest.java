package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected DataBaseService dbService;

    @BeforeTest
    public void setupApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        dbService = new DataBaseService();
    }

    @AfterTest
    public void tearDown() {
        dbService.closeConnection();
    }
}
