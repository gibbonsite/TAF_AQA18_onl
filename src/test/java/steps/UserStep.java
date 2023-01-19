package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class UserStep extends BaseStep {
    private LoginPage loginPage;

    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String email, String psw) {
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(psw);
        loginPage.logInButton.click();
    }

    @Step
    public DashboardPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new DashboardPage(driver);
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }
}
