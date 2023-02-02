package elements;

import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.*;
import services.WaitsService;

import java.util.ArrayList;
import java.util.List;

public class UIElement implements WebElement {
    private WebDriver driver;
    private By by;
    private WebElement webElement;
    private WaitsService waitsService;

    public UIElement(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        this.waitsService = new WaitsService(driver);
        this.webElement = waitsService.waitForExists(by);
    }

    public UIElement(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.waitsService = new WaitsService(driver);
        this.webElement = webElement;
    }

    @Override
    public void click() {
        try {
            webElement.click();
        } catch (ElementNotInteractableException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            webElement.click();
        }
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    public List<UIElement> findUIElements(By by) {
        ArrayList<UIElement> list = new ArrayList<>();
        for (WebElement element : webElement.findElements(by)) {
            list.add(new UIElement(driver, element));
        }

        return list;
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    public UIElement findUIElement(By by) {
        return new UIElement(driver, webElement.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }
}
