package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {

    private final static String pagePath = "cart.html";

    private final By checkoutButtonLocator = By.id("checkout");
    private final By cartQuantityElementLocator = By.className("cart_quantity");
    private final By inventoryItemNameElementLocator = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutButtonLocator;
    }

    public List<WebElement> getCartQuantityElements() {
        return driver.findElements(cartQuantityElementLocator);
    }

    public List<WebElement> getInventoryItemNameElements() {
        return driver.findElements(inventoryItemNameElementLocator);
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButtonLocator);
    }
}
