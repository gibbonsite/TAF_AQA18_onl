package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.project.AddProjectPage;

public class ProjectSteps extends BaseStep {
    private AddProjectPage addProjectPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);

        addProjectPage = new AddProjectPage(driver);
    }

    public void addProject(Project project) {
        new NavigationSteps(driver).navigateToAddProjectPage();
        addProjectPage.getNameInput().sendKeys(project.getName());
        addProjectPage.getAddProjectButton().click();
    }

    public void updateProject() {

    }

    public void deleteProject() {

    }
}
