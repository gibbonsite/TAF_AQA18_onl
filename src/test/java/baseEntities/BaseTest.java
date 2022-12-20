package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.WaitsService;
import steps.ProjectSteps;
import steps.UserStep;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected ProjectSteps projectSteps;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowserFactory().getDriver();
        waitsService = new WaitsService(driver);
        driver.get(ReadProperties.getUrl());

        // Solution 1
        iTestContext.setAttribute("driver", driver);
        // Solution 1 - Finish

        userStep = new UserStep(driver);
        projectSteps = new ProjectSteps(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        // Solution - 2: Плохое решение - потому, что Screenshot добавляется в шаг TearDown
        /*
        if (testResult.getStatus() == ITestResult.FAILURE) {
            try {
                byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(srcFile);
            } catch (NoSuchSessionException ex) {

            }
        }
        */
        driver.quit();
    }

    // Solution - 2:
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
    // Solution - 2: Finish
}
