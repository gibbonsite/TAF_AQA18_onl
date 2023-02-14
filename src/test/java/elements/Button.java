package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
    private UIElement uiElement;

    public Button(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public Button(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public void click() {
        uiElement.click();
    }

    public boolean isEnabled() {
        return uiElement.isEnabled();
    }

}
