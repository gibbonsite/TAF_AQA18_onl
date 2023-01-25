package pages.checkout;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {
    private Logger logger = LogManager.getLogger();

    @FindBy(className = "complete-header")
    public WebElement completeHeaderElement;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);

        logger.info("Pattern PageFactory is implemented in class CheckoutCompletePage.");
    }

    @Override
    protected WebElement getPageIdentifierElement() {
        return completeHeaderElement;
    }

}
