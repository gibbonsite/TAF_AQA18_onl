package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.CheckoutSteps;
import steps.NavigationSteps;
import steps.ProjectSteps;
import steps.UserSteps;

public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userStep;
    protected ProjectSteps projectSteps;
    protected NavigationSteps navigationSteps;
    protected CheckoutSteps checkoutSteps;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());

        userStep = new UserSteps(driver);
        projectSteps = new ProjectSteps(driver);
        navigationSteps = new NavigationSteps(driver);
        checkoutSteps = new CheckoutSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
