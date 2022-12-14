package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.AddProjectPage;

public class NavigationSteps extends BaseStep {
    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public void navigateToAddProjectPage() {
        new AddProjectPage(driver).openPageByUrl();
    }
}
