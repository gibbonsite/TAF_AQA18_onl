package pages.project;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectOverviewPage extends BasePage {
    private final By testCasesElementLocator = By.id("navigation-suites");

    public ProjectOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public WebElement getTestCasesElement() {
        return driver.findElement(testCasesElementLocator);
    }

}
