package baseEntities;

import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseApiGsonTest {
    protected Gson gson;

    @BeforeTest
    public void setupApi() {
        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}
