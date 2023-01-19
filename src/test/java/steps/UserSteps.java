package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.CataloguePage;
import pages.LoginPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;
    private CheckoutSteps checkoutSteps;

    public UserSteps(WebDriver driver, CheckoutSteps checkoutSteps) {
        super(driver);

        this.loginPage = new LoginPage(driver);
        this.checkoutSteps = checkoutSteps;
    }

    public void login(String userName, String password) {
        loginPage.userNameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(password);
        loginPage.logInButton.click();
    }

    public CheckoutSteps loginSuccessful(User user) {
        login(user.getEmail(), user.getPassword());

        return checkoutSteps;
    }
}
