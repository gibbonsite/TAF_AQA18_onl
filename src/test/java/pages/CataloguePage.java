package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CataloguePage extends BasePage {
    private final static String pagePath = "inventory.html";

    private final By titleLabelLocator = By.xpath("//*[@class='title' and text()='Products']");
    private final By addToCartSauceLabsFleeceJacketElementLocator = By.id("add-to-cart-sauce-labs-fleece-jacket");

    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    public CataloguePage(WebDriver driver, boolean openPageByUrl) {
        super(driver);

        if (openPageByUrl) {
            openPageByUrl();
        }
    }

    @Override
    protected By getPageIdentifier() {
        return titleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getAddToCartSauceLabsFleeceJacketElement() {
        return driver.findElement(addToCartSauceLabsFleeceJacketElementLocator);
    }
}
