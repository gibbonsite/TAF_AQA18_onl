package pages;

import baseEntities.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifierElement() {
        return logInButton;
    }
}
