package pages.checkout;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {
    private By completeHeaderElementLocator = By.className("complete-header");

    public SelenideElement getCompleteHeaderElement() {
        return $(completeHeaderElementLocator);
    }
}
