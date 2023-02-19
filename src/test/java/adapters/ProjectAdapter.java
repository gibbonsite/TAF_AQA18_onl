package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectAdapter {
    public Project add(Project project) {
        return given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class, ObjectMapperType.GSON);
    }

    public void delete(int projectId) {
        given()
                .pathParam("project_id", projectId)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
