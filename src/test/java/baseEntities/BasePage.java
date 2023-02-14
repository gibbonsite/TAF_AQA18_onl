package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitsService = new WaitsService(driver);
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return waitsService.waitForVisibilityBy(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}
