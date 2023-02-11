package baseEntities;

import adapters.CaseAdapter;
import adapters.MilestoneAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected MilestoneAdapter milestoneAdapter;
    protected CaseAdapter caseAdapter;

    @BeforeClass
    public void setupApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(new ObjectMapperConfig().gsonObjectMapperFactory(
                        (cls, charset) -> {
                            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                            return gson;
                        }
                ));

        milestoneAdapter = new MilestoneAdapter();
        caseAdapter = new CaseAdapter();
    }
}
