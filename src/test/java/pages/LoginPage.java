package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    // Блок описания локаторов для эментов
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

    // Блок атомарных методов
    public SelenideElement getEmailInput() { return $(emailInputLocator);}
    public SelenideElement getPassword() { return $(passwordInputLocator);}
    public SelenideElement getLogInButton() { return $(logInButtonLocator); }
    public SelenideElement getErrorTextElement() { return $(errorTextLocator); }
}
