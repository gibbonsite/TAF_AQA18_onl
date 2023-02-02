package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import steps.UserStep;

public class FirstStepDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public FirstStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("открыт браузер")
    public void startBrowser() {
        driver = new BrowserFactory().getDriver();
    }

/*
    @After
    public void tearDown() {
        driver.quit();
    }
*/

    @When("страца логина открыта")
    @Given("дубликат шага")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
    }

    @Then("поле username отображается")
    public void isUsernameDisplayed() {
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @Then("ошибка не оботражается")
    public void isErrorDisplayed() {
        Assert.assertFalse(loginPage.getErrorTextElement().isDisplayed());
    }

    @Then("поле password отображается")
    public void isPasswordDisplayed() {
        Assert.assertTrue(loginPage.getPassword().isDisplayed());
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        UserStep userStep = new UserStep(driver);
        dashboardPage = userStep.loginSuccessful(username, password);
    }

    @Then("title is {string}")
    public void titleIs(String value) {
        Assert.assertEquals(value, dashboardPage.getTitle());
    }

    @And("project id is {int}")
    public void projectIdIs(int value) {
        Assert.assertEquals(value, 123);
    }
}
