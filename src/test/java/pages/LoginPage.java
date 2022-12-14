package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Блок описания локаторов для эментов
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    // Блок атомарных методов
    public WebElement getEmailInput() { return driver.findElement(emailInputLocator);}
    public WebElement getPassword() { return driver.findElement(passwordInputLocator);}
    public WebElement getLogInButton() { return driver.findElement(logInButtonLocator);}
    public WebElement getErrorTextElement() { return driver.findElement(errorTextLocator); }
}
