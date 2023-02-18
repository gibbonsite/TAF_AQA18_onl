package adapters;

import dbTables.ProjectsTable;
import io.restassured.mapper.ObjectMapperType;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;
import services.DataBaseService;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectAdapter {
    private ProjectsTable projectsTable;

    public ProjectAdapter(DataBaseService dbService) {
        projectsTable = new ProjectsTable(dbService);
    }

    public Project add(Project project) {
        Project createdProject = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class, ObjectMapperType.GSON);

        // Эмулируем создание Project в базе данных при работе с API TestRail
        projectsTable.addProject(createdProject);
        return createdProject;
    }

    public void delete(int projectId) {
        given()
                .pathParam("project_id", projectId)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);

        // Эмулируем удаление Project в базе данных при работе с API TestRail
        projectsTable.deleteProject(projectId);
    }
}
