package baseEntities;

import org.openqa.selenium.WebDriver;
import steps.NavigationSteps;

public class BaseStep {
    protected WebDriver driver;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
    }
}
