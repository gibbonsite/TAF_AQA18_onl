package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Case;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class CaseAdapter extends BaseAdapter {
    public Case add(Case testCase) {
        return given()
                .pathParam("section_id", testCase.getSectionId())
                .body(testCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Case.class, ObjectMapperType.GSON);
    }

    public Case get(int caseId) {
        return given()
                .pathParam("case_id", caseId)
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Case.class, ObjectMapperType.GSON);
    }

    public Case update(Case testCase) {
        return given()
                .pathParam("case_id", testCase.getId())
                .body(testCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Case.class, ObjectMapperType.GSON);
    }

    public void moveCasesToSection(int destinationSectionId, int destinationSuiteId, List<Case> cases) {
        Map<String, Object> moveCasesToSectionBody = new HashMap<>();
        moveCasesToSectionBody.put("suite_id", destinationSuiteId);
        String caseIdsList = cases.stream()
                .map((testCase) -> String.valueOf(testCase.getId()))
                .collect(Collectors.joining(","));
        moveCasesToSectionBody.put("case_ids", caseIdsList);

        given()
                .pathParam("section_id", destinationSectionId)
                .body(moveCasesToSectionBody)
        .when()
                .post(Endpoints.MOVE_CASES_TO_SECTION)
        .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public void delete(int caseId) {
        given()
                .pathParam("case_id", caseId)
                .when()
                .post(Endpoints.DELETE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
