package pages;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    // Блок описания локаторов для эментов
    @FindBy(id = "name")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "button_primary")
    public WebElement logInButton;

    @FindBy(className = "error-text")
    WebElement errorText;

    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
