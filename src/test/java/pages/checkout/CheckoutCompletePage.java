package pages.checkout;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {
    private By completeHeaderElementLocator = By.className("complete-header");

    public boolean isPageOpened() {
        return $(completeHeaderElementLocator).isDisplayed();
    }
}
