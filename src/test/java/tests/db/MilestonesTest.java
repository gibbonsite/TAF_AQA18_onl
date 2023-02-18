package tests.db;

import baseEntities.BaseApiTest;
import models.Milestone;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseApiTest {
    private Milestone expectedMilestone;

    @Test
    public void addMilestone() {
        expectedMilestone = Milestone.builder()
                .name("ML_Milestone_01")
                .projectId(expectedProject.getId())
                .description("First milestone.")
                .dueDate(1677142800)
                .startDate(1675933200)
                .build();

        milestoneAdapter.add(expectedMilestone);
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestone() {
        milestoneAdapter.get(expectedMilestone.getId());
    }

    @Test(dependsOnMethods = "getMilestone")
    public void updateMilestone() {
        Milestone updatedMilestone = Milestone.builder()
                .id(expectedMilestone.getId())
                .name("ML_Milestone_02")
                .projectId(expectedMilestone.getProjectId())
                .description("First (updated) milestone.")
                .dueDate(1678784400)
                .startDate(1676365200)
                .build();

        milestoneAdapter.update(updatedMilestone);
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        milestoneAdapter.delete(expectedMilestone.getId());
    }
}
