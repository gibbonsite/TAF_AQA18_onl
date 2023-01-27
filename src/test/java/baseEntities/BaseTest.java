package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import steps.UserSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class BaseTest {
    protected UserSteps userSteps;

    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 30000;

        open("");

        userSteps = new UserSteps();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
