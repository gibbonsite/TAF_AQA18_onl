package pages.checkout;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage {
    private Logger logger = LogManager.getLogger();

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "first-name")
    public WebElement firstNameInput;

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);

        logger.info("Pattern PageFactory is implemented in class CheckoutInformationPage.");
    }

    @Override
    protected WebElement getPageIdentifierElement() {
        return continueButton;
    }
}
