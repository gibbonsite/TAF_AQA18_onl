package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CataloguePage {
    private By addToCartSauceLabsFleeceJacketElementLocator = By.id("add-to-cart-sauce-labs-fleece-jacket");

    public SelenideElement getAddToCartSauceLabsFleeceJacketElement() {
        return $(addToCartSauceLabsFleeceJacketElementLocator).shouldBe(visible);
    }
}
