package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Блок описания локаторов для элементов
    private final By userNameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");

    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    // Блок атомарных методов
    public WebElement getUserNameInput() { return driver.findElement(userNameInputLocator);}
    public WebElement getPassword() { return driver.findElement(passwordInputLocator);}
    public WebElement getLogInButton() { return driver.findElement(logInButtonLocator);}
}
