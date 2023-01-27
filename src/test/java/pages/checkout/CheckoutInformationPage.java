package pages.checkout;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutInformationPage {
    private By continueButtonLocator = By.id("continue");

    private By firstNameInputLocator = By.id("first-name");

    private By lastNameInputLocator = By.id("last-name");

    private By postalCodeInputLocator = By.id("postal-code");

    public SelenideElement getContinueButton() {
        return $(continueButtonLocator).shouldBe(visible);
    }

    public SelenideElement getFirstNameInput() {
        return $(firstNameInputLocator).shouldBe(visible);
    }

    public SelenideElement getLastNameInput() {
        return $(lastNameInputLocator).shouldBe(visible);
    }

    public SelenideElement getPostalCodeInput() {
        return $(postalCodeInputLocator).shouldBe(visible);
    }
}
