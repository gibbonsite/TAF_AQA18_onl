package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "complete-header")
    public WebElement completeHeaderElement;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifierElement() {
        return completeHeaderElement;
    }

}
