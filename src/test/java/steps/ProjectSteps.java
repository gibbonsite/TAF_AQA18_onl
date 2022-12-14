package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.AddProjectPage;

public class ProjectSteps extends BaseStep {
    private AddProjectPage addProjectPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);

        addProjectPage = new AddProjectPage(driver);
    }

    public void addProject(String projectName) {
        new NavigationSteps(driver).navigateToAddProjectPage();
        addProjectPage.getNameInput().sendKeys(projectName);
        addProjectPage.getAddProjectButton().click();
    }

    public void updateProject() {

    }

    public void deleteProject() {

    }
}
