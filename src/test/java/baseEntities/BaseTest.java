package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.WaitsService;
import steps.ProjectSteps;
import steps.UserStep;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected ProjectSteps projectSteps;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
        waitsService = new WaitsService(driver);
        //driver.get(ReadProperties.getUrl());

        userStep = new UserStep(driver);
        projectSteps = new ProjectSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
