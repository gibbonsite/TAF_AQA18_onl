package pages.project.testcases;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectTestCasesPage extends BasePage {
    private final By contentHeaderTitleElementLocator = By.className("content-header-title");

    private final By addTestCaseElementLocator = By.xpath("//span[. = 'Add Test Case']/..");

    public ProjectTestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return contentHeaderTitleElementLocator;
    }

    public WebElement getAddTestCaseElement() {
        return driver.findElement(addTestCaseElementLocator);
    }
}
