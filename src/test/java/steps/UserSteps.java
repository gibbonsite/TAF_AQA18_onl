package steps;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;

public class UserSteps {
    private Logger logger = LogManager.getLogger();
    private LoginPage loginPage;

    public UserSteps() {
        loginPage = new LoginPage();
    }

    public void login(String userName, String password) {
        loginPage.getUserNameInput().setValue(userName);
        loginPage.getPasswordInput().setValue(password);
        loginPage.getLogInButton().click();
    }

    public CheckoutSteps loginSuccessful(User user) {
        logger.info("In step UserSteps user object is used, which contains the following details: " + user);

        login(user.getEmail(), user.getPassword());

        return new CheckoutSteps();
    }
}
