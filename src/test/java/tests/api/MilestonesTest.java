package tests.api;

import baseEntities.BaseApiTest;
import models.Milestone;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseApiTest {
    private int milestoneId;
    private Milestone expectedMilestone;

    @Test
    public void addMilestone() {
        expectedMilestone = Milestone.builder()
                .name("ML_Milestone_01")
                .description("First milestone.")
                .projectId(expectedProject.getId())
                .dueDate(1677142800)
                .startDate(1675933200)
                .build();

        milestoneId = milestoneAdapter.add(expectedMilestone);
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestone() {
        milestoneAdapter.get(milestoneId, expectedMilestone);
    }

    @Test(dependsOnMethods = "getMilestone")
    public void updateMilestone() {
        Milestone updatedMilestone = Milestone.builder()
                .id(milestoneId)
                .name("ML_Milestone_02")
                .description("First (updated) milestone.")
                .projectId(expectedProject.getId())
                .dueDate(1678784400)
                .startDate(1676365200)
                .build();

        milestoneAdapter.update(updatedMilestone);
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        milestoneAdapter.delete(milestoneId);
    }
}
