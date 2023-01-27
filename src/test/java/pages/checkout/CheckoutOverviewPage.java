package pages.checkout;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {
    private By finishButtonLocator = By.id("finish");

    public SelenideElement getFinishButton() {
        return $(finishButtonLocator).shouldBe(visible);
    }
}
