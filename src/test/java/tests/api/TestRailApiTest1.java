package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRailApiTest1 extends BaseApiTest {

    @Test
    public void addProject1() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setNameA("WP_Project_01");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\",\n" +
                        "  \"announcement\": \"%s\",\n" +
                        "  \"show_announcement\": %b,\n" +
                        "  \"suite_mode\" : %d\n" +
                        "}", expectedProject.getNameA(),
                        expectedProject.getAnnouncement(),
                        expectedProject.isShowAnnouncement(),
                        expectedProject.getType()
                ))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void addProject2() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setNameA("WP_Project_01");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", expectedProject.getNameA());
        jsonMap.put("suite_mode", expectedProject.getType());

        given()
                .body(jsonMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void addProject3() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setNameA("WP_Project_01");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }
}
