package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.project.AddProjectPage;
import steps.NavigationSteps;

public class LoginTest extends BaseTest {

    @Test(description = "Description")
    @Issue("AQA18-12")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://onliner.by")
    @Link(name = "catalog", type = "mylink", url = "https://onliner.by")
    @Severity(SeverityLevel.BLOCKER)
    public void loginSuccessfulTest() {
        User user = new User.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();

        Assert.assertTrue(
                userStep.loginSuccessful(user)
                        .isPageOpened()
        );
    }

    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "sdfsdfsdf")
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }

    // Добавил комментарий
    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
        page.getType().selectByText("Use a single repository for all cases (recommended)");
    }
}
