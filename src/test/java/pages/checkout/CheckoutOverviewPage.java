package pages.checkout;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutOverviewPage extends BasePage {
    private Logger logger = LogManager.getLogger();

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(css = ".summary_value_label:nth-child(2)")
    public WebElement paymentInformationElement;

    @FindBy(css = ".summary_value_label:nth-child(4)")
    public WebElement shippingInformationElement;

    @FindBy(className = "summary_total_label")
    public WebElement totalPriceElement;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);

        logger.info("Pattern PageFactory is implemented in class CheckoutOverviewPage.");
    }

    @Override
    protected WebElement getPageIdentifierElement() {
        return finishButton;
    }
}
