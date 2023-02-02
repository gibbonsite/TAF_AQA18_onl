package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Then;

public class SecondStepdefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public SecondStepdefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Then("открыть страницу настроек")
    public void openSetupPage() {
        driver.get(ReadProperties.getUrl() + "index.php?/admin/overview");
    }
}
