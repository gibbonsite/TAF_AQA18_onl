package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Project;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter  {

    public Project add(Project project) {
        String jsonBody = gson.toJson(project);

        return add(jsonBody);
    }

    public Project add(String jsonBody) {
        return given()
                .body(jsonBody)
                .log().all()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class, ObjectMapperType.GSON);
    }

}
