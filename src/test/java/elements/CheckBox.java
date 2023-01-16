package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void setFlag() {
        click(true);
    }

    public void removeFlag() {
        click(false);
    }

    public boolean isSelected() {
        return uiElement.isSelected();
    }

    private void click(boolean flag) {
        if (flag != isSelected()) {
            uiElement.click();
        }
    }
}
