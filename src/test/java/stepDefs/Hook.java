package stepDefs;

import baseEntities.BaseCucumberTest;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Before
    public void initScenario(Scenario scenario) {
        System.out.println("HOOK: Start browser...");

        baseCucumberTest.driver = new BrowserFactory().getDriver();
    }

    @After
    public void completeScenario(Scenario scenario) {
        if (baseCucumberTest.driver != null) {
            baseCucumberTest.driver.quit();
        }
    }
}
