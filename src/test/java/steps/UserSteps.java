package steps;

import baseEntities.BaseStep;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CataloguePage;
import pages.LoginPage;

public class UserSteps extends BaseStep {
    private Logger logger = LogManager.getLogger();
    private LoginPage loginPage;

    public UserSteps(WebDriver driver) {
        super(driver);

        this.loginPage = new LoginPage(driver);
    }

    public void login(String userName, String password) {
        loginPage.userNameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(password);
        loginPage.logInButton.click();
    }

    public CheckoutSteps loginSuccessful(User user) {
        logger.info("In step UserSteps user object is used, which contains the following details: " + user);

        login(user.getEmail(), user.getPassword());

        return new CheckoutSteps(driver);
    }
}
