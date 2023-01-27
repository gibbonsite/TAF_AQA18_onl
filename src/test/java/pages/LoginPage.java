package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private By userNameInputLocator = By.id("user-name");

    private By passwordInputLocator = By.id("password");

    private By logInButtonLocator = By.id("login-button");

    public SelenideElement getUserNameInput() {
        return $(userNameInputLocator).shouldBe(visible);
    }

    public SelenideElement getPasswordInput() {
        return $(passwordInputLocator).shouldBe(visible);
    }

    public SelenideElement getLogInButton() {
        return $(logInButtonLocator).shouldBe(visible);
    }
}
