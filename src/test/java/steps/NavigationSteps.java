package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.AddProjectPage;

public class NavigationSteps extends BaseStep {
    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage navigateToAddProjectPage() {
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.openPageByUrl();
        return addProjectPage;
    }
}
