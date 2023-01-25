package pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CataloguePage extends BasePage {
    private Logger logger = LogManager.getLogger();

    @FindBy(xpath = "//*[@class='title' and text()='Products']")
    public WebElement titleLabel;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement addToCartSauceLabsFleeceJacketElement;

    public CataloguePage(WebDriver driver) {
        super(driver);

        logger.info("Pattern PageFactory is implemented in class CataloguePage.");
    }

    @Override
    protected WebElement getPageIdentifierElement() {
        return titleLabel;
    }
}
