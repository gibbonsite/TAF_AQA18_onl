package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutOverviewPage extends BasePage {

    private final By finishButtonLocator = By.id("finish");
    private final By paymentInformationElementLocator = By.cssSelector(".summary_value_label:nth-child(2)");
    private final By shippingInformationElementLocator = By.cssSelector(".summary_value_label:nth-child(4)");
    private final By totalPriceElementLocator = By.className("summary_total_label");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return finishButtonLocator;
    }

    public WebElement getPaymentInformationElement() {
        return driver.findElement(paymentInformationElementLocator);
    }

    public WebElement getShippingInformationElement() {
        return driver.findElement(shippingInformationElementLocator);
    }

    public WebElement getTotalPriceElement() {
        return driver.findElement(totalPriceElementLocator);
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }
}
