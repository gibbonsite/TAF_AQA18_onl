package adapters;

import dbTables.MilestonesTable;
import io.restassured.mapper.ObjectMapperType;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import services.DataBaseService;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MilestoneAdapter {
    private MilestonesTable milestonesTable;
    public MilestoneAdapter(DataBaseService dbService) {
        milestonesTable = new MilestonesTable(dbService);
    }

    public void add(Milestone milestone) {
        int milestoneId = given()
                .pathParam("project_id", milestone.getProjectId())
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(milestone.getName()))
                .body("description", equalTo(milestone.getDescription()))
                .body("due_on", equalTo(milestone.getDueDate()))
                .body("start_on", equalTo(milestone.getStartDate()))
                .extract()
                .jsonPath()
                .getInt("id");
        milestone.setId(milestoneId);

        // Эмулируем создание Milestone в базе данных при работе с API TestRail
        milestonesTable.addMilestone(milestone);
    }

    public void get(int milestoneId) {
        Milestone expectedMilestone = milestonesTable.getMilestoneById(milestoneId);

        given()
                .pathParam("milestone_id", milestoneId)
        .when()
                .get(Endpoints.GET_MILESTONE)
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(expectedMilestone.getName()))
                .body("description", equalTo(expectedMilestone.getDescription()))
                .body("due_on", equalTo(expectedMilestone.getDueDate()))
                .body("start_on", equalTo(expectedMilestone.getStartDate()));
    }

    public void update(Milestone milestone) {
        Milestone actualMilestone = given()
                .pathParam("milestone_id", milestone.getId())
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class, ObjectMapperType.GSON);
        // Эмулируем изменение Milestone в базе данных при работе с API TestRail
        milestonesTable.updateMilestone(milestone);

        Milestone expectedMilestone = milestonesTable.getMilestoneById(milestone.getId());

        Assert.assertEquals(actualMilestone, expectedMilestone);
    }

    public void delete(int milestoneId) {
        given()
                .pathParam("milestone_id", milestoneId)
        .when()
                .post(Endpoints.DELETE_MILESTONE)
        .then()
                .statusCode(HttpStatus.SC_OK);

        // Эмулируем удаление Milestone в базе данных при работе с API TestRail
        milestonesTable.deleteMilestone(milestoneId);

        Milestone expectedMilestone = milestonesTable.getMilestoneById(milestoneId);
        Assert.assertNull(expectedMilestone);
    }
}
