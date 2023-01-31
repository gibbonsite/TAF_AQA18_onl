package steps;

import io.qameta.allure.Step;
import models.User;
import pages.DashboardPage;
import pages.LoginPage;

public class UserStep {
    private LoginPage loginPage;

    public UserStep() {
        loginPage = new LoginPage();
    }

    public void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassword().val(psw);
        loginPage.getLogInButton().click();
    }

    @Step
    public DashboardPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new DashboardPage();
    }

    @Step
    public DashboardPage loginSuccessful(User user) {
        return loginSuccessful(user.getEmail(), user.getPassword());
    }
}
