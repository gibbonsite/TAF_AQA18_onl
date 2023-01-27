package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {
    private final static String pagePath = "cart.html";

    private By checkoutButtonLocator = By.id("checkout");

    public void openPageByUrl() {
        open(pagePath);
    }

    public SelenideElement getCheckoutButton() {
        return $(checkoutButtonLocator).shouldBe(visible);
    }
}
