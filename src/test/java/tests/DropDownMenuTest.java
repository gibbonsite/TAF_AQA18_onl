package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.project.testcases.AddTestCasePage;

public class DropDownMenuTest extends BaseTest {
    @Test
    public void dropDownMenuTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.openProjectOverview("PR-01");
        projectTestCasesSteps.openProjectTestCases();
        AddTestCasePage page = projectTestCasesSteps.proceedToTestCaseCreation();

        page.getType().selectByText("Acceptance");
        page.getType().search("Acc");
        page.getType().showMenu();
    }
}
