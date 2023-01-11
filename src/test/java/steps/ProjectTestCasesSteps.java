package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.ProjectOverviewPage;
import pages.project.testcases.AddTestCasePage;
import pages.project.testcases.ProjectTestCasesPage;

public class ProjectTestCasesSteps extends BaseStep {
    private ProjectTestCasesPage projectTestCasesPage;

    public ProjectTestCasesSteps(WebDriver driver) {
        super(driver);

        projectTestCasesPage = new ProjectTestCasesPage(driver);
    }

    public ProjectTestCasesPage openProjectTestCases() {
        new ProjectOverviewPage(driver).getTestCasesElement().click();

        return projectTestCasesPage;
    }

    public AddTestCasePage proceedToTestCaseCreation() {
        projectTestCasesPage.getAddTestCaseElement().click();

        return new AddTestCasePage(driver);
    }
}
