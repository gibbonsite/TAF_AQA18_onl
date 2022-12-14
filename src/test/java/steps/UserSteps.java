package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CataloguePage;
import pages.LoginPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;

    public UserSteps(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String userName, String password) {
        loginPage.getUserNameInput().sendKeys(userName);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLogInButton().click();
    }

    public CataloguePage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new CataloguePage(driver);
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }
}
