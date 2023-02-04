package pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {
    private Logger logger = LogManager.getLogger();

    private final static String pagePath = "cart.html";

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);

        logger.info("Pattern PageFactory is implemented in class CartPage.");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected WebElement getPageIdentifierElement() {
        return checkoutButton;
    }
}
