package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import com.sun.source.tree.AssertTree;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestRailApiTest1 extends BaseApiTest {
    int projectID;
    Project expectedProject;

    @Test
    public void addProject1() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_01");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\",\n" +
                        "  \"announcement\": \"%s\",\n" +
                        "  \"show_announcement\": %b,\n" +
                        "  \"suite_mode\" : %d\n" +
                        "}",
                        expectedProject.getName(),
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
        expectedProject.setName("WP_Project_01");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", expectedProject.getName());
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
        expectedProject.setName("WP_Project_03");
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

    @Test
    public void addProject3_1() {
        ProjectAdapter projectAdapter = new ProjectAdapter();

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_03");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        Project actualProject = projectAdapter.add(expectedProject);
        Assert.assertEquals(actualProject, expectedProject);

    }

    @Test
    public void addProject4() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_04");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        projectID = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getInt("id");

        System.out.println(projectID);
    }

    @Test
    public void addProject5() {
        String endpoint = "index.php?/api/v2/add_project";

        expectedProject = new Project();
        expectedProject.setName("WP_Project_05");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        Response response = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        projectID = response.getBody().jsonPath().get("id");

        Assert.assertEquals(response.getBody().jsonPath().getString("name"),
                expectedProject.getName());
    }

    @Test(dependsOnMethods = "addProject5")
    public void readProject() {
        String endpoint = "index.php?/api/v2/get_project/{project_id}";

        Response response =  given()
                .pathParams("project_id", projectID)
                .log().all()
        .when()
                .get(endpoint)
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(projectID))
                .body("name", is(expectedProject.getName()))
                .extract().response();
    }
}
