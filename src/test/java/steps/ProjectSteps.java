package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.project.testcases.ProjectTestCasesPage;

public class ProjectSteps extends BaseStep {
    private DashboardPage dashboardPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);

        dashboardPage = new DashboardPage(driver);
    }

    public ProjectTestCasesPage openProjectOverview(String projectName) {
        dashboardPage.getProjectElement(projectName).click();

        return new ProjectTestCasesPage(driver);
    }
}
